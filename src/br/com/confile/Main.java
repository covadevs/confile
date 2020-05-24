package br.com.confile;

import br.com.confile.command.screen.ShowMenuCommand;
import br.com.confile.context.ProgramContext;
import br.com.confile.factory.CommandFactory;
import br.com.confile.handler.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> commands;
        CommandHandler commandChained;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        CommandFactory.getCommand(ShowMenuCommand.COMMAND_NAME).execute();
        while(ProgramContext.getInstance().isRunning()) {
            System.out.print("> ");
            try {
                String line = bf.readLine().trim();
                if(!line.isEmpty()) {
                    commands = Arrays.asList(line.split(">>"));

                    commandChained = new CommandHandler(commands.get(0));
                    for (String command : commands) {
                        if (!command.equals(commandChained.getRequest()))
                            commandChained.setNext(new CommandHandler(command));
                    }

                    commandChained.handle();
                    commandChained.afterHandle();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
