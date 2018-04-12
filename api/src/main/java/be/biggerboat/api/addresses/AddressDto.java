package be.biggerboat.api.addresses;

import be.biggerboat.domain.addresses.Address;

import javax.inject.Named;

@Named
public class AddressDto {
    public String street;
    public String housenumber;
    public String zipcode;
    public String city;
    public String country;

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

    public AddressDto withCountry(String country) {
        this.country = country;
        return this;
    }

}
