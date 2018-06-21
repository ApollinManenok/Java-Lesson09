package by.itacademy.lesson09;

public abstract class BaseRegistryOperation implements Operable {
    protected Registry registry;

    public BaseRegistryOperation(Registry registry) {
        this.registry = registry;
    }
}
