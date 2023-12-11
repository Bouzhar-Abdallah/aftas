package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.competition.CompetitionReq;
import bouzhar.aftas.demo.dto.competition.CompetitionSimple;
import bouzhar.aftas.demo.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION +"competition")
@AllArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping
    public CompetitionReq createCompetition(@RequestBody @Valid CompetitionReq newCompetition){
        return competitionService.create(newCompetition);
    }

    @GetMapping(path = "{code}")
    public CompetitionReq getCompetition(@PathVariable String code){
        return competitionService.getCompetition(code);
    }

    @GetMapping
    public List<CompetitionReq> getAllCompetitions(){
        return competitionService.getAllCompetitions();
    }

    @PutMapping
    public CompetitionReq updateCompetition(@RequestBody @Valid CompetitionReq newCompetition){
        return competitionService.update(newCompetition);
    }

    @DeleteMapping(path = "{code}")
    public CompetitionReq deleteCompetition(@PathVariable String code){
        return competitionService.deleteCompetition(code);
    }
}
