package by.itacademy.lesson09.operable.serialization;

import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.operable.BaseRegistryOperation;

import java.io.File;

public abstract class WritePatients extends BaseRegistryOperation {
    protected File file;

    public WritePatients(Registry registry, String source) {
        super(registry);
        this.file = new File(source);
    }
}
