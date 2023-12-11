package bouzhar.aftas.demo.dto.fish;

import bouzhar.aftas.demo.entity.Level;
import lombok.Data;

@Data
public class FishRes {
    private String name;
    private Float averageWeight;
    private Level level;
}
