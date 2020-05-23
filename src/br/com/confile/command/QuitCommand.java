package br.com.confile.command;

import br.com.confile.context.ProgramContext;
import br.com.confile.to.CommandTO;

public class QuitCommand implements ExecutableCommand, NamedCommand, CommandObserver {

    @Override
    public void execute() {
        ProgramContext.getInstance().exit();
    }

    @Override
    public String getCommandName() {
        return "/q";
    }

    @Override
    public void update(CommandTO param) {
        if(param.getCommandName().equals(getCommandName())) {
            execute();
        }
    }
}
