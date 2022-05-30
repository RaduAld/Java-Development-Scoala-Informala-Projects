package ro.siit;

import com.sun.jdi.request.ClassUnloadRequest;

import java.util.List;

public class Hobby {

    private String name;
    private int frequency;
    private List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Hobby: " +
                "name= " + name +
                ", frequency= " + frequency +
                ", addresses= " + addresses;
    }
}
