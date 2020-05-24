package br.com.confile.command.screen;

import br.com.confile.command.AbstractCommand;
import br.com.confile.manager.Manager;
import br.com.confile.manager.ScreenManager;

public class UnavailableCommand extends AbstractCommand<ScreenManager> {

    public static final String COMMAND_NAME = "null";

    public UnavailableCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.unknownCommand();
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
}
