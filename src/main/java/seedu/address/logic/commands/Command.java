package seedu.address.logic.commands;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.IncorrectCommandAttemptedEvent;
import seedu.address.model.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    /**
     * Executes the command and returns the result message.
     *
     * @return feedback message of the operation result for display
     * @throws CommandException if an error occurred during command execution. The model will be left in
     *          an unknown state -- the caller should call {@link Model#undo()} to revert the model back
     *          to a known state if necessary.
     */
    public abstract CommandResult execute(Model model) throws CommandException;

    /**
     * Raises an event to indicate an attempt to execute an incorrect command
     */
    protected void indicateAttemptToExecuteIncorrectCommand() {
        EventsCenter.getInstance().post(new IncorrectCommandAttemptedEvent(this));
    }

}
