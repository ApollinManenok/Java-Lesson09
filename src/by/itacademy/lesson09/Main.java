package by.itacademy.lesson09;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.list();
    }
}
