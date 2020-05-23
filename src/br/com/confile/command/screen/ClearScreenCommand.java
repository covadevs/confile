package br.com.confile.command.screen;

import br.com.confile.manager.Manager;

public class ClearScreenCommand extends BaseScreenManagerCommand {


    public ClearScreenCommand(Manager manager) {
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
