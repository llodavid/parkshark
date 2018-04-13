package be.biggerboat.domain.parkinglots;

import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringJUnitConfig(DatabaseConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class ParkingLotRepositoryTest {

    private ParkingLotRepository parkingLotRepository;
    private DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotRepositoryTest(ParkingLotRepository parkingLotRepository, DivisionRepository divisionRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.divisionRepository = divisionRepository;
    }

    @Test
    void save() {
        Division division = new Division("divisionTest", "originalNameTest", "directorTest");
        divisionRepository.save(division);

        ParkingLot parkingLot = new ParkingLot("parkingTest", division, 10, 50.2);

        parkingLotRepository.save(parkingLot);

        Assertions.assertThat(parkingLot.getId()).isNotEqualTo(0);
    }
}