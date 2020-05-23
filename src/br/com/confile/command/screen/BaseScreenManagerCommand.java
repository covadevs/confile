package br.com.confile.command.screen;

import br.com.confile.command.Command;
import br.com.confile.manager.Manager;
import br.com.confile.manager.ScreenManager;

public abstract class BaseScreenManagerCommand extends Command<ScreenManager> {

    public BaseScreenManagerCommand(Manager manager) {
        super(manager);
    }

}
