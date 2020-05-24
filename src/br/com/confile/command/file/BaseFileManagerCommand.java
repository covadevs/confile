package br.com.confile.command.file;

import br.com.confile.command.AbstractCommand;
import br.com.confile.manager.FileManager;
import br.com.confile.manager.Manager;

public abstract class BaseFileManagerCommand extends AbstractCommand<FileManager> {

    public BaseFileManagerCommand(Manager manager) {
        super(manager);
    }

}
