package ro.siit;

public class Address {
    private String region;
    private String country;
    private String city;
    private String postalCode;

    public Address(String region, String country, String city, String postalCode) {
        this.region = region;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "\nAddress: " +
                "region= " + region +
                ", country= " + country +
                ", city= " + city +
                ", postalCode= " + postalCode;
    }
}
