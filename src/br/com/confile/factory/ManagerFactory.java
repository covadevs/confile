package br.com.confile.factory;

import br.com.confile.manager.FileManager;
import br.com.confile.manager.Manager;
import br.com.confile.manager.ProgramManager;
import br.com.confile.manager.ScreenManager;

import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {

    public enum ManagerType {
        FILE_MANAGER,
        SCREEN_MANAGER,
        PROGRAM_MANAGER;
    }

    private static final Map<ManagerType, Manager> MANAGER_MAP = new HashMap<>();

    static {
        MANAGER_MAP.put(ManagerType.FILE_MANAGER, new FileManager());
        MANAGER_MAP.put(ManagerType.SCREEN_MANAGER, new ScreenManager());
        MANAGER_MAP.put(ManagerType.PROGRAM_MANAGER, new ProgramManager());
    }

    public static Manager getManager(ManagerType type) {
        return MANAGER_MAP.get(type);
    }

}
