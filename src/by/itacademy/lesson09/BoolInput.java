package by.itacademy.lesson09;

import java.util.Scanner;

public class BoolInput implements Inputable<Boolean> {
    //private Scanner scan = new Scanner(System.in);

    @Override
    public Boolean input() {
        return new Scanner(System.in).nextBoolean();
    }//exceptions!
}
