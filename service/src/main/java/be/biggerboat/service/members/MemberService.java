package be.biggerboat.service.members;

import be.biggerboat.domain.addresses.AddressRepository;
import be.biggerboat.domain.licenseplates.LicensePlateRepository;
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
    private AddressRepository addressRepository;
    private LicensePlateRepository licensePlateRepository;
    private MemberValidator memberValidator;

    @Autowired
    public MemberService(MemberRepository memberRepository, AddressRepository addressRepository, LicensePlateRepository licensePlateRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.licensePlateRepository = licensePlateRepository;
    }

    public Member createMember(Member member) {
        if (!memberValidator.isValidForCreation(member)) {
            memberValidator.throwInvalidStateExeption(member, "creation");

        }
        return memberRepository.registerMember(member);
    }

}