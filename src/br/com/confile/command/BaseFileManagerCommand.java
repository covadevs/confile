package br.com.confile.command;

import br.com.confile.manager.FileManager;

public abstract class BaseFileManagerCommand extends Command<FileManager> {

    public BaseFileManagerCommand(FileManager manager) {
        super(manager);
    }
}
