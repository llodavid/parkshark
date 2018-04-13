package be.biggerboat.domain.addresses;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSENUMBER")
    private String housenumber;

   @Embedded
    private Zipcode zipcode;

    private Address(AddressBuilder addressBuilder) {
        this.street = addressBuilder.street;
        this.housenumber = addressBuilder.housenumber;
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

    public Zipcode getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getHousenumber(), address.getHousenumber()) &&
                Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStreet(), getHousenumber(), getZipcode());
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
        private Zipcode zipcode;

        public static AddressBuilder buildAddress() {
            return new AddressBuilder();
        }

        public Address build() {
            if (allFieldsSet()) {
                return new Address(this);
            } else {
                throw new IllegalArgumentException(   "Please provide all the necessary arguments for the Address.");
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

    }

}
