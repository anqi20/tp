package seedu.eduke8.command;

import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.exception.Eduke8Exception;
import seedu.eduke8.option.OptionList;
import seedu.eduke8.question.Question;
import seedu.eduke8.ui.Ui;

public class IncompleteCommand extends Command {
    private Question question;
    private int timer;

    public IncompleteCommand (Question question, int timer) {
        super();
        this.question = question;
        this.timer = timer;
    }

    @Override
    public void execute(DisplayableList optionList, Ui ui) {
        String explanation = question.getExplanation().getDescription();
        try {
            int correctOptionNumber = ((OptionList) optionList).findCorrectOptionIndex() + 1;
            ui.printIncompleteAnswer(correctOptionNumber, explanation, timer);

        } catch (Eduke8Exception e) {
            ui.printError(e.getMessage());
        }
    }
}
