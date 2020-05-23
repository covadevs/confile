package br.com.confile.command;

import br.com.confile.manager.Manager;
import br.com.confile.to.CommandTO;

public abstract class Command<M extends Manager> implements ExecutableCommand, NamedCommand, CommandObserver {

    protected M manager;

    @SuppressWarnings("unchecked")
    public Command(Manager manager) {
        this.manager = (M) manager;
    }

    @Override
    public void update(CommandTO commandTO) {
        if(commandTO.getCommandName().equals(getCommandName())) {
            beforeExecute(commandTO);
            execute();
        }
    }

    protected void beforeExecute(CommandTO commandTO) {
        //Hook method
    }
}
