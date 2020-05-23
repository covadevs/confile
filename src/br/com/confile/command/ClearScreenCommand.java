package br.com.confile.command;

import br.com.confile.manager.ScreenManager;

public class ClearScreenCommand extends BaseScreenManagerCommand {

    public ClearScreenCommand(ScreenManager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        this.manager.clearScreen();
    }

    @Override
    public String getCommandName() {
        return "/c";
    }
}
