package seedu.eduke8.quiz;

import seedu.eduke8.bookmark.BookmarkList;
import seedu.eduke8.command.Command;
import seedu.eduke8.command.AnswerCommand;
import seedu.eduke8.command.IncorrectCommand;
import seedu.eduke8.command.BookmarkCommand;
import seedu.eduke8.command.HintCommand;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.exception.Eduke8Exception;
import seedu.eduke8.option.Option;
import seedu.eduke8.option.OptionList;
import seedu.eduke8.parser.QuizParser;
import seedu.eduke8.question.Question;
import seedu.eduke8.question.QuestionList;
import seedu.eduke8.question.QuizQuestionsManager;
import seedu.eduke8.topic.Topic;
import seedu.eduke8.ui.Ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleTopicQuiz implements Quiz {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Topic topic;
    private int numberOfQuestions;
    private QuizParser quizParser;
    private BookmarkList bookmarks;
    private int timer;

    boolean nextQuestion = true;

    public SingleTopicQuiz(Topic topic, int numberOfQuestions, BookmarkList bookmarks, int timer) {
        assert topic != null;

        this.topic = topic;
        this.numberOfQuestions = numberOfQuestions;
        this.bookmarks = bookmarks;
        this.timer = timer;
        quizParser = new QuizParser(bookmarks);
    }

    /**
     * Starts a quiz with a single topic.
     *
     * @param ui  Ui to print quiz messages.
     * @throws Eduke8Exception if numberOfQuestions used to construct QuizQuestionsManager <= 0
     *     or > number of question in the topic.
     */
    @Override
    public void startQuiz(Ui ui) throws Eduke8Exception {
        LOGGER.log(Level.INFO, "New quiz started.");

        QuestionList topicQuestionList = topic.getQuestionList();

        QuizQuestionsManager quizQuestionsManager =
                new QuizQuestionsManager(numberOfQuestions, topicQuestionList.getInnerList());

        assert !quizQuestionsManager.areAllQuestionsAnswered();

        ui.printStartQuizPage(numberOfQuestions, topic.getDescription());

        try{
            goThroughQuizQuestions(ui, quizQuestionsManager);
        } catch (IOException e) {
            System.out.println("IO error");
        }

        ui.printEndQuizPage();

        LOGGER.log(Level.INFO, "Quiz ended.");
    }

    private void goThroughQuizQuestions(Ui ui, QuizQuestionsManager quizQuestionsManager) throws IOException {
        while ((!quizQuestionsManager.areAllQuestionsAnswered()) && nextQuestion) {
            Question question = quizQuestionsManager.getNextQuestion();
            ui.printQuestion(question, quizQuestionsManager.getCurrentQuestionNumber());
            nextQuestion = false;

            question.markAsShown();
            assert question.wasShown();

            OptionList optionList = question.getOptionList();

            ArrayList<Displayable> options = optionList.getInnerList();

            for (int i = 0; i < options.size(); i++) {
                ui.printOption((Option) options.get(i), i + 1);
            }

            quizParser.setQuestion(question);
            ui.printQuizMessagePrompt();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            String userInput = "";

            while (!input.ready()) {
                if ((System.currentTimeMillis() - startTime) > timer*1000) {

                    Command command = getCommand(optionList, userInput);
                    command.execute(optionList, ui);
                    nextQuestion = true;
                    break;
                }
            }

            while (!nextQuestion) {
                userInput = input.readLine();
                Command command = getCommand(optionList, userInput);

                assert (command instanceof AnswerCommand || command instanceof HintCommand
                        || command instanceof BookmarkCommand);

                //Within 10 sec + incorrect answer
                while (!(command instanceof AnswerCommand) && (System.currentTimeMillis() - startTime) <= timer*1000) {
                    command.execute(optionList, ui);
                    command = getCommand(optionList, userInput);
                    if (command instanceof IncorrectCommand) {
                        LOGGER.log(Level.INFO, "Invalid answer given for question");
                    } else if (command instanceof HintCommand) {
                        LOGGER.log(Level.INFO, "Hint shown");
                    } else {
                        LOGGER.log(Level.INFO, "Question bookmarked");
                    }
                }

                LOGGER.log(Level.INFO, "Question answered");

                if (command instanceof AnswerCommand) {
                    nextQuestion = true;
                }

                command.execute(optionList, ui);
            }
        }
    }

    private Command getCommand(OptionList optionList, String userInput) {
        return quizParser.parseCommand(optionList, userInput);
    }
}
