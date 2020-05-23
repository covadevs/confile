package br.com.confile.observer;

import br.com.confile.to.CommandTO;

public interface Observer {
    public void update(CommandTO commandTO);
}
