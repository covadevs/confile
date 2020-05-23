package br.com.confile.to;

import java.util.ArrayList;
import java.util.List;

public class CommandTO {

    private String commandName;
    private List<String> commandParams;

    public CommandTO() {
        this.commandName = "";
        this.commandParams = new ArrayList<>();
    }

    public CommandTO(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void add(String commandParam) {
        this.commandParams.add(commandParam);
    }

    public List<String> getCommandParams() {
        return commandParams;
    }
}
