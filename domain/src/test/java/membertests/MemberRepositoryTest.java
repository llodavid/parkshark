package membertests;

import be.biggerboat.domain.Address.Address;
import be.biggerboat.domain.Address.AddressRepository;
import be.biggerboat.domain.databaseconfig.DatabaseConfig;
import be.biggerboat.domain.licenseplates.LicensePlateRepository;
import be.biggerboat.domain.members.Member;
import be.biggerboat.domain.members.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@SpringJUnitConfig
public class MemberRepositoryTest {

    private MemberRepository memberRepository;
    private AddressRepository addressRepository;
    private LicensePlateRepository licensePlateRepository;
    private Member member;

    @Autowired
    public MemberRepositoryTest(MemberRepository memberRepository, AddressRepository addressRepository, LicensePlateRepository licensePlateRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.licensePlateRepository = licensePlateRepository;
    }


    @Before
    public void setup() {
        member = new Member.MemberBuilder()
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
    }

    @Test
    public void registerMember() {
        Member expected = memberRepository.registerMember(member);
        assertNotNull(memberRepository);
    }


}