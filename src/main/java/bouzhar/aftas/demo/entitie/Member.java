package bouzhar.aftas.demo.entitie;

import bouzhar.aftas.demo.enums.IdentityDocumentType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Member {
    @Id
    private Integer num;

    private String name;

    private String familyName;

    private LocalDate accessionDate;

    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    private String identityNumber;

    @OneToMany(mappedBy = "member")
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "member")
    private List<Ranking> rankings;
}
