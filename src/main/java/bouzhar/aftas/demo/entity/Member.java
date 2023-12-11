package bouzhar.aftas.demo.entity;

import bouzhar.aftas.demo.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
