package bouzhar.aftas.demo.dto.ranking;

import bouzhar.aftas.demo.dto.competition.CompetitionSimple;
import bouzhar.aftas.demo.dto.member.MemberSimple;
import lombok.Data;

@Data
public class RankingRes {
    private Integer rank;
    private Integer score;
    private CompetitionSimple competition;
    private MemberSimple member;
}
