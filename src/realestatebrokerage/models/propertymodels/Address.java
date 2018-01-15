package realestatebrokerage.models.propertymodels;

import java.io.Serializable;

public class Address implements Serializable{
    private final String street;
    private final String number;
    private final String postcode;
    private final String city;

    public Address(String street, String number, String postcode, String city) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }
    public String getCity() {
        return city;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return number+" "+city+" "+postcode+" "+street;
    }
}

