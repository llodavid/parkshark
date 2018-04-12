package be.biggerboat.domain.divisions;

import be.biggerboat.utilities.exceptions.ParksharkException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DataJpaTest
class DivisionTest {

    @Test
    void createDivision_givenEmptyFields_throwsException() {
        assertThatExceptionOfType(ParksharkException.class)
                .isThrownBy(()->new Division ("Peter","Bobby",""))
                .withMessage("Please fill in all the required fields.");
    }
}