package be.biggerboat.service.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;
import be.biggerboat.domain.members.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(DatabaseConfig.class)
class MemberServiceTest {

    private MemberService memberService;

    private Member member1;
    private Member member2;

    @BeforeEach
    void setup() {
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

    }

    @Autowired
    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    @Transactional
    void createMember_happyPath() {
        Member member = new Member.MemberBuilder()
                .withMemberFirstName("Bob")
                .withMemberLastName("Blob")
                .withMemberEmail("Bobblob@live.com")
                .withAddress(new Address.AddressBuilder()
                        .withStreet("Kersktraat")
                        .withHousenumber("24")
                        .withZipcode(new Zipcode("5436", "53454"))
                        .build())
                .withPhoneNumber("0558468")
                .withLicensePlate(new LicensePlate("354545", "654543543"))
                .build();
        memberService.createMember(member);
        assertThat(member.getMemberId()).isNotEqualTo(0);
    }

    @Test
    void createLicensePlate_HappyPath() {
        Member member = new Member.MemberBuilder()
                .withMemberFirstName("Bob")
                .withMemberLastName("Blob")
                .withMemberEmail("Bobblob@live.com")
                .withAddress(new Address.AddressBuilder()
                        .withStreet("Kersktraat")
                        .withHousenumber("24")
                        .withZipcode(new Zipcode("5436", "53454"))
                        .build())
                .withPhoneNumber("0558468")
                .withLicensePlate(new LicensePlate("354545", "654543543"))
                .build();
        memberService.createMember(member);

        LicensePlate licensePlate = new LicensePlate("123546", "Belgium");

        memberService.createLicensePlate(member.getMemberId(), licensePlate);

        assertThat(licensePlate.getLicenseId()).isNotEqualTo(0);
    }

    @Test
    void readAllMembers_happyPath() {
        memberService.createMember(member1);
        memberService.createMember(member2);

        assertThat(memberService.readAllMembers()).contains(member1, member2);
    }

}