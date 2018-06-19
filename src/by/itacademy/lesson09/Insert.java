package by.itacademy.lesson09;

public class Insert<T> {
    private Inputable<T> info;

    public Insert(Inputable<T> type) {
        this.info = type;
    }

    public T get(String str) {
        System.out.print(str + "\n>>> ");
        return info.input();
    }
}
