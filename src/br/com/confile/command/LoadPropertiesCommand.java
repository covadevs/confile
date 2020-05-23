package br.com.confile.command;

import br.com.confile.manager.Manager;

import java.io.IOException;

public class LoadPropertiesCommand extends BaseFileManagerCommand {

    public LoadPropertiesCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        try {
            this.manager.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCommandName() {
        return "/l";
    }
}
