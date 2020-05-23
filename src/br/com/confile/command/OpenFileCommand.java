package br.com.confile.command;

import br.com.confile.exception.ConFileException;
import br.com.confile.manager.Manager;
import br.com.confile.to.CommandTO;

import java.io.IOException;

public class OpenFileCommand extends BaseFileManagerCommand implements FlushableCommand {

    private String path;

    private static final Integer PATH = 0;

    public OpenFileCommand(Manager manager, String path) {
        super(manager);
        this.path = path;
    }

    @Override
    public void execute() {
        try {
            this.manager.open(this.path);
        } catch (IOException | ConFileException e ) {
            flush();
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
    public void flush() {
        this.path = "";
    }
}
