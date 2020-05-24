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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> commandArgs;
        CommandTO commandTO;

        CommandFactory.getCommand(ShowMenuCommand.COMMAND_NAME).execute();

        while(ProgramContext.getInstance().isRunning()) {
            try {
                System.out.print("> ");
                commandArgs = Arrays.asList(bf.readLine().trim().split("\\s"));
                commandTO = new CommandTO();
                commandTO.setCommandName(commandArgs.get(0));
                commandArgs.subList(1, commandArgs.size()).forEach(commandTO::add);

                AbstractCommand c = CommandFactory.getCommand(commandTO.getCommandName());
                c.setRequestTO(commandTO);
                c.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
