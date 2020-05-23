package br.com.confile.command;

import br.com.confile.manager.Manager;
import br.com.confile.to.CommandTO;

public class CommentPropertyCommand extends BaseFileManagerCommand {

    private int propertyIndex;

    private static final int PROPERTY_INDEX = 0;

    public CommentPropertyCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.commentProperty(this.propertyIndex);
    }

    @Override
    public String getCommandName() {
        return "/#";
    }

    @Override
    protected void beforeExecute(CommandTO commandTO) {
        super.beforeExecute(commandTO);
        if(!commandTO.getCommandParams().isEmpty()) {
            this.propertyIndex = Integer.parseInt(commandTO.getCommandParams().get(PROPERTY_INDEX));
        }
    }
}
