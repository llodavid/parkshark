package be.biggerboat.domain.addresses;

import javax.persistence.*;

@Embeddable
public class Zipcode {

    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "CITY")
    private String city;

    public Zipcode() {
    }

    public Zipcode(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }


}
