package bouzhar.aftas.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numberOfFish;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Fish fish;
}
