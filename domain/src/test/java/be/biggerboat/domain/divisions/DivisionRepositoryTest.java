package be.biggerboat.domain.divisions;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class DivisionRepositoryTest {

    private DivisionRepository divisionRepository;

    @Inject
    public DivisionRepositoryTest(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Test
    void save() {
        Division newDivision = new Division("DisneyLand", "DisneyWorld","Mickey Mouse");
        
    }
}