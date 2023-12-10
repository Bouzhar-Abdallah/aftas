package bouzhar.aftas.demo.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Hunting {
    @Id
    private Integer id;

    private Integer numberOfFish;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Fish fish;
}
