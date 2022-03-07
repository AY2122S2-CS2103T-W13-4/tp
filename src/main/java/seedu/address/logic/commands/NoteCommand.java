package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Note;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Changes the note of an existing client in the address book
 */
public class NoteCommand extends Command {
    public static final String COMMAND_WORD = "note";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the note of the client identified "
            + "by the index number used in the last person listing. "
            + "Existing note will be overwritten by input.\n"
            + "Parameters: INDEX (must be an existing email) "
            + "nt/[NOTE]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "nt/Likes to gym.";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Note: %2$s";

    private final Index index;
    private final Note note;

    public NoteCommand(Index index, Note note) {
        requireAllNonNull(index, note);

        this.index = index;
        this.note = note;
    }

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "Note command not implemented yet";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), note));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof NoteCommand)) {
            return false;
        }

        NoteCommand e = (NoteCommand) other;
        return index.equals(e.index) && note.equals(e.note);
    }
}
