package by.itacademy.lesson09.inputable;

import java.util.Scanner;

public class BoolInput implements Inputable<Boolean> {
    @Override
    public Boolean input() {
        return new Scanner(System.in).nextBoolean();
    }
}
