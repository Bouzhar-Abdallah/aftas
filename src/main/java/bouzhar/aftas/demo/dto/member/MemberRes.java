package bouzhar.aftas.demo.dto.member;

import bouzhar.aftas.demo.dto.hunting.HuntingSimple;
import bouzhar.aftas.demo.dto.ranking.RankingSimple;
import bouzhar.aftas.demo.enums.IdentityDocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class MemberRes {
    private Integer num;

    private String name;

    private String familyName;

    private LocalDate accessionDate;

    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    private String identityNumber;

    private List<HuntingSimple> huntings;
    private List<RankingSimple> rankings;
}
