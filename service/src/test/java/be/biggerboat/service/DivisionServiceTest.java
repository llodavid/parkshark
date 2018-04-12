package be.biggerboat.service;

import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.divisions.Division;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringJUnitConfig(DatabaseConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class DivisionServiceTest {

    private DivisionService divisionService;

    @Autowired
    public DivisionServiceTest(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @Test
    void createDivision_happyPath() {
        Division division = new Division("Switchfully","Cegeka", "Reinout Delestinne");

        divisionService.createDivision(division);

        assertThat(division.getId()).isNotEqualTo(0);
    }

    @Test
    void readDivisions_happyPath(){
        Division division1 = new Division("E1", "ONE1", "dire1");
        Division division2 = new Division("E2", "ONE2", "dire2");
        Division division3 = new Division("E3", "ONE3", "dire3");

        divisionService.createDivision(division1);
        divisionService.createDivision(division2);
        divisionService.createDivision(division3);

        List<Division> divisions = divisionService.readDivisions();

        assertThat(divisions).contains(division1, division2, division3);
    }
}