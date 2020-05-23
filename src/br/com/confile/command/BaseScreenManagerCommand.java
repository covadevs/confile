package br.com.confile.command;

import br.com.confile.manager.ScreenManager;

public abstract class BaseScreenManagerCommand extends Command<ScreenManager> {

    public BaseScreenManagerCommand(ScreenManager manager) {
        super(manager);
    }
}
