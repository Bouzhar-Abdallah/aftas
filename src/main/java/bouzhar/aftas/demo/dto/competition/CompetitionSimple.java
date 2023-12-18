package bouzhar.aftas.demo.dto.competition;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionSimple {
    private String code;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfParticipants;

    private String location;

    private Float amount;

    private TimeRemaining timeRemainingBeforeStart;
}
