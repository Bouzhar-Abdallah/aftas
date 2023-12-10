package bouzhar.aftas.demo.dto.fish;

import lombok.Data;

@Data
public class FishReq {
    private String name;
    private Float averageWeight;
    private Integer level_code;
}
