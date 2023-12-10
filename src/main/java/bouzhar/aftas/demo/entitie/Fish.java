package bouzhar.aftas.demo.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Fish {

    @Id
    private String name;

    private Float averageWeight;

    @ManyToOne
    private Level level;
}
