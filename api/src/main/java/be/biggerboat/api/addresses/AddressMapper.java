package be.biggerboat.api.addresses;

import be.biggerboat.domain.addresses.Address;
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
                .withZipcode(address.getZipcode())
                .withCity(address.getCity())
                .withCountry(address.getCountry());
    }

    public Address toDomain(AddressDto addressDto) {
        return new Address.AddressBuilder()
                .withStreet(addressDto.street)
                .withHousenumber(addressDto.housenumber)
                .withZipcode(addressDto.zipcode)
                .withCity(addressDto.city)
                .withCountry(addressDto.country)
                .build();
    }

}
