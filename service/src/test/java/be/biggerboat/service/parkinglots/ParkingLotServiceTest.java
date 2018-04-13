package be.biggerboat.service.parkinglots;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import be.biggerboat.domain.parkinglots.ParkingLot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringJUnitConfig(DatabaseConfig.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
class ParkingLotServiceTest {

    private ParkingLotService parkingLotService;
    private DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotServiceTest(ParkingLotService parkingLotService, DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
        this.parkingLotService = parkingLotService;
    }

    @Test
    void createParkingLot() {
//        Division division = new Division("difnsdjg", "lsgjlsd", "fsfjdj");
//        divisionRepository.save(division);
//        Zipcode zipcode = new Zipcode("dfdfdf", "dddfdf");
//        Address address = new Address.AddressBuilder().withStreet("eerer").withZipcode(zipcode).withHousenumber("5454").build();
//        ParkingLot parkingLot = new ParkingLot("parkingTest", division, 10, 50.2, address);
//        parkingLotService.createParkingLot(parkingLot);
//
//        Assertions.assertThat(parkingLot.getId()).isNotEqualTo(0);
    }
}