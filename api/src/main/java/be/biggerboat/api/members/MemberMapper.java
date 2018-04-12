package be.biggerboat.api.members;

import be.biggerboat.api.addresses.AddressMapper;
import be.biggerboat.api.licenseplates.LicensePlateMapper;
import be.biggerboat.domain.members.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class MemberMapper {

    private AddressMapper addressMapper;
    private LicensePlateMapper licensePlateMapper;

    @Autowired
    public MemberMapper(AddressMapper addressMapper, LicensePlateMapper licensePlateMapper) {
        this.addressMapper = addressMapper;
        this.licensePlateMapper = licensePlateMapper;
    }

    public MemberDto toDto(Member member) {
        return new MemberDto()
                .withMemberId(member.getMemberId())
                .withMemberFirstName(member.getMemberFirstName())
                .withMemberLastName(member.getMemberLastName())
                .withMemberEmail(member.getMemberEmail())
                .withPhoneNumber(member.getPhoneNumber())
                .withAddress(addressMapper.toDto(member.getAddress()))
                //.withLicensePlate(licensePlateMapper.toDto((member.getLicensePlate())))
                .withRegistrationDate(member.getRegistrationDate());
    }

    public Member toDomain(MemberDto memberDto) {
        return new Member.MemberBuilder()
                .withMemberFirstName(memberDto.memberFirstName)
                .withMemberLastName(memberDto.memberLastName)
                .withMemberEmail(memberDto.memberEmail)
                .withPhoneNumber(memberDto.phoneNumber)
                .withAddress(addressMapper.toDomain(memberDto.address))
                //.withLicensePlate(licensePlateMapper.toDomain(memberDto.licensePlate))
                .build();
    }

}
