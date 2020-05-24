package br.com.confile.command.file;

import br.com.confile.command.FlushableCommand;
import br.com.confile.manager.Manager;

import java.io.IOException;

public class OpenFileCommand extends BaseFileManagerCommand implements FlushableCommand {

    private String path;
    private static final Integer PATH = 0;
    public static final String COMMAND_NAME = "/o";


    public OpenFileCommand(Manager manager, String path) {
        super(manager);
        this.path = path;
    }

    @Override
    public void execute() {
        beforeExecute();
        try {
            this.manager.openFile(this.path);
        } catch (IOException e ) {
            flush();
            e.printStackTrace();
        }
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        if(!commandTO.getCommandParams().isEmpty()) {
            this.path = commandTO.getCommandParams().get(PATH);
        }
    }

    @Override
    public void flush() {
        this.path = "";
    }
}
