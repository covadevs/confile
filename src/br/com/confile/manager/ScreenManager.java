package br.com.confile.manager;

public class ScreenManager implements Manager {

    public void clearScreen() {
        StringBuilder clear = new StringBuilder();

        for (int i = 0; i < 1080; i++) {
            clear.append("\n");
        }

        System.out.println(clear);
    }

    public void showMenu() {
        System.out.println(
                "+----------------------------------------------------------------+\n" +
                "|                         CONFILE - MENU                         |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "| Command |           Description          |       Example       |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /m   | show menu                      |          -          |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /s   | show properties                |          -          |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /l   | load properties                |          -          |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /#   | comment property               | /# <property_index> |\n" +
                "|         | (undo if already is commented) |                     |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /o   | open file                      |      /s <path>      |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /c   | clear screen                   |          -          |\n" +
                "+---------+--------------------------------+---------------------+\n" +
                "|    /q   | quit program                   |          -          |\n" +
                "+---------+--------------------------------+---------------------+");
    }
}
