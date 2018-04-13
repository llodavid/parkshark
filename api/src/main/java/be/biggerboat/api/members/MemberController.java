package be.biggerboat.api.members;

import be.biggerboat.domain.members.MemberRepository;
import be.biggerboat.service.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/members"})
public class MemberController {
    MemberService memberService;
    MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto createMember(@RequestBody MemberDto memberDto) {
        return memberMapper.toDto(
                memberService.createMember(
                        memberMapper.toDomain(memberDto)
                )
        );
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDto> readAllMembers() {
        return memberService.readAllMembers().stream()
                .map(division -> memberMapper.toDto(division))
                .collect(Collectors.toList());
    }

}