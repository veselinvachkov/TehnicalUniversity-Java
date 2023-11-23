package TU_Java.week_6.first;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Voter {
    private String name;
    private String city;
    private String street;
    private String address;

    public Voter(String name, String city, String street, String address) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return address;
    }
}