package br.com.confile.command;

import br.com.confile.context.ProgramContext;
import br.com.confile.manager.FileManager;

public class QuitCommand extends Command {

    public QuitCommand(FileManager manager) {
        super(manager);
    }

    @Override
    public void execute() {
        ProgramContext.getInstance().exit();
    }

    @Override
    public String getCommandName() {
        return "/q";
    }
}
