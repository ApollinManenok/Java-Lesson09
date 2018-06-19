package by.itacademy.lesson09;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Operable> operations = new ArrayList<>();

    {
        operations.add(new AddingPatient());
        operations.add(new AddFromUrl()); //add from Url
        operations.add(new OutputLocalFile()); //save to local file
    }

    private Registry registry;

    public Menu() {
        this.registry = new Registry();
    }

    public void list() {
        //operations.get(0).operation(registry);
        //operations.get(0).operation(registry);
        //System.out.println(registry);
        //operations.get(1).operation(registry);
        //System.out.println(registry);
        operations.get(2).operation(registry);
    }
}
