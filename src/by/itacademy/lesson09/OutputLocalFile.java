package by.itacademy.lesson09;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class OutputLocalFile implements Operable {
    private DataOutputStream dos;

    @Override
    public void operation(Registry registry) {
        try {
            dos = new DataOutputStream(new FileOutputStream("data.bin"));
            for (Patient element : registry) {
                write(element);
            }
            System.out.println("File has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void write(Patient patient) throws IOException {
        dos.writeUTF(patient.getName());
        dos.writeUTF(patient.getSurname());
        LocalDate date = patient.getBirth();
        dos.writeUTF(String.valueOf(date.getDayOfMonth()));
        dos.writeUTF(String.valueOf(date.getMonthValue()));
        dos.writeUTF(String.valueOf(date.getYear()));
        dos.writeUTF(String.valueOf(patient.isStatus()));
    }
}
