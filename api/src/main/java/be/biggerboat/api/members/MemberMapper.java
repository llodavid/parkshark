package be.biggerboat.api.members;

import be.biggerboat.domain.members.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MemberMapper {

    @Autowired
    public MemberMapper() {
    }

    public MemberDto toDto(Member member) {
        return new MemberDto()
                .withMemberId(member.getMemberId())
                .withMemberFirstName(member.getMemberFirstName())
                .withMemberLastName(member.getMemberLastName())
                .withMemberEmail(member.getMemberEmail())
                .withPhoneNumber(member.getPhoneNumber())
                .withAddress(member.getAddress())
                .withLicensePlate(member.getLicensePlate())
                .withRegistrationDate(member.getRegistrationDate());
    }

    public Member toDomain(MemberDto memberDto) {
        return new Member.MemberBuilder()
                .withMemberFirstName(memberDto.getMemberFirstName())
                .withMemberLastName(memberDto.getMemberLastName())
                .withMemberEmail(memberDto.getMemberEmail())
                .withPhoneNumber(memberDto.getPhoneNumber())
                .withAddress(memberDto.getAddress())
                .withLicensePlate(memberDto.getLicensePlate())
                .build();
    }

}
