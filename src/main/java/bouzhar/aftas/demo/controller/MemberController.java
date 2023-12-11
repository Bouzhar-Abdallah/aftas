package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.member.MemberReq;
import bouzhar.aftas.demo.dto.member.MemberRes;
import bouzhar.aftas.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "member")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public MemberRes create(@RequestBody MemberReq memberReq){
        return memberService.create(memberReq);
    }
    @GetMapping(path = "{num}")
    public MemberRes getMember(@PathVariable Integer num){
        return memberService.getMemberByNum(num);
    }

    @GetMapping
    public List<MemberRes> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PutMapping
    public MemberRes updateMember(@RequestBody MemberReq memberToUpdate){
        return memberService.updateMember(memberToUpdate);
    }

    @DeleteMapping(path = "{num}")
    public MemberRes deleteMember(@PathVariable Integer num){
        return memberService.delete(num);
    }
}
