package be.biggerboat.service.members;

import be.biggerboat.domain.members.Member;
import be.biggerboat.domain.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {
    private MemberRepository memberRepository;
    private MemberValidator memberValidator;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
//        if (!memberValidator.isValidForCreation(member)) {
//            memberValidator.throwInvalidStateException(member, "creation");
//        }
        return memberRepository.registerMember(member);
    }

}