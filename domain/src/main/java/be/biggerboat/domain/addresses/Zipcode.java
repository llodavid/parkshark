package be.biggerboat.domain.addresses;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zipcode zipcode1 = (Zipcode) o;
        return Objects.equals(zipcode, zipcode1.zipcode) &&
                Objects.equals(city, zipcode1.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(zipcode, city);
    }
}
