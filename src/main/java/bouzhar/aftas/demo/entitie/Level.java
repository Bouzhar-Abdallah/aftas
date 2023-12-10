package bouzhar.aftas.demo.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
