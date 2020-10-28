package seedu.eduke8.parser;

import seedu.eduke8.bookmark.BookmarkList;
import seedu.eduke8.command.AboutCommand;
import seedu.eduke8.command.BookmarkCommand;
import seedu.eduke8.command.Command;
import seedu.eduke8.command.ExitCommand;
import seedu.eduke8.command.HelpCommand;
import seedu.eduke8.command.IncorrectCommand;
import seedu.eduke8.command.QuizCommand;
import seedu.eduke8.command.StatsCommand;
import seedu.eduke8.command.TextbookCommand;
import seedu.eduke8.command.TopicsCommand;
import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.topic.TopicList;
import seedu.eduke8.ui.Ui;


import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_WRONG_FORMAT;
import static seedu.eduke8.exception.ExceptionMessages.ERROR_UNRECOGNIZED_COMMAND;

/**
 * Parses user input from the main menu, in order to execute the correct option.
 */
public class MenuParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String TOPICS_INDICATOR = "t/";
    private static final String NUMBER_OF_QUESTIONS_INDICATOR = "n/";
    private static final String TIMER_INDICATOR = "timer/";
    private static final String BOOKMARK_LIST = "listing";
    private static final String COMMAND_ABOUT = "about";
    private static final String COMMAND_HELP = "help";
    private static final String COMMAND_TOPICS = "topics";
    private static final String COMMAND_TEXTBOOK = "textbook";
    private static final String COMMAND_QUIZ = "quiz";
    private static final String COMMAND_BOOKMARK = "bookmark";
    private static final String COMMAND_EXIT = "exit";

    private BookmarkList bookmarks;

    public MenuParser(BookmarkList bookmarks) {
        this.bookmarks = bookmarks;
    }

    /**
     * Parses the user input.
     *
     * @param topicList the topic list that contains the list of topics available in storage
     * @param userInput the string input typed by the user
     * @return a Command object which when executed will carry out the appropriate action
     */
    @Override
    public Command parseCommand(DisplayableList topicList, String userInput) {
        assert topicList != null;


        LOGGER.log(Level.INFO, "Begin parsing command.");
        String[] commandArr = userInput.trim().split(" ", 0);

        Ui ui = new Ui();
        switch (commandArr[0]) {
        case COMMAND_ABOUT:
            LOGGER.log(Level.INFO, "Parsing complete: about command chosen.");
            return new AboutCommand();
        case COMMAND_HELP:
            LOGGER.log(Level.INFO, "Parsing complete: help command chosen.");
            return new HelpCommand();
        case COMMAND_TOPICS:
            LOGGER.log(Level.INFO, "Parsing complete: topics command chosen.");
            return new TopicsCommand();
        case COMMAND_TEXTBOOK:
            LOGGER.log(Level.INFO, "Parsing complete: textbook command chosen.");
            return new TextbookCommand();
        case COMMAND_QUIZ:
            int numOfQuestions = 0;
            String topicName = "";
            int timer = 0;

            try {
                if (commandArr[1].contains(TIMER_INDICATOR)) {
                    if (commandArr[2].contains(NUMBER_OF_QUESTIONS_INDICATOR))  {
                        numOfQuestions = Integer.parseInt(
                                commandArr[2].substring(commandArr[2].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[3].substring(commandArr[3].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[1].substring(commandArr[1].indexOf(TIMER_INDICATOR) + 6));

                    } else if (commandArr[2].contains(TOPICS_INDICATOR)) {
                        numOfQuestions = Integer.parseInt(
                                commandArr[3].substring(commandArr[3].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[2].substring(commandArr[2].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[1].substring(commandArr[1].indexOf(TIMER_INDICATOR) + 6));
                    }

                } else if (commandArr[1].contains(NUMBER_OF_QUESTIONS_INDICATOR)) {
                    if (commandArr[2].contains(TIMER_INDICATOR)) {
                        numOfQuestions = Integer.parseInt(
                                commandArr[1].substring(commandArr[1].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[3].substring(commandArr[3].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[2].substring(commandArr[2].indexOf(TIMER_INDICATOR) + 6));

                    } else if(commandArr[2].contains(TOPICS_INDICATOR)) {
                        numOfQuestions = Integer.parseInt(
                                commandArr[1].substring(commandArr[1].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[2].substring(commandArr[2].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[3].substring(commandArr[3].indexOf(TIMER_INDICATOR) + 6));
                    }

                } else if (commandArr[1].contains(TOPICS_INDICATOR)) {
                    if (commandArr[2].contains(NUMBER_OF_QUESTIONS_INDICATOR)) {
                        numOfQuestions = Integer.parseInt(
                                commandArr[2].substring(commandArr[2].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[1].substring(commandArr[1].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[3].substring(commandArr[3].indexOf(TIMER_INDICATOR) + 6));

                    } else if (commandArr[2].contains(TIMER_INDICATOR)) {
                        numOfQuestions = Integer.parseInt(
                                commandArr[3].substring(commandArr[3].indexOf(NUMBER_OF_QUESTIONS_INDICATOR) + 2));
                        topicName = commandArr[1].substring(commandArr[1].indexOf(TOPICS_INDICATOR) + 2);
                        timer = Integer.parseInt(commandArr[2].substring(commandArr[2].indexOf(TIMER_INDICATOR) + 6));
                    }

                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                return new IncorrectCommand(ERROR_QUIZ_WRONG_FORMAT);
            }

            LOGGER.log(Level.INFO, "Parsing complete: quiz command chosen.");
            return new QuizCommand((TopicList) topicList, numOfQuestions, topicName, ui, bookmarks, timer);
        case COMMAND_BOOKMARK:
            LOGGER.log(Level.INFO, "Parsing complete: bookmark command chosen.");
            return new BookmarkCommand(BOOKMARK_LIST, bookmarks);
        case COMMAND_EXIT:
            LOGGER.log(Level.INFO, "Parsing complete: exit command chosen.");
            return new ExitCommand();
        case "stats":
            LOGGER.log(Level.INFO, "Parsing complete: stats command chosen.");
            return new StatsCommand((TopicList) topicList);
        default:
            break;
        }
        LOGGER.log(Level.WARNING, "Parsing Error: Unrecognised command was entered.");
        return new IncorrectCommand(ERROR_UNRECOGNIZED_COMMAND);
    }

}
