package bouzhar.aftas.demo.entitie;

import jakarta.persistence.*;

@Entity

public class Ranking {
    @EmbeddedId
    private RankId rankId;

    private Integer rank;

    private Integer score;

    @ManyToOne
    @MapsId("competition")
    private Competition competition;

    @ManyToOne
    @MapsId("member")
    private Member member;
}
