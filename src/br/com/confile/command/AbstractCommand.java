package br.com.confile.command;

import br.com.confile.manager.Manager;
import br.com.confile.to.CommandTO;

public abstract class AbstractCommand<M extends Manager> implements ExecutableCommand, NamedCommand {

    protected M manager;
    protected CommandTO commandTO;

    @SuppressWarnings("unchecked")
    public AbstractCommand(Manager manager) {
        this.manager = (M) manager;
    }

    protected void beforeExecute() {
        //Hook method
    }

    public void setManager(M manager) {
        this.manager = manager;
    }

    public void setRequestTO(CommandTO requestTO) {
        this.commandTO = requestTO;
    }
}
