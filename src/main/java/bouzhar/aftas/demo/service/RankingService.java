package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.ranking.ParticipationsReq;
import bouzhar.aftas.demo.dto.ranking.RankingRes;
import bouzhar.aftas.demo.dto.ranking.RankingSimple;
import bouzhar.aftas.demo.entity.Competition;
import bouzhar.aftas.demo.entity.Member;
import bouzhar.aftas.demo.entity.RankId;
import bouzhar.aftas.demo.entity.Ranking;
import bouzhar.aftas.demo.exceptions.competition.CompetitionAlreadyPassed;
import bouzhar.aftas.demo.exceptions.competition.CompetitionDeadlinePassed;
import bouzhar.aftas.demo.exceptions.competition.CompetitionMaxParticipantsReached;
import bouzhar.aftas.demo.exceptions.competition.CompetitionNotFound;
import bouzhar.aftas.demo.exceptions.member.MemberNotFoundException;
import bouzhar.aftas.demo.exceptions.participation.ParticipationAlreadyExisting;
import bouzhar.aftas.demo.exceptions.participation.ParticipationNotFound;
import bouzhar.aftas.demo.repository.CompetitionRepository;
import bouzhar.aftas.demo.repository.MemberRepository;
import bouzhar.aftas.demo.repository.RankingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RankingService {
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    public RankingRes createParticipation(ParticipationsReq participationsReq) {

        Competition competition = competitionRepository.findById(participationsReq.getCompetition_code()).orElseThrow(
                () -> new CompetitionNotFound()
        );

        if (competition.getDate().isBefore(LocalDate.now())) throw new CompetitionAlreadyPassed();
        if (competition.getTimeRemainingBeforeStart().getDays() == 0) throw new CompetitionDeadlinePassed();
        if (competition.getNumberOfParticipants() == competition.getParticipantsCountSubscribed())
            throw new CompetitionMaxParticipantsReached();

        Member member = memberRepository.findById(participationsReq.getMember_num()).orElseThrow(
                () -> new MemberNotFoundException()
        );


        Ranking ranking = new Ranking();
        RankId rankId = new RankId(competition, member);
        if (rankingRepository.existsById(rankId)) throw new ParticipationAlreadyExisting();
        ranking.setRankId(rankId);
        ranking.setCompetition(competition);
        ranking.setMember(member);
        ranking.setScore(0);
        ranking.setRank(0);
        rankingRepository.save(ranking);
        return modelMapper.map(rankingRepository.save(ranking), RankingRes.class);
    }

    public RankingRes removeParticipation(ParticipationsReq participationsReq) {
        Competition competition = competitionRepository.findById(participationsReq.getCompetition_code()).orElseThrow(
                () -> new CompetitionNotFound()
        );
        Member member = memberRepository.findById(participationsReq.getMember_num()).orElseThrow(
                () -> new MemberNotFoundException()
        );

        Ranking ranking = rankingRepository.findById(new RankId(competition, member)).orElseThrow(
                () -> new ParticipationNotFound()
        );
        rankingRepository.delete(ranking);
        return modelMapper.map(ranking, RankingRes.class);
    }
}
