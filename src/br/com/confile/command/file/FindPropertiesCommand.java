package br.com.confile.command.file;

import br.com.confile.manager.Manager;
import br.com.confile.to.CommandTO;

public class FindPropertiesCommand extends BaseFileManagerCommand {

    public static final int SEARCH_STRING = 0;
    private String searchString;

    public FindPropertiesCommand(Manager manager, String searchString) {
        super(manager);
        this.searchString = searchString;
    }

    @Override
    public void execute() {
        manager.findProperties(this.searchString);
    }

    @Override
    public String getCommandName() {
        return "/f";
    }

    @Override
    protected void beforeExecute(CommandTO commandTO) {
        super.beforeExecute(commandTO);
        if(!commandTO.getCommandParams().isEmpty()) {
            this.searchString = commandTO.getCommandParams().get(SEARCH_STRING);
        }
    }
}
