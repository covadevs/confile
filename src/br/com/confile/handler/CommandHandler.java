package br.com.confile.handler;

import br.com.confile.command.AbstractCommand;
import br.com.confile.factory.CommandFactory;
import br.com.confile.to.CommandTO;

import java.util.Arrays;
import java.util.List;

public class CommandHandler extends BaseHandler<CommandHandler, String> {

    public CommandHandler(String request) {
        super(request);
    }


    //TODO:
    // Tem como melhorar esse método adicionando
    // uma cauda para servir de sentinela.
    @Override
    public void setNext(CommandHandler commandHandler) {
        if(next != null) {
            next.setNext(commandHandler);
        } else {
            next = commandHandler;
        }
    }

    @Override
    public void handle() {
        List<String> commandArgs = Arrays.asList(request.trim().split("\\s"));
        CommandTO commandTO = new CommandTO();
        commandTO.setCommandName(commandArgs.get(0));
        commandArgs.subList(1, commandArgs.size()).forEach(commandTO::add);

        AbstractCommand c = CommandFactory.getCommand(commandTO.getCommandName());
        c.setRequestTO(commandTO);
        c.execute();

        if(next != null) {
            next.handle();
        }
    }

    public void afterHandle() {
        if(next != null) {
            this.next.afterHandle();
        }

        next = null;
    }
}
