package by.itacademy.lesson09;

import java.util.Scanner;

public class IntegerInput implements Inputable<Integer> {
    @Override
    public Integer input() {
        return new Scanner(System.in).nextInt();
    }
}
