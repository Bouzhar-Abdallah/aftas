package bouzhar.aftas.demo.dto.hunting;

import lombok.Data;

@Data
public class HuntingReq {
    private String competition_code;
    private Integer member_num;
    private String fish_name;
    private Integer numberOfFish;
}
