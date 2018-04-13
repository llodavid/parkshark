package be.biggerboat.api.contactpersons;

import be.biggerboat.api.addresses.AddressMapper;
import be.biggerboat.domain.contactpersons.ContactPerson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class ContactPersonMapper {

    @Autowired
    public ContactPersonMapper() {
    }

    @Autowired
    private AddressMapper addressMapper;

    public ContactPersonDto toDto(ContactPerson contactPerson) {
        return new ContactPersonDto()
                .withName(contactPerson.getName())
                .withMobilePhone(contactPerson.getMobilePhone())
                .withNormalPhone(contactPerson.getNormalPhone())
                .withMail(contactPerson.getMail())
                .withAddress(addressMapper.toDto(contactPerson.getAddress()));
    }

    public ContactPerson toDomain(ContactPersonDto contactPersonDto) {
        return new ContactPerson(contactPersonDto.name, contactPersonDto.mobilePhone, contactPersonDto.normalPhone, contactPersonDto.mail, addressMapper.toDomain(contactPersonDto.address));
    }

}
