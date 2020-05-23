package br.com.confile.command;

import br.com.confile.manager.Manager;

public class ShowMenuCommand extends BaseScreenManagerCommand {

    public ShowMenuCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.showMenu();
    }

    @Override
    public String getCommandName() {
        return "/m";
    }
}
