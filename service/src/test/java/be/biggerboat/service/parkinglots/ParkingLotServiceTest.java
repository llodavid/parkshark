package be.biggerboat.service.parkinglots;

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
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
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
        Division division = new Division("difnsdjg", "lsgjlsd", "fsfjdj");
        divisionRepository.save(division);
        ParkingLot parkingLot = new ParkingLot("parkinglottest", division, 5, 50.3);
        parkingLotService.createParkingLot(parkingLot);

        Assertions.assertThat(parkingLot.getId()).isNotEqualTo(0);
    }
}