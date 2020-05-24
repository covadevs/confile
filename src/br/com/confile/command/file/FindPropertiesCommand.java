package br.com.confile.command.file;

import br.com.confile.manager.Manager;

public class FindPropertiesCommand extends BaseFileManagerCommand {

    private String searchString;
    private static final int SEARCH_STRING = 0;
    public static final String COMMAND_NAME = "/f";

    public FindPropertiesCommand(Manager manager, String searchString) {
        super(manager);
        this.searchString = searchString;
    }

    @Override
    public void execute() {
        beforeExecute();
        manager.findProperties(this.searchString);
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        if(!commandTO.getCommandParams().isEmpty()) {
            this.searchString = commandTO.getCommandParams().get(SEARCH_STRING);
        }
    }
}
