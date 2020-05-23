package br.com.confile.command;

import br.com.confile.manager.FileManager;
import br.com.confile.to.CommandTO;

public class CommentPropertieCommand extends BaseFileManagerCommand {

    private int propertieIndex;

    private static final int PROPERTIE_INDEX = 0;

    public CommentPropertieCommand(FileManager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.commentPropertie(this.propertieIndex);
    }

    @Override
    public String getCommandName() {
        return "/#";
    }

    @Override
    protected void beforeExecute(CommandTO commandTO) {
        super.beforeExecute(commandTO);
        if(!commandTO.getCommandParams().isEmpty()) {
            this.propertieIndex = Integer.parseInt(commandTO.getCommandParams().get(PROPERTIE_INDEX));
        }
    }
}
