package be.biggerboat.domain.divisions;

import be.biggerboat.domain.databaseconfig.DatabaseConfig;
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
class DivisionRepositoryTest {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionRepositoryTest(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Test
    void save() {
        Division newDivision = new Division("DisneyLand", "DisneyWorld","Mickey Mouse");
        divisionRepository.save(newDivision);

        assertThat(newDivision.getId()).isNotEqualTo(0);
    }

    @Test
    void getDivisions(){
        Division division1 = new Division("D1", "ON1", "dir1");
        Division division2 = new Division("D2", "ON2", "dir2");
        Division division3 = new Division("D3", "ON3", "dir3");

        divisionRepository.save(division1);
        divisionRepository.save(division2);
        divisionRepository.save(division3);

        List<Division> divisions = divisionRepository.getDivisions();

        assertThat(divisions).contains(division1, division2, division3);
    }
}