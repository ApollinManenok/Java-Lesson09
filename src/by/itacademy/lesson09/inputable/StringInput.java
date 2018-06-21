package by.itacademy.lesson09.inputable;

import java.util.Scanner;

public class StringInput implements Inputable<String> {
    @Override
    public String input() {
        return new Scanner(System.in).nextLine();
    }
}
