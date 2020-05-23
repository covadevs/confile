package br.com.confile.command;

import br.com.confile.exception.ConFileException;
import br.com.confile.manager.FileManager;
import br.com.confile.to.CommandTO;

import java.io.IOException;

public class OpenFileCommand extends BaseFileManagerCommand {

    private String path;

    private static final Integer PATH = 0;

    public OpenFileCommand(FileManager manager, String path) {
        super(manager);
        this.path = path;
    }


    @Override
    public void execute() {
        try {
            this.manager.open(this.path);
        } catch (IOException | ConFileException e ) {
            flushCommand();
            e.printStackTrace();
        }
    }

    @Override
    public String getCommandName() {
        return "/o";
    }

    @Override
    protected void beforeExecute(CommandTO commandTO) {
        super.beforeExecute(commandTO);
        if(!commandTO.getCommandParams().isEmpty()) {
            this.path = commandTO.getCommandParams().get(PATH);
        }
    }

    @Override
    protected void flushCommand() {
        super.flushCommand();
        this.path = "";
    }
}
