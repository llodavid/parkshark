package be.biggerboat.domain.members;

import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.utilities.exceptions.ParksharkException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    public void createMember_givenMissingRequiredFields_throwsException() {
        assertThatExceptionOfType(ParksharkException.class)
                .isThrownBy(() ->
                        new Member.MemberBuilder()
                                .withMemberFirstName("Bob")
                                .withMemberLastName("Blob")
                                .withMemberEmail("Bobblob@live.com")
                                .withPhoneNumber("0558468")
                                .withLicensePlate(new LicensePlate("354545", "654543543"))
                                .build())
                .withMessage("Please provide all the necessary arguments.");
    }

}