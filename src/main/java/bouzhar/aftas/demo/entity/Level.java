package bouzhar.aftas.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Level {

    @Id
    private Integer code;

    private String descritpion;

    private Integer points;
}
