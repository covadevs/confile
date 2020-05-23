package br.com.confile.command.file;

import br.com.confile.command.Command;
import br.com.confile.manager.FileManager;
import br.com.confile.manager.Manager;

public abstract class BaseFileManagerCommand extends Command<FileManager> {

    public BaseFileManagerCommand(Manager manager) {
        super(manager);
    }
}
