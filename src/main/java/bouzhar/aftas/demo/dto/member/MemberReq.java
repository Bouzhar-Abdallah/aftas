package bouzhar.aftas.demo.dto.member;

import bouzhar.aftas.demo.enums.IdentityDocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class MemberReq {
    private Integer num;

    private String name;

    private String familyName;

    private LocalDate accessionDate;

    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    private String identityNumber;
}
