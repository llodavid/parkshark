package be.biggerboat.api.addresses;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class AddressMapper {

    @Autowired
    public AddressMapper() {
    }

    public AddressDto toDto(Address address) {
        return new AddressDto()
                .withStreet(address.getStreet())
                .withHousenumber(address.getHousenumber())
                .withZipcode(address.getZipcode().getZipcode())
                .withCity(address.getZipcode().getCity());
    }

    public Address toDomain(AddressDto addressDto) {
        return new Address.AddressBuilder()
                .withStreet(addressDto.street)
                .withHousenumber(addressDto.housenumber)
                .withZipcode(new Zipcode(addressDto.zipcode,addressDto.city))
                .build();
    }

}
