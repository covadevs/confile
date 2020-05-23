package br.com.confile.command;

import br.com.confile.manager.ScreenManager;

public class ShowMenuCommand extends BaseScreenManagerCommand {

    public ShowMenuCommand(ScreenManager manager) {
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
