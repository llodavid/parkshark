package be.biggerboat.service;

import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.divisions.Division;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(DatabaseConfig.class)
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
}