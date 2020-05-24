package br.com.confile.handler;

import br.com.confile.command.AbstractCommand;

public class CommandHandler extends BaseHandler<CommandHandler, AbstractCommand> {

    @Override
    public void setNext(CommandHandler commandHandler) {
        next = commandHandler;
    }

    @Override
    public void handle(AbstractCommand request) {
        request.execute();
        if(next != null) {
            next.handle(request);
        }
    }
}
