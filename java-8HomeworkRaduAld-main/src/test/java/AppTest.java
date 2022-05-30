import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AppTest {

    Person p1 = new Person("Mitsuki", "Laycock", LocalDate.parse("1990-09-27"));
    Person p2 = new Person("Melanie", "Martinez", LocalDate.parse("1995-04-28"));   //APR
    Person p3 = new Person("Robbie ", "Skinner", LocalDate.parse("1998-12-15"));    //DEC
    Person p4 = new Person("Amala", "Dlamini", LocalDate.parse("1993-10-21"));
    Person p5 = new Person("Prince", "Nelson", LocalDate.parse("1958-04-21"));      //APR
    Person p6 = new Person("Dolly", "Parton", LocalDate.parse("1946-01-19"));
    Person p7 = new Person("Elton", "John", LocalDate.parse("1947-03-25"));
    Person p8 = new Person("Mac", "DeMarco", LocalDate.parse("1987-04-30"));        //APR
    Person p9 = new Person("Adele", "Adkins", LocalDate.parse("1988-05-05"));
    Person p10 = new Person("Freddy", "Mercury", LocalDate.parse("1947-09-05"));
    Person p11 = new Person("Onika", "Maraj", LocalDate.parse("1947-12-08"));       //DEC
    Person p12 = new Person("Britney", "Spears", LocalDate.parse("1947-12-02"));    //DEC
    ArrayList<Person> processedList = new ArrayList<>();

    public void initialize() {
        processedList.add(p1);
        processedList.add(p2);
        processedList.add(p3);
        processedList.add(p4);
        processedList.add(p5);
        processedList.add(p6);
        processedList.add(p7);
        processedList.add(p8);
        processedList.add(p9);
        processedList.add(p10);
        processedList.add(p11);
        processedList.add(p12);
    }

    @Test
    public void testFebruary() {
        initialize();

        ArrayList<Person> finalList = new ArrayList<>();
        ArrayList<Person> february = Person.selectByMoth(processedList, 2);

        assertTrue(february.size() == 0 &&
                february.containsAll(finalList) &&
                finalList.containsAll(february));
    }

    @Test
    public void testDecember() {
        initialize();

        ArrayList<Person> finalList = new ArrayList<>();

        finalList.add(p12);
        finalList.add(p11);
        finalList.add(p3);
        ArrayList<Person> december = Person.selectByMoth(processedList, 12);

        assertTrue(december.size() == finalList.size() &&
                december.containsAll(finalList) &&
                finalList.containsAll(december));

    }

    @Test
    public void testApril() {
        initialize();

        ArrayList<Person> finalList = new ArrayList<>();

        finalList.add(p8);
        finalList.add(p2);
        finalList.add(p5);
        ArrayList<Person> april = Person.selectByMoth(processedList, 4);

        assertTrue(april.size() == finalList.size() &&
                april.containsAll(finalList) &&
                finalList.containsAll(april));

    }

}
