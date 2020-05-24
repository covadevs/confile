package br.com.confile.manager;

import br.com.confile.context.ProgramContext;

public class ProgramManager implements Manager {

    public void quit() {
        System.out.println("Good bye!");
        ProgramContext.getInstance().exit();
    }
}
