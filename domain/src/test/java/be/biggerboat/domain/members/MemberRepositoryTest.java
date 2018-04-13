package be.biggerboat.domain.members;

import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.licenseplates.LicensePlate;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(DatabaseConfig.class)
class MemberRepositoryTest {

    private MemberRepository memberRepository;

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
    public MemberRepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Test
    public void registerMember_happyPath() {
        memberRepository.registerMember(member1);
        assertThat(member1.getMemberId()).isNotEqualTo(0);
    }

    @Test
    public void readAllMembers_happyPath() {
        memberRepository.registerMember(member1);
        memberRepository.registerMember(member2);

        assertThat(memberRepository.readAllMembers()).contains(member1, member2);
    }

}