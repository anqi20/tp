package seedu.eduke8.note;

import seedu.eduke8.common.Displayable;

public class Note implements Displayable {
    private String description;
    private String noteText;
    private boolean wasShown;

    public Note(String description, String noteText) {
        assert (description != null);
        assert (noteText != null);
        this.description = description;
        this.noteText = noteText;
        wasShown = false;
    }

    @Override
    public String getDescription() {
        markAsShown();
        return this.description;
    }

    @Override
    public void markAsShown() {
        wasShown = true;
    }

    @Override
    public boolean wasShown() {
        return this.wasShown;
    }

    public String getNoteText() {
        return this.noteText;
    }
}
