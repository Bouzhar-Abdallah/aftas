package bouzhar.aftas.demo.dto.competition;

import bouzhar.aftas.demo.dto.ranking.RankingSimple;
import bouzhar.aftas.demo.dto.ranking.RankingWithMember;
import bouzhar.aftas.demo.entity.Ranking;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class CompetitionReq {
    @Pattern(regexp = "^[a-zA-Z]{3}-\\d{2}-\\d{2}-\\d{2}$", message = "Code must be in the format ccc-dd-dd-dd")
    private String code;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")

    private LocalTime endTime;

    private Integer numberOfParticipants;

    @NotBlank(message = "shouldn't be blank")
    private String location;

    private Float amount;

    private TimeRemaining timeRemainingBeforeStart;
    private TimeRemaining timeRemainingBeforeEnd;

    private List<RankingWithMember> rankings;
}
