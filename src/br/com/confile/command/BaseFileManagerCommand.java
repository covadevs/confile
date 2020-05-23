package br.com.confile.command;

import br.com.confile.manager.FileManager;
import br.com.confile.manager.Manager;

public abstract class BaseFileManagerCommand extends Command<FileManager> {

    public BaseFileManagerCommand(Manager manager) {
        super(manager);
    }
}
