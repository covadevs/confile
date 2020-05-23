package br.com.confile.command;

import br.com.confile.manager.Manager;
import br.com.confile.observer.Observer;
import br.com.confile.to.CommandTO;

public abstract class Command<M extends Manager> implements Observer<CommandTO> {

    protected M manager;

    public Command(M manager) {
        this.manager = manager;
    }

    public abstract void execute();

    public abstract String getCommandName();

    protected void flushCommand() {
        //Hook method
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
