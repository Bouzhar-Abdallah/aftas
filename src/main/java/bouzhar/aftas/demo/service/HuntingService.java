package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.hunting.HuntingReq;
import bouzhar.aftas.demo.dto.hunting.HuntingRes;
import bouzhar.aftas.demo.entity.*;
import bouzhar.aftas.demo.exceptions.competition.CompetitionNotFound;
import bouzhar.aftas.demo.exceptions.fish.FishNotFoundException;
import bouzhar.aftas.demo.exceptions.member.MemberNotFoundException;
import bouzhar.aftas.demo.exceptions.participation.ParticipationNotFound;
import bouzhar.aftas.demo.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HuntingService {
    private final HuntingRepository huntingRepository;
    private final FishRepository fishRepository;
    private final MemberRepository memberRepository;
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;

    public HuntingRes addHunt(HuntingReq hunt) {
        Fish fish = fishRepository.findById(hunt.getFish_name()).orElseThrow(
                () -> new FishNotFoundException(hunt.getFish_name())
        );
        Competition competition = competitionRepository.findById(hunt.getCompetition_code()).orElseThrow(
                () -> new CompetitionNotFound(hunt.getCompetition_code())
        );
        Member member = memberRepository.findById(hunt.getMember_num()).orElseThrow(
                () -> new MemberNotFoundException(String.valueOf(hunt.getMember_num()))
        );

        RankId rankId = new RankId(competition, member);
        if (!rankingRepository.existsById(rankId)) throw new ParticipationNotFound();

        Ranking ranking = rankingRepository.findById(rankId).orElseThrow(
                () -> new ParticipationNotFound()
        );

        Hunting hunting = huntingRepository.findByCompetitionAndMemberAndFish(competition, member, fish);

        if (hunting == null) {
            System.out.println("hunting is null");
            Hunting newHunt = new Hunting();
            newHunt.setCompetition(competition);
            newHunt.setFish(fish);
            newHunt.setMember(member);
            newHunt.setNumberOfFish(hunt.getNumberOfFish());
            ranking.setScore((fish.getLevel().getPoints()*hunt.getNumberOfFish())+ranking.getScore());
            huntingRepository.save(newHunt);
            setRanking(competition);
            return modelMapper.map(newHunt, HuntingRes.class);
        } else {

            System.out.println("hunting is not null");
            hunting.setCompetition(competition);
            hunting.setMember(member);
            hunting.setFish(fish);
            hunting.setNumberOfFish(hunting.getNumberOfFish() + hunt.getNumberOfFish());
            ranking.setScore((fish.getLevel().getPoints()*hunt.getNumberOfFish())+ranking.getScore());
            huntingRepository.save(hunting);
            setRanking(competition);
            return modelMapper.map(hunting, HuntingRes.class);
        }
    }

    private void setRanking(Competition competition){
        List<Ranking> rankins = competition.getRankings();

        rankins.sort((o1, o2) -> o2.getScore() - o1.getScore());
        for (int i = 0; i < rankins.size(); i++) {
            rankins.get(i).setRank(i + 1);
        }
        rankingRepository.saveAll(rankins);
    }
}
