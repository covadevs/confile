package br.com.confile.command.program;

import br.com.confile.command.AbstractCommand;
import br.com.confile.manager.Manager;
import br.com.confile.manager.ProgramManager;

public class QuitCommand extends AbstractCommand<ProgramManager> {

    public static final String COMMAND_NAME = "/q";

    public QuitCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.quit();
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

}
