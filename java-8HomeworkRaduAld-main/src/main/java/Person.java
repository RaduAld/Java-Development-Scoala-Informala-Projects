import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person implements Comparable {

    private String firstName;
    private String lastName;
    private LocalDate dob; //date of birth

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public static ArrayList<Person> selectByMoth(ArrayList<Person> personList, int month) {
        if (month > 0 && month < 13) {
            return (ArrayList<Person>) personList.stream()
                    .filter(p -> p.getDob().getMonth().equals(Month.of(month)))
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            throw new IndexOutOfBoundsException("Index for month " + month + " is out of bounds!");
        }
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                " (" + dob + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && dob.equals(person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dob);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public int compareTo(Object o) {
        Person p = ((Person) o);

        if (this.getFirstName().compareTo(p.getFirstName()) == 0) {
            if (this.getLastName().compareTo(p.getLastName()) == 0) {
                return this.getDob().compareTo(p.getDob());
            } else return this.getLastName().compareTo(p.getLastName());
        } else return this.getFirstName().compareTo(p.getFirstName());
    }
}
