package be.biggerboat.api.contactpersons;

import be.biggerboat.api.addresses.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.inject.Named;
import java.util.Objects;

@Named
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactPersonDto {

    public String name;
    public String mobilePhone;
    public String normalPhone;
    public String mail;
    public AddressDto address;

    public ContactPersonDto withName(String name) {
        this.name = name;
        return this;
    }

    public ContactPersonDto withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactPersonDto withNormalPhone(String normalPhone) {
        this.normalPhone = normalPhone;
        return this;
    }

    public ContactPersonDto withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactPersonDto withAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPersonDto that = (ContactPersonDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(normalPhone, that.normalPhone) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, mobilePhone, normalPhone, mail, address);
    }
}
