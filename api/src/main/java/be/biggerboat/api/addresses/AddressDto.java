package be.biggerboat.api.addresses;

import be.biggerboat.domain.addresses.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.inject.Named;
import java.util.Objects;

@Named
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    public String street;
    public String housenumber;
    public String zipcode;
    public String city;

    public AddressDto() {
    }

    public AddressDto withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressDto withHousenumber(String housenumber) {
        this.housenumber = housenumber;
        return this;
    }

    public AddressDto withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AddressDto withCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(street, that.street) &&
                Objects.equals(housenumber, that.housenumber) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(street, housenumber, zipcode, city);
    }
}
