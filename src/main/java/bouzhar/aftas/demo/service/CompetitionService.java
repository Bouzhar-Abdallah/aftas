package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.competition.CompetitionReq;
import bouzhar.aftas.demo.dto.competition.CompetitionSimple;
import bouzhar.aftas.demo.entity.Competition;
import bouzhar.aftas.demo.exceptions.competition.CompetitionAlreadyExisting;
import bouzhar.aftas.demo.exceptions.competition.CompetitionNotFound;
import bouzhar.aftas.demo.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;
    public CompetitionReq create(CompetitionReq newCompetition) {
        if (competitionRepository.existsById(newCompetition.getCode())) throw new CompetitionAlreadyExisting();
        Competition competition = modelMapper.map(newCompetition, Competition.class);
        return modelMapper.map(competitionRepository.save(competition),CompetitionReq.class);
    }

    public CompetitionReq getCompetition(String code) {
        Competition competition = competitionRepository.findById(code).orElseThrow(
                () -> new CompetitionNotFound()
        );
        return modelMapper.map(competition,CompetitionReq.class);
    }

    public List<CompetitionReq> getAllCompetitions() {
        return competitionRepository.findAll().stream()
                .map(
                        competition -> modelMapper.map(competition,CompetitionReq.class)
                ).toList();
    }

    public CompetitionReq update(CompetitionReq newCompetition) {
        if (!competitionRepository.existsById(newCompetition.getCode())) throw new CompetitionNotFound();
        Competition competition = modelMapper.map(newCompetition, Competition.class);
        return modelMapper.map(competitionRepository.save(competition),CompetitionReq.class);
    }

    public CompetitionReq deleteCompetition(String code) {
        Competition competition = competitionRepository.findById(code).orElseThrow(
                () -> new CompetitionNotFound()
        );
        competitionRepository.deleteById(code);
        return modelMapper.map(competition,CompetitionReq.class);
    }
}
