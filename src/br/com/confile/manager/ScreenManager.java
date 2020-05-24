package br.com.confile.manager;

public class ScreenManager implements Manager {

    public void clearScreen() {
        StringBuilder clear = new StringBuilder();

        for (int i = 0; i < 1080; i++) {
            clear.append("\n");
        }

        System.out.println(clear);
    }

    public void unknownCommand() {
        System.out.println("Unkown command!");
    }

    public void showMenu() {
        System.out.println(
                "+---------------------------------------------------------------------------------+\n" +
                "|                                  CONFILE - MENU                                 |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "| Command |                   Description                   |       Example       |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /m   | show menu                                       |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /s   | show properties                                 |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /l   | load properties                                 |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /#   | comment property (undo if already is commented) | /# <property_index> |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /f   | find property                                   |  /f <search_string> |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /o   | open file                                       |      /s <path>      |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /x   | save file                                       |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /c   | clear screen                                    |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+\n" +
                "|    /q   | quit program                                    |          -          |\n" +
                "+---------+-------------------------------------------------+---------------------+");
    }
}
