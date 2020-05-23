package br.com.confile.command;

import br.com.confile.ConFileConstants;
import br.com.confile.manager.FileManager;
import br.com.confile.to.CommandTO;

public class UnavaliableCommand extends Command {

    public UnavaliableCommand(FileManager manager) {
        super(manager);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public void update(CommandTO commandTO) {
        if(!commandTO.getCommandName().matches(ConFileConstants.COMMANDS_AVAILABLE_PATTERN)) {
            System.out.println("Command Unavailable");
        }
    }
}
