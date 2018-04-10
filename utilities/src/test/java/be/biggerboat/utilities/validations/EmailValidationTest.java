package be.biggerboat.utilities.validations;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidationTest {

    @Test
    public void validateEmail_givenValidEmailFormat_returnTrue() {
        assertThat(EmailValidation.isValidEmail("david.vdb@hotmail.com")).isTrue();
        assertThat(EmailValidation.isValidEmail("born.tobe@4live.com")).isTrue();
    }
    @Test
    public void validateEmail_givenInValidEmailFormat_returnsFalse() {
        assertThat(EmailValidation.isValidEmail("MLAThotmail.com")).isFalse();
        assertThat(EmailValidation.isValidEmail("AMAURY@hotmailDOTcom")).isFalse();
        assertThat(EmailValidation.isValidEmail("david.vdb@hotmail@com")).isFalse();
    }
}