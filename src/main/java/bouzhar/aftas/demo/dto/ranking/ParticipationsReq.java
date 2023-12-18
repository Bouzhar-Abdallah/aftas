package bouzhar.aftas.demo.dto.ranking;

import bouzhar.aftas.demo.dto.competition.CompetitionSimple;
import bouzhar.aftas.demo.dto.member.MemberSimple;
import lombok.Data;

@Data
public class ParticipationsReq {
    private String competition_code;
    private Integer member_num;
}
