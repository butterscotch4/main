package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.Model.Commit;
import seedu.address.model.ModelManager.HeadAtBoundaryException;

public class RedoCommand implements Command {

    public static final String COMMAND_WORD = "redo";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Redo the previous undo.\n\t" + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        final Commit commit;
        try {
            commit = model.redo();
        } catch (HeadAtBoundaryException e) {
            return new CommandResult("No undos to redo.");
        }
        return new CommandResult("Redid " + commit.getName());
    }

}
