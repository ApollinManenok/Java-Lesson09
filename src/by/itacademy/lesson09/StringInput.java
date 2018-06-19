package by.itacademy.lesson09;

import java.util.Scanner;

public class StringInput implements Inputable<String> {
    //private Scanner scan = new Scanner(System.in);

    public String input() {
        return new Scanner(System.in).nextLine();
    }
}
