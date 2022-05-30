import java.io.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException{

        System.out.println("------------------");

        ArrayList<Person> personList = Reader.readFile();
        personList.forEach(System.out::println);

        System.out.println("------------------");

        ArrayList<Person> orderedList = Person.selectByMoth(personList, 6);
        if (orderedList.size() > 0) {
            orderedList.forEach(System.out::println);
        } else {
            System.out.println("Query has no objects.");
        }

        Writer.writeFile(orderedList);
    }
}
