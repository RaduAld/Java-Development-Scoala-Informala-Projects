package ro.siit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {

        TreeSet<Person> persons1 = new TreeSet<>(new CompareName());

        Person person1 = new Person("Mark", 37);
        Person person2 = new Person("Barbara", 40);
        Person person3 = new Person("Tonny", 18);
        Person person4 = new Person("Nick", 24);

        persons1.add(person1);
        persons1.add(person2);
        persons1.add(person3);
        persons1.add(person4);

        for (Person person : persons1) {
            System.out.println(person);
        }
        System.out.println();

        TreeSet<Person> persons2 = new TreeSet<>(new CompareAge());

        persons2.add(person1);
        persons2.add(person2);
        persons2.add(person3);
        persons2.add(person4);

        for (Person person : persons2) {
            System.out.println(person);
        }
        System.out.println();

        Address address1 = new Address("Europe", "Romania", "Bucharest", "010158");
        Address address2 = new Address("Asia", "North Korea", "Busan", "616771");
        Address address3 = new Address("North America", "California", "Los Angeles", "90001");
        Address address4 = new Address("South America", "Brazil", "Los Angeles", "05319000");
        Address address5 = new Address("Europe", "France", "Paris", "75000");
        Address address6 = new Address("Africa", "Kenya", "Paris", "20115");

        List<Address> addresses1 = new ArrayList<>() ;
        addresses1.add(address1);    addresses1.add(address3);
        List<Address> addresses2 = new ArrayList<>() ;
        addresses2.add(address2);    addresses2.add(address4);
        List<Address> addresses3 = new ArrayList<>() ;
        addresses3.add(address2);    addresses3.add(address6);
        List<Address> addresses4 = new ArrayList<>() ;
        addresses4.add(address3);    addresses4.add(address5);

        Hobby cycling = new Hobby("Cycling", 3, addresses1);
        Hobby swimming = new Hobby("Swimming", 2, addresses2);
        Hobby basketball = new Hobby("Basketball", 3, addresses3);
        Hobby singing = new Hobby("Singing", 2, addresses4);


        HashMap<Person, List<Hobby>> personHobby = new HashMap<>();
        List<Hobby> hobbies1= new ArrayList<Hobby>();
        hobbies1.add(cycling);  hobbies1.add(basketball);
        List<Hobby> hobbies2= new ArrayList<Hobby>();
        hobbies2.add(cycling);  hobbies2.add(swimming);
        List<Hobby> hobbies3= new ArrayList<Hobby>();
        hobbies3.add(basketball);  hobbies3.add(swimming);
        List<Hobby> hobbies4= new ArrayList<Hobby>();
        hobbies4.add(basketball);  hobbies4.add(singing);

        personHobby.put(person1, hobbies1);
        personHobby.put(person2, hobbies2);
        personHobby.put(person3, hobbies3);
        personHobby.put(person4, hobbies4);

        System.out.println(person1);
        for (Hobby hobby : personHobby.get(person1)){
            System.out.println(hobby);
        }
        System.out.println();
        System.out.println(person2);
        for (Hobby hobby : personHobby.get(person2)){
            System.out.println(hobby);
        }
    }
}
