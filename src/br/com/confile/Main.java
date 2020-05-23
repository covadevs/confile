package br.com.confile;

import br.com.confile.command.*;
import br.com.confile.context.ProgramContext;
import br.com.confile.manager.CommandManager;
import br.com.confile.manager.FileManager;
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

        configureCommands(commandManager, fileManager, screenManager);
        commandManager.notify(new CommandTO("/m"));

        while(ProgramContext.getInstance().isRunning()) {
            try {
                System.out.print(">_ ");
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

    private static void configureCommands(CommandManager commandManager, FileManager fileManager, ScreenManager screenManager) {
        commandManager.add(new UnavaliableCommand(fileManager));
        commandManager.add(new QuitCommand(fileManager));
        commandManager.add(new OpenFileCommand(fileManager, ""));
        commandManager.add(new LoadPropertiesCommand(fileManager));
        commandManager.add(new ShowPropertiesCommand(fileManager));
        commandManager.add(new CommentPropertieCommand(fileManager));

        commandManager.add(new ClearScreenCommand(screenManager));
        commandManager.add(new ShowMenuCommand(screenManager));
    }

}
