package by.itacademy.lesson09.operable.serialization;

import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.operable.BaseRegistryOperation;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class UploadPatients extends BaseRegistryOperation {
    protected String source;
    protected URL url;

    public UploadPatients(Registry registry, String source) {
        super(registry);
        try {
            this.url = new URL(source);
            this.source = source;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
