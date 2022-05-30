import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static BufferedReader getFile() throws FileNotFoundException {
        String fs = File.separator;
        return new BufferedReader(new FileReader(fs + "Users" + fs + "Admins" + fs +
                "Documents" + fs + "Radu" + fs + "It" + fs + "java-8HomeworkRaduAld" + fs + "src" + fs + "main" + fs
                + "resources" + fs + "data.csv"));
    }

    public static ArrayList<Person> readFile() throws IOException {
        BufferedReader file = Reader.getFile();
        ArrayList<Person> personList = new ArrayList<>();
        String row;
        while ((row = file.readLine()) != null) {
            String[] data = row.split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            LocalDate dob = LocalDate.parse(data[2], formatter);
            Person person = new Person(data[0], data[1], dob);
            personList.add(person);
        }
        return personList;
    }

}
