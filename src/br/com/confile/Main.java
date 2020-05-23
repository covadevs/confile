package br.com.confile;

import br.com.confile.command.*;
import br.com.confile.context.ProgramContext;
import br.com.confile.manager.CommandManager;
import br.com.confile.manager.FileManager;
import br.com.confile.manager.Manager;
import br.com.confile.manager.ScreenManager;
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

        FileManager fileManager = new FileManager();
        ScreenManager screenManager = new ScreenManager();
        CommandManager commandManager = new CommandManager();

        configureCommands(commandManager, fileManager);
        configureCommands(commandManager, screenManager);
        commandManager.notify(new CommandTO("/m"));

        while(ProgramContext.getInstance().isRunning()) {
            try {
                System.out.print("> ");
                commandArgs = Arrays.asList(bf.readLine().trim().split("\\s"));
                commandTO = new CommandTO();
                commandArgs.subList(1, commandArgs.size()).forEach(commandTO::add);
                commandTO.setCommandName(commandArgs.get(0));

                commandManager.notify(commandTO);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void configureCommands(CommandManager commandManager, Manager manager) {
        commandManager.add(new UnavailableCommand());
        commandManager.add(new QuitCommand());

        if(manager instanceof FileManager) {
            commandManager.add(new OpenFileCommand(manager, ""));
            commandManager.add(new LoadPropertiesCommand(manager));
            commandManager.add(new ShowPropertiesCommand(manager));
            commandManager.add(new CommentPropertyCommand(manager));
        } else if (manager instanceof ScreenManager) {
            commandManager.add(new ClearScreenCommand(manager));
            commandManager.add(new ShowMenuCommand(manager));
        }
    }

}
