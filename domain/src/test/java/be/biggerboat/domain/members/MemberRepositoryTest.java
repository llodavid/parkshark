package be.biggerboat.domain.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(DatabaseConfig.class)
class MemberRepositoryTest {

    private MemberRepository memberRepository;

    @Autowired
    public MemberRepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Test
    public void registerMember() {
        Member member = new Member.MemberBuilder()
                .withMemberFirstName("Bob")
                .withMemberLastName("Blob")
                .withMemberEmail("Bobblob@live.com")
                .withAddress(new Address.AddressBuilder()
                        .withStreet("Kersktraat")
                        .withHousenumber("24")
                        .withZipcode(new Zipcode("5412", "552114"))
                        .build())
                .withPhoneNumber("0558468")
                //.withLicensePlate(new LicensePlate("354545", "654543543"))
                .build();
        memberRepository.registerMember(member);
        assertThat(member.getMemberId()).isNotEqualTo(0);
    }

}