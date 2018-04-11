package be.biggerboat.domain.divisions;

import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(DatabaseConfig.class)
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
}