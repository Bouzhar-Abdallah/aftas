package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "member")
public class MemberController {
    private static MemberService memberService;
}
