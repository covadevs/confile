package br.com.confile.command.file;

import br.com.confile.manager.Manager;

public class CommentPropertyCommand extends BaseFileManagerCommand {

    private int[] propertiesIndex;

    public static final String COMMAND_NAME = "/#";

    public CommentPropertyCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        beforeExecute();
        manager.commentProperty(this.propertiesIndex);
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        if(!commandTO.getCommandParams().isEmpty()) {
            commandTO.getCommandParams().stream()
                    .filter(param -> !param.matches("[0-9]*"))
                    .forEach(param -> {
                        if (!param.matches("[0-9]*")) {
                            System.out.println("Invalid param: " + param + " - SKIPPED");
                        }
                    });

            this.propertiesIndex = commandTO.getCommandParams().stream()
                    .filter(param -> param.matches("[0-9]*"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
