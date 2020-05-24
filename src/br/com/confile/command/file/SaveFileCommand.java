package br.com.confile.command.file;

import br.com.confile.manager.Manager;

public class SaveFileCommand extends BaseFileManagerCommand {

    public static final String COMMAND_NAME = "/x";


    public SaveFileCommand(Manager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        manager.saveFile();
        //TODO reabrir arquivo apos salvar.
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }
}
