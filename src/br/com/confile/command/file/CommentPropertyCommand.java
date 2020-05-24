package br.com.confile.command.file;

import br.com.confile.manager.Manager;

public class CommentPropertyCommand extends BaseFileManagerCommand {

    private int propertyIndex;

    private static final int PROPERTY_INDEX = 0;

    public static final String COMMAND_NAME = "/#";

    public CommentPropertyCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        beforeExecute();
        manager.commentProperty(this.propertyIndex);
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        if(!commandTO.getCommandParams().isEmpty()) {
            this.propertyIndex = Integer.parseInt(commandTO.getCommandParams().get(PROPERTY_INDEX));
        }
    }
}
