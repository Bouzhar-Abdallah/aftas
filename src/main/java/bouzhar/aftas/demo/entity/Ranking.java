package bouzhar.aftas.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
