package br.com.confile.manager;

import br.com.confile.command.CommandObserver;
import br.com.confile.observer.Observable;
import br.com.confile.to.CommandTO;

public class CommandManager extends Observable<CommandObserver, CommandTO> {

    @Override
    public void notify(CommandTO commandTO) {
        this.observers.forEach(o -> o.update(commandTO));
    }
}
