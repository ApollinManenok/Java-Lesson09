package by.itacademy.lesson09.operable;

import by.itacademy.lesson09.domain.Registry;

public abstract class BaseRegistryOperation implements Operable {
    protected Registry registry;

    public BaseRegistryOperation(Registry registry) {
        this.registry = registry;
    }
}
