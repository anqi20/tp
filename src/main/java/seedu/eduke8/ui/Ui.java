package seedu.eduke8.ui;

import seedu.eduke8.bookmark.BookmarkList;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.hint.Hint;
import seedu.eduke8.note.Note;
import seedu.eduke8.option.Option;
import seedu.eduke8.question.Question;
import seedu.eduke8.topic.Topic;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final int LAST_OPTION = 4;
    private static final String TEXTBOOK_WEBSITE =
            "https://nus-cs2113-ay2021s1.github.io/website/se-book-adapted/index.html";

    private static final String LOGO = " _____        _____\n"
            + "|  ___| ____ |  _  |\n"
            + "| |___ |  _ \\| |_| |\n"
            + "|  ___|| | | |  _  |\n"
            + "| |___ | |_| | |_| |\n"
            + "|_____||____/|_____|";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String HORIZONTAL_LINE = "-------------------------------------------------------------------"
            + "-----------------------------------------------------";
    private static final String HORIZONTAL_LINE_FOR_TOPICAL_STATS_FIELDS = "---------------"
            + "---------------------------  ";
    private static final String MESSAGE_ABOUT = "E-Duke-8 is a desktop app that helps CS2113/T students learn and"
            + System.lineSeparator() + "understand software engineering and OOP principles through a"
            + System.lineSeparator() + "gamified platform and enhances their " + "learning experience."
            + System.lineSeparator()
            + System.lineSeparator() + "You can attempt bite-sized quizzes based on your choice of topic"
            + System.lineSeparator() + "and access key concepts for easy revision!";
    private static final String MESSAGE_GREETINGS = "Hello! I'm E-Duke-8!" + System.lineSeparator()
            + "What would you like to learn today?";
    private static final String MESSAGE_EXIT = "Bye bye. Hope you had a fruitful revision and see you soon!";
    private static final String MESSAGE_HELP = "These are the commands that you can use:"
            + System.lineSeparator() + "1) about"
            + System.lineSeparator() + "2) help"
            + System.lineSeparator() + "3) topics"
            + System.lineSeparator() + "4) textbook"
            + System.lineSeparator() + "5) quiz t/<topic> n/<number of questions>"
            + System.lineSeparator() + "6) bookmark"
            + System.lineSeparator() + "7) stats"
            + System.lineSeparator() + "8) exit";
    private static final String MESSAGE_QUIZ_START = "Start of quiz:";
    private static final String MESSAGE_QUIZ_END = "This is the end of the quiz!"
            + System.lineSeparator() + "Hope you have learnt something new!";
    private static final String MESSAGE_ANSWER_WRONG = "Oops! The correct answer is ";
    private static final String MESSAGE_ANSWER_WRONG_SECOND = "! Do visit the textbook to read up more.";
    private static final String MESSAGE_ANSWER_CORRECT = "Great Job! That is the correct answer! Keep it up!";
    private static final String MESSAGE_TEXTBOOK = "The textbook for this module is available at:"
            + System.lineSeparator() + TEXTBOOK_WEBSITE;
    private static final String MESSAGE_HINT = "Hint: ";
    private static final String POINT_SYSTEM_RULE = "Point system in E-Duke-8: For correct answers, "
            + "you earn 2 points if you did not request for hint, "
            + System.lineSeparator() + "and 1 point if you did. No point is awarded for wrong answers.";
    private static final String MESSAGE_GET_INPUT_FROM_USER = "Enter your command or 'help': ";
    private static final String MESSAGE_GET_INPUT_FROM_USER_QUIZ = "Enter your answer, 'hint' or 'bookmark': ";
    private static final String MESSAGE_PRINT_TOPIC_LIST = "These are the available topics and the number of "
            + "available questions in each:";
    private static final String MESSAGE_EXPLANATION = "Explanation:";
    private static final String MESSAGE_PRINT_NOTE_LIST_NONE = "There are no notes for this topic!";
    private static final String MESSAGE_PRINT_NOTE_LIST = "These are the notes for this topic: ";
    private static final String MESSAGE_QUIZ_TOPIC_CHOSEN = "The chosen topic is: ";
    private static final String MESSAGE_QUIZ_QUESTION_CHOSEN = "You have chosen to complete ";
    private static final String MESSAGE_QUIZ_QUESTION_CHOSEN_SECOND = " question";
    private static final String MESSAGE_BOOKMARK_INDICATOR = "Bookmarked this question!";
    private static final String MESSAGE_BOOKMARK_LIST = "This is your list of bookmarks: ";
    private static final String CLOSE_BRACKET = ") ";
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String CLOSE_SQUARE_BRACKET = "] ";
    private static final String DOT = ".";
    private static final String DOT_SPACE = ". ";
    private static final String DOT_PLURAL = "s.";
    private static final String MESSAGE_SHOW_POINTS = "You have earned ";
    private static final String MESSAGE_SHOW_POINTS_SECOND = " points out of a total of ";
    private static final String MESSAGE_SHOW_POINTS_THIRD = " points available!";
    private static final String MESSAGE_USER_PROGRESS = "Therefore, your E-Duke-8 progress is ";
    private static final String MESSAGE_PRAISE = "Good job! Keep it up!";
    private static final String MESSAGE_MOTIVATE = "Let's do some quizzes!";
    private static final String TOPICS_PROGRESSION_SECTION_HEADER = "Topics' Progression";
    private static final String OUT_OF_SYMBOL = "/";
    private static final String MESSAGE_QUESTIONS_DONE = " questions done";
    private static final String MESSAGE_CORRECT_QUESTIONS_ANSWERED = " questions correctly answered";
    private static final String MESSAGE_HINT_USED_SINGULAR = " hint used";
    private static final String MESSAGE_HINT_USED_PLURAL = " hints used";
    private static final String MESSAGE_POINTS_EARNED_OUT_OF = " points earned / ";
    private static final String PERCENTAGE_SIGN = "%";
    private static final String MESSAGE_AVAILABLE_WORD = " available ";


    public String getInputFromUser() {
        System.out.print(MESSAGE_GET_INPUT_FROM_USER);
        return SCANNER.nextLine();
    }

    public void printQuizMessagePrompt() {
        System.out.println(MESSAGE_GET_INPUT_FROM_USER_QUIZ);
    }

