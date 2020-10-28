package seedu.eduke8.parser;

import seedu.eduke8.bookmark.BookmarkList;
import seedu.eduke8.command.Command;
import seedu.eduke8.command.AnswerCommand;
import seedu.eduke8.command.BookmarkCommand;
import seedu.eduke8.command.IncorrectCommand;
import seedu.eduke8.command.HintCommand;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.option.Option;
import seedu.eduke8.question.Question;

import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_ANSWER_NOT_INDEX;
import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_ANSWER_INDEX_OUT_OF_BOUNDS;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parses user input during a quiz activity.
 */
public class QuizParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String COMMAND_HINT = "hint";
    private static final String COMMAND_BOOKMARK = "bookmark";
    private static final String BOOKMARK_STORE = "storing";

    private Question question;
    private BookmarkList bookmarks;

    public QuizParser(BookmarkList bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void setQuestion(Question question) {
        assert question != null;

        this.question = question;
    }

    /**
     * Parses the user input.
     *
     * @param optionList the option list that contains the list of options available for the current question
     * @param userInput  the string input typed by the user
     * @return a Command object which when executed will carry out the appropriate action
     */
    @Override
    public Command parseCommand(DisplayableList optionList, String userInput) {
        if (COMMAND_HINT.equals(userInput)) {
            LOGGER.log(Level.INFO, "Parsing complete: hint command chosen.");
            return new HintCommand(question.getHint());
        } else if (COMMAND_BOOKMARK.equals(userInput)) {
            LOGGER.log(Level.INFO, "Parsing complete: bookmark command chosen.");
            return new BookmarkCommand(question, BOOKMARK_STORE, bookmarks);
        } else if("".equals(userInput)) {
            return new IncompleteCommand(question, 10);
        }

        try {
            ArrayList<Displayable> options = optionList.getInnerList();
            int chosenIndex = Integer.parseInt(userInput) - 1;
            Option chosenOption = (Option) options.get(chosenIndex);

            return new AnswerCommand(chosenOption, question);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "A non-number was given when answering question.");
            return new IncorrectCommand(ERROR_QUIZ_ANSWER_NOT_INDEX);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.log(Level.WARNING, "An index out of bounds was given when answering question.");
            return new IncorrectCommand(ERROR_QUIZ_ANSWER_INDEX_OUT_OF_BOUNDS);
        }
    }
}
