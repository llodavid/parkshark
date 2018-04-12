package be.biggerboat.domain.addresses;

import javax.persistence.*;

@Embeddable
public class Address {

    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSENUMBER")
    private String housenumber;
    @Column(name = "Country")
    private String country;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "FK_ZIPCODE")
    private Zipcode zipcode;

    private Address(AddressBuilder addressBuilder) {
        this.street = addressBuilder.street;
        this.housenumber = addressBuilder.housenumber;
        this.country = addressBuilder.country;
        this.zipcode = addressBuilder.zipcode;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getCountry() {
        return country;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(", \n\tstreet='").append(street).append('\'');
        sb.append(", \n\thousenumber='").append(housenumber).append('\'');
        return sb.toString();
    }

    public static class AddressBuilder {
        private String street;
        private String housenumber;
        private String country;
        private Zipcode zipcode;

        public static AddressBuilder buildAddress() {
            return new AddressBuilder();
        }

        public Address build() {
            if (allFieldsSet()) {
                addDefaultCountryIfNotSet();
                return new Address(this);
            } else {
                throw new IllegalArgumentException(   "Please provide all the necessary arguments for the Address.");
            }
        }

        private void addDefaultCountryIfNotSet() {
            if (country == null) {
                country = "Belgium";
            }
        }

        private boolean allFieldsSet() {
            return street != null && housenumber != null;
        }

        public AddressBuilder withHousenumber(String housenumber) {
            this.housenumber = housenumber;
            return this;
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withZipcode (Zipcode zipcode){
            this.zipcode = zipcode;
            return this;
        }

        public AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }
    }

}
