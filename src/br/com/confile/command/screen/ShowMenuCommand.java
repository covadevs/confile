package br.com.confile.command.screen;

import br.com.confile.manager.Manager;

public class ShowMenuCommand extends BaseScreenManagerCommand {

    public static final String COMMAND_NAME = "/m";

    public ShowMenuCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.showMenu();
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
}
