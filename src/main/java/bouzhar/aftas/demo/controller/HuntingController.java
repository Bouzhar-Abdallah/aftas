package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.hunting.HuntingReq;
import bouzhar.aftas.demo.dto.hunting.HuntingRes;
import bouzhar.aftas.demo.service.HuntingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "hunting")
@AllArgsConstructor
public class HuntingController {
    private final HuntingService huntingService;

    @PostMapping
    public HuntingRes addHunt(@RequestBody HuntingReq hunt){
        return huntingService.addHunt(hunt);
    }
}
