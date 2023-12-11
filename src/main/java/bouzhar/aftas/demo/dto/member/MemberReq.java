package bouzhar.aftas.demo.dto.member;

import bouzhar.aftas.demo.enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberReq {
    private Integer num;

    private String name;

    private String familyName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate accessionDate;

    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    private String identityNumber;
}
