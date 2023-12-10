package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.service.RankingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "ranking")
public class RankingController {
    private static RankingService rankingService;
}
