package br.com.confile;

import br.com.confile.command.AbstractCommand;
import br.com.confile.command.screen.ShowMenuCommand;
import br.com.confile.context.ProgramContext;
import br.com.confile.factory.CommandFactory;
import br.com.confile.to.CommandTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> commands;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        CommandFactory.getCommand(ShowMenuCommand.COMMAND_NAME).execute();

        while(ProgramContext.getInstance().isRunning()) {
            System.out.print("> ");
            try {
                commands = Arrays.asList(bf.readLine().trim().split(">>"));
                commands.forEach(command -> {
                    List<String> commandArgs = Arrays.asList(command.trim().split("\\s"));
                    CommandTO commandTO = new CommandTO();
                    commandTO.setCommandName(commandArgs.get(0));
                    commandArgs.subList(1, commandArgs.size()).forEach(commandTO::add);

                    AbstractCommand c = CommandFactory.getCommand(commandTO.getCommandName());
                    c.setRequestTO(commandTO);
                    c.execute();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
