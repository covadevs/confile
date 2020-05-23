package br.com.confile.command;

import br.com.confile.manager.FileManager;

public class ShowPropertiesCommand extends BaseFileManagerCommand {

    public ShowPropertiesCommand(FileManager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        this.manager.showProperties();
    }

    @Override
    public String getCommandName() {
        return "/s";
    }
}
