package be.biggerboat.api.addresses;

import be.biggerboat.domain.addresses.Address;

import javax.inject.Named;

@Named
public class AddressDto {
    private String street;
    private String housenumber;
    private String zipcode;
    private String city;
    private String country;

    public AddressDto() {
    }

    public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
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
