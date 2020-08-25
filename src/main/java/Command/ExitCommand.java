package Command;

import Command.Command;

import Exceptions.DukeException;

import Task.TaskList;

import ParserStorageUi.*;
public class ExitCommand extends Command {

    public ExitCommand(String command){
        super(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            storage.putToDatabase(tasks.getTaskList());
            ui.showGoodBye();
        } catch (DukeException e){
            throw new DukeException(e.getMessage());
        }
    }

    @Override
    public boolean isExit(){
        return true;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        } else if (o instanceof ExitCommand){
            ExitCommand temp = (ExitCommand) o;
            if (temp.command.equals(this.command)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}