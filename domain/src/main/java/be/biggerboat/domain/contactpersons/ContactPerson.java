package be.biggerboat.domain.contactpersons;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class ContactPerson {

    @Column(name = "CONTACT_PERSON_NAME")
    private String name;
    @Column(name = "MOBILEPHONE")
    private String mobilePhone;
    @Column(name = "NORMALPHONE")
    private String normalPhone;
    @Column(name = "EMAIL")
    private String mail;

    @Embedded
    private Address address;

    public ContactPerson() {
    }

    public ContactPerson(String name, String mobilePhone, String normalPhone, String mail, Address address) {
        if (isFilledIn(name) && (isFilledIn(mobilePhone) || isFilledIn(normalPhone)) && isFilledIn(mail) && isFilledIn(address)) {
            this.name = name;
            this.mobilePhone = mobilePhone;
            this.normalPhone = normalPhone;
            this.mail = mail;
            this.address = address;
        } else {
            throw new ParksharkException("Please fill all in");
        }
    }

    public String getName() {
        return name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getNormalPhone() {
        return normalPhone;
    }

    public String getMail() {
        return mail;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPerson that = (ContactPerson) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getMobilePhone(), that.getMobilePhone()) &&
                Objects.equals(getNormalPhone(), that.getNormalPhone()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getMobilePhone(), getNormalPhone(), getMail(), getAddress());
    }

    public boolean isFilledIn(Object data) {
        return data != null;
    }
}
