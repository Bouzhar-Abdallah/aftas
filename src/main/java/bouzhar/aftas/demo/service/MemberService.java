package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.member.MemberReq;
import bouzhar.aftas.demo.dto.member.MemberSimple;
import bouzhar.aftas.demo.entity.Member;
import bouzhar.aftas.demo.exceptions.member.MemberNotFoundException;
import bouzhar.aftas.demo.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public MemberSimple create(MemberReq memberReq) {
        Member member = modelMapper.map(memberReq,Member.class);
        return modelMapper.map(memberRepository.save(member),MemberSimple.class);
    }

    public MemberSimple getMemberByNum(Integer num) {
        Member member = memberRepository.findById(num).orElseThrow(
                ()-> new MemberNotFoundException()
        );
        return modelMapper.map(member,MemberSimple.class);
    }

    public List<MemberSimple> getAllMembers() {
        return memberRepository.findAll().stream().map(
                member -> modelMapper.map(member,MemberSimple.class)
        ).toList();
    }

    public MemberSimple updateMember(MemberReq memberToUpdate) {
        memberRepository.findById(memberToUpdate.getNum()).orElseThrow(
                ()-> new MemberNotFoundException()
        );
        return modelMapper.map(modelMapper.map(memberToUpdate,Member.class),MemberSimple.class);
    }

    public MemberSimple delete(Integer num) {
        Member member = memberRepository.findById(num).orElseThrow(
                ()-> new MemberNotFoundException()
        );
        memberRepository.deleteById(num);
        return modelMapper.map(member,MemberSimple.class);
    }
}
