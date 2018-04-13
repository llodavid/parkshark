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
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.SpringApplication.run;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = MemberControllerTest.MemberControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)

class MemberControllerTest {

    Member member1;
    Member member2;

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

    @Test
    void readAllMembers_happyPath() {
        member1 = new Member.MemberBuilder()
                .withMemberFirstName("Bob")
                .withMemberLastName("Blob")
                .withMemberEmail("Bobblob@live.com")
                .withAddress(new Address.AddressBuilder()
                        .withStreet("Kersktraat")
                        .withHousenumber("24")
                        .withZipcode(new Zipcode("5412", "552114"))
                        .build())
                .withPhoneNumber("0558468")
                .withLicensePlate(new LicensePlate("354545", "The Netherlands"))
                .build();

        member2 = new Member.MemberBuilder()
                .withMemberFirstName("Jan")
                .withMemberLastName("Janssen")
                .withMemberEmail("Janjanssen@live.com")
                .withAddress(new Address.AddressBuilder()
                        .withStreet("Kersktraat")
                        .withHousenumber("25")
                        .withZipcode(new Zipcode("5412", "552114"))
                        .build())
                .withPhoneNumber("05584324")
                .withLicensePlate(new LicensePlate("354125", "Belgium"))
                .build();

        memberRepository.registerMember(member1);
        memberRepository.registerMember(member2);

        MemberDto[] memberDtoArray = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "members"), MemberDto[].class);
        List<MemberDto> memberList = Arrays.asList(memberDtoArray);

        MemberDto memberDto1 = memberMapper.toDto(member1);
        MemberDto memberDto2 = memberMapper.toDto(member2);

        Assertions.assertThat(memberList).contains(memberDto1, memberDto2);
    }


    @SpringBootApplication(scanBasePackages = "be.biggerboat")
    public static class MemberControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(MemberControllerIntegrationTestRunner.class, args);
        }
    }
}