//    public String getQuizInputFromUser() {
//        return SCANNER.nextLine();
//    }

    private static void printMessage(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(message);
        System.out.println(HORIZONTAL_LINE);
    }

    public void printGreetMessage() {
        System.out.println(LOGO);
        printMessage(MESSAGE_GREETINGS);
    }

    public void printExitMessage() {
        printMessage(MESSAGE_EXIT);
    }

    public void printOption(Option option, int optionNumber) {
        System.out.println(optionNumber + CLOSE_BRACKET + option.getDescription());
        if (optionNumber == LAST_OPTION) {
            System.out.println(HORIZONTAL_LINE);
        }
    }

    public void printQuestion(Question question, int questionNumber) {
        System.out.println(questionNumber + ". " + question.getDescription() + System.lineSeparator());
    }

    public void printHint(Hint hint) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_HINT + hint.getDescription());
        System.out.println(HORIZONTAL_LINE);
    }

    public void printStartQuizPage(int numberOfQuestionsChosen, String topicsChosen) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_QUIZ_START);

        //Shows the number of questions chosen by user
        printStartQuizQuestions(numberOfQuestionsChosen);

        //Shows the topics chosen by user
        System.out.println(MESSAGE_QUIZ_TOPIC_CHOSEN + topicsChosen);

        System.out.println(HORIZONTAL_LINE);
    }

    public void printEndQuizPage() {
        System.out.println(MESSAGE_QUIZ_END);
        System.out.println(HORIZONTAL_LINE);
    }

    public void printAnswerIsWrong(int correctAnswer, String explanation) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_ANSWER_WRONG + correctAnswer + MESSAGE_ANSWER_WRONG_SECOND);
        System.out.println(System.lineSeparator() + MESSAGE_EXPLANATION + System.lineSeparator() + explanation);
        System.out.println(HORIZONTAL_LINE);
        System.out.println(HORIZONTAL_LINE);
    }

    public void printAnswerIsCorrect(String explanation) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_ANSWER_CORRECT);
        System.out.println(System.lineSeparator() + MESSAGE_EXPLANATION + System.lineSeparator() + explanation);
        System.out.println(HORIZONTAL_LINE);
        System.out.println(HORIZONTAL_LINE);
    }

    public void printHelp() {
        printMessage(MESSAGE_HELP);
    }

    public void printAbout() {
        printMessage(MESSAGE_ABOUT);
    }

    public void printTextbook() {
        printMessage(MESSAGE_TEXTBOOK);
    }

    public void printError(String errorMessage) {
        printMessage(errorMessage);
    }

    public void printTopicList(ArrayList<Displayable> topics) {
        System.out.println(HORIZONTAL_LINE);

        System.out.println(MESSAGE_PRINT_TOPIC_LIST);
        for (int i = 0; i < topics.size(); i++) {
            Topic topic = (Topic) topics.get(i);
            System.out.println(OPEN_SQUARE_BRACKET + topic.getQuestionList().getCount() + CLOSE_SQUARE_BRACKET
                    + topic.getDescription());
        }

        System.out.println(HORIZONTAL_LINE);
    }

    public void printNoteList(ArrayList<Displayable> notes) {

        if (notes.size() == 0) {
            System.out.println(MESSAGE_PRINT_NOTE_LIST_NONE);
        } else {
            System.out.println(MESSAGE_PRINT_NOTE_LIST);
            for (int i = 0; i < notes.size(); i++) {
                System.out.println(HORIZONTAL_LINE);
                Note note = (Note) notes.get(i);
                System.out.println(i + DOT + note.getDescription());
            }
        }

        System.out.println(HORIZONTAL_LINE);
    }

    private void printStartQuizQuestions(int numberOfQuestionsChosen) {
        System.out.print(MESSAGE_QUIZ_QUESTION_CHOSEN + numberOfQuestionsChosen + MESSAGE_QUIZ_QUESTION_CHOSEN_SECOND);
        if (numberOfQuestionsChosen < 2) {
            System.out.println(DOT);
        } else {
            System.out.println(DOT_PLURAL);
        }
    }

    public void printPointSystemRules() {
        System.out.println(POINT_SYSTEM_RULE + System.lineSeparator());
    }

    public void printPointsEarned(int pointsEarned, int pointsAvailable) {
        System.out.println(MESSAGE_SHOW_POINTS + pointsEarned + MESSAGE_SHOW_POINTS_SECOND
                + pointsAvailable + MESSAGE_SHOW_POINTS_THIRD);
    }

    public void printTotalProgression(int progressionLevelPercentage, boolean progressOverHalf) {
        System.out.print(MESSAGE_USER_PROGRESS + progressionLevelPercentage + PERCENTAGE_SIGN + DOT_SPACE);
        if (progressOverHalf) {
            System.out.println(MESSAGE_PRAISE + System.lineSeparator());
        } else {
            System.out.println(MESSAGE_MOTIVATE + System.lineSeparator());
        }
    }

    public void printTopicProgressionHeader() {
        System.out.println(TOPICS_PROGRESSION_SECTION_HEADER);
        System.out.println(HORIZONTAL_LINE);
    }

    public void printTopicDescriptionForStats(Displayable topic) {
        System.out.println(topic.getDescription());
    }

    public void printTopicCompletionLevel(int questionsAttempted, int questionsTotal) {
        System.out.println(HORIZONTAL_LINE_FOR_TOPICAL_STATS_FIELDS + questionsAttempted
                + OUT_OF_SYMBOL + questionsTotal + MESSAGE_QUESTIONS_DONE);
    }

    public void printTopicAccuracyLevel(int questionsAnsweredCorrectly, int questionsAttempted) {
        System.out.println(HORIZONTAL_LINE_FOR_TOPICAL_STATS_FIELDS + questionsAnsweredCorrectly + OUT_OF_SYMBOL
                + questionsAttempted + MESSAGE_CORRECT_QUESTIONS_ANSWERED);
    }

    public void printTopicalHintUsage(int hintUsage) {
        System.out.println(HORIZONTAL_LINE_FOR_TOPICAL_STATS_FIELDS + hintUsage
                + (hintUsage <= 1 ? MESSAGE_HINT_USED_SINGULAR : MESSAGE_HINT_USED_PLURAL));
    }

    public void printTopicalPoints(int pointsEarned, int pointsAvailable, int progressionPercentage) {
        System.out.println(HORIZONTAL_LINE_FOR_TOPICAL_STATS_FIELDS + pointsEarned + MESSAGE_POINTS_EARNED_OUT_OF
                + pointsAvailable + MESSAGE_AVAILABLE_WORD + OPEN_SQUARE_BRACKET
                + progressionPercentage + PERCENTAGE_SIGN + CLOSE_SQUARE_BRACKET);
    }

    public void printBookmarkedIndicator() {
        printMessage(MESSAGE_BOOKMARK_INDICATOR);
    }

    public void printListOfBookmarkedQuestions(BookmarkList bookmarks) {
        String list = listOfBookmarkedQuestions(bookmarks);

        System.out.println(HORIZONTAL_LINE);
        System.out.println(MESSAGE_BOOKMARK_LIST);
        System.out.println(list);
        System.out.println(HORIZONTAL_LINE);
    }

    private String listOfBookmarkedQuestions(BookmarkList bookmarks) {
        int i = 1;
        ArrayList<Displayable> allBookmarks;
        allBookmarks = bookmarks.getInnerList();
        String output = "";
        for (Displayable question : allBookmarks) {
            String optionOutput = "";
            Question properQuestion = (Question) question;
            ArrayList<Displayable> optionsAvailable = properQuestion.getOptionList().getInnerList();
            int j = 1;
            for (Displayable option : optionsAvailable) {
                optionOutput += "\n    " + j + CLOSE_BRACKET + option.getDescription()
                        + ((j == optionsAvailable.size()) ? "\n" : "");
                j++;
            }
            output += i + DOT_SPACE + question.getDescription() + optionOutput + " "
                    + ((i == allBookmarks.size()) ? "" : "\n");
            i++;
        }
        return output;
    }
}
