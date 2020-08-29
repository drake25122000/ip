package command;

import exceptions.WrongIndexError;
import parserstorageui.Storage;
import parserstorageui.Ui;
import task.TaskList;


public class DoneCommand extends Command {

    /**
     * Initializes DoneCommand
     *
     * @param command
     */
    public DoneCommand(String command) {
        super(command);
    }

    /**
     * Executes the command
     **/
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws WrongIndexError {
        try {
            tasks = tasks.done(this.command);
            ui.showDoneTask(tasks.getAddedOrDeletedTask());
        } catch (WrongIndexError e) {
            throw new WrongIndexError(e.getMessage());
        }

    }

    /**
     * Check if the current command is an exit command
     **/
    @Override
    public boolean isExit() {
        return false;
    }
}
