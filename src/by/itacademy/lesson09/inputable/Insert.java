package by.itacademy.lesson09.inputable;

public class Insert<T> {
    private Inputable<T> inputType;

    public Insert(Inputable<T> inputType) {
        this.inputType = inputType;
    }

    public T get(String str) {
        System.out.print(str + "\n>>> ");
        return inputType.input();
    }
}
