package br.com.confile.command.screen;

import br.com.confile.manager.Manager;

public class ClearScreenCommand extends BaseScreenManagerCommand {

    public static final String COMMAND_NAME = "/c";

    public ClearScreenCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        this.manager.clearScreen();
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
}
