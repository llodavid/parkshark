package be.biggerboat.domain.members;

import be.biggerboat.domain.Address.Address;
import be.biggerboat.domain.Address.AddressRepository;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.licenseplates.LicensePlateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(DatabaseConfig.class)
class MemberRepositoryTest {

    private MemberRepository memberRepository;
    private AddressRepository addressRepository;
    private LicensePlateRepository licensePlateRepository;

    @Inject
    public MemberRepositoryTest(MemberRepository memberRepository, AddressRepository addressRepository, LicensePlateRepository licensePlateRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.licensePlateRepository = licensePlateRepository;
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
                        .withZipcode("5436")
                        .withCity("Blobcity")
                        .withCountry("Blobland")
                        .build())
                .withPhoneNumber("0558468")
                .build();

        memberRepository.registerMember(member);
        assertNotNull(memberRepository);
    }

}