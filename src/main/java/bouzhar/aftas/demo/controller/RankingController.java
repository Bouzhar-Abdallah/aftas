package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.ranking.ParticipationsReq;
import bouzhar.aftas.demo.dto.ranking.RankingRes;
import bouzhar.aftas.demo.dto.ranking.RankingSimple;
import bouzhar.aftas.demo.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "ranking")
@AllArgsConstructor
public class RankingController {
    private final RankingService rankingService;

    @PostMapping("addparticipant")
    public RankingRes createParticipation(@RequestBody ParticipationsReq participationsReq){
        return rankingService.createParticipation(participationsReq);
    }
    @PostMapping("removeparticipant")
    public RankingRes removeParticipants(@RequestBody ParticipationsReq participationsReq){
        return rankingService.removeParticipation(participationsReq);
    }
}
