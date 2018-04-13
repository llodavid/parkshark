package be.biggerboat.api.members;

import be.biggerboat.api.addresses.AddressDto;
import be.biggerboat.api.licenseplates.LicensePlateDto;
import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;
import be.biggerboat.domain.members.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.SpringApplication.run;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = MemberControllerTest.MemberControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)

class MemberControllerTest {

    @LocalServerPort
    private int port;
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private MemberController memberController;

    @Autowired
    public MemberControllerTest(MemberRepository memberRepository, MemberMapper memberMapper, MemberController memberController) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.memberController = memberController;
    }

    @Test
    void createMember_happyPath() {
        MemberDto memberDto = new MemberDto()
                .withMemberFirstName("Jesus")
                .withMemberLastName("God")
                .withMemberEmail("jesus@live.com")
                .withAddress(new AddressDto()
                        .withStreet("Kersktraat")
                        .withHousenumber("24")
                        .withZipcode("5624")
                        .withCity("Wachtebeke"))
                .withPhoneNumber("0558468")
                .withLicensePlates(Arrays.asList((new LicensePlateDto()
                        .withPlateNumber("354545")
                        .withIssuingCountry("654543543"))));

        MemberDto memberDto1 = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "members"), memberDto, MemberDto.class);

        assertThat(memberDto1.memberId).isNotEqualTo(0);
    }


    @SpringBootApplication(scanBasePackages = "be.biggerboat")
    public static class MemberControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(MemberControllerIntegrationTestRunner.class, args);
        }
    }
}