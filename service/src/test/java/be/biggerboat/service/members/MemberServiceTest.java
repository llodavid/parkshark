package be.biggerboat.service.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.licenseplates.LicensePlate;
import be.biggerboat.domain.members.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(DatabaseConfig.class)
class MemberServiceTest {

    private MemberService memberService;

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
                        .withZipcode("5436")
                        .withCity("Blobcity")
                        .withCountry("Blobland")
                        .build())
                .withPhoneNumber("0558468")
                .withLicensePlate(new LicensePlate("354545", "654543543"))
                .build();
        memberService.createMember(member);
        assertThat(member.getMemberId()).isNotEqualTo(0);
    }

}