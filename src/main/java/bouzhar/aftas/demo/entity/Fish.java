package bouzhar.aftas.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fish {

    @Id
    private String name;

    private Float averageWeight;

    @ManyToOne
    private Level level;
}
