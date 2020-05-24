package br.com.confile.factory;

import br.com.confile.command.AbstractCommand;
import br.com.confile.command.file.*;
import br.com.confile.command.program.QuitCommand;
import br.com.confile.command.screen.ClearScreenCommand;
import br.com.confile.command.screen.ShowMenuCommand;
import br.com.confile.command.screen.UnavailableCommand;
import br.com.confile.manager.Manager;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, AbstractCommand<?>> COMMAND_MAP = new HashMap<>();

    static {
        Manager fileManager = ManagerFactory.getManager(ManagerFactory.ManagerType.FILE_MANAGER);
        Manager screenManager = ManagerFactory.getManager(ManagerFactory.ManagerType.SCREEN_MANAGER);
        Manager programManager = ManagerFactory.getManager(ManagerFactory.ManagerType.PROGRAM_MANAGER);

        COMMAND_MAP.put(CommentPropertyCommand.COMMAND_NAME, new CommentPropertyCommand(fileManager));
        COMMAND_MAP.put(FindPropertiesCommand.COMMAND_NAME, new FindPropertiesCommand(fileManager, ""));
        COMMAND_MAP.put(LoadPropertiesCommand.COMMAND_NAME, new LoadPropertiesCommand(fileManager));
        COMMAND_MAP.put(OpenFileCommand.COMMAND_NAME, new OpenFileCommand(fileManager, ""));
        COMMAND_MAP.put(SaveFileCommand.COMMAND_NAME, new SaveFileCommand(fileManager));
        COMMAND_MAP.put(ShowPropertiesCommand.COMMAND_NAME, new ShowPropertiesCommand(fileManager));
        COMMAND_MAP.put(ClearScreenCommand.COMMAND_NAME, new ClearScreenCommand(screenManager));
        COMMAND_MAP.put(ShowMenuCommand.COMMAND_NAME, new ShowMenuCommand(screenManager));
        COMMAND_MAP.put(UnavailableCommand.COMMAND_NAME, new UnavailableCommand(screenManager));
        COMMAND_MAP.put(QuitCommand.COMMAND_NAME, new QuitCommand(programManager));
    }

    public static AbstractCommand<?> getCommand(String commandName) {
        AbstractCommand<?> command;
        if(COMMAND_MAP.containsKey(commandName)) {
            command = COMMAND_MAP.get(commandName);

            return  command;
        }

        return COMMAND_MAP.get(UnavailableCommand.COMMAND_NAME);
    }
}
