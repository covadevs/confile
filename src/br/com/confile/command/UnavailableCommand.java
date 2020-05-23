package br.com.confile.command;

import br.com.confile.ConFileConstants;
import br.com.confile.to.CommandTO;

public class UnavailableCommand implements CommandObserver {

    @Override
    public void update(CommandTO commandTO) {
        if(!commandTO.getCommandName().matches(ConFileConstants.COMMANDS_AVAILABLE_PATTERN)) {
            System.out.println("Command Unavailable");
        }
    }
}
