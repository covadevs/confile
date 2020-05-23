package br.com.confile.command.file;

import br.com.confile.manager.Manager;

public class ShowPropertiesCommand extends BaseFileManagerCommand {


    public ShowPropertiesCommand(Manager manager) {
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
