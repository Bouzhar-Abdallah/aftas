package bouzhar.aftas.demo.entity;

import bouzhar.aftas.demo.dto.competition.TimeRemaining;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Competition {
    @Id
    private String code;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfParticipants;

    private String location;

    private Float amount;

    @OneToMany(mappedBy = "competition")
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings;

    public TimeRemaining getTimeRemainingBeforeStart() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        if (now.isBefore(startDateTime)) {
            Duration duration = Duration.between(now, startDateTime);
            long days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
            long seconds = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).getSeconds();
            return new TimeRemaining(days, hours, minutes, seconds);
        } else {
            return new TimeRemaining(0, 0, 0, 0);
        }
    }
    public TimeRemaining getTimeRemainingBeforeEnd() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
        if (now.isBefore(endDateTime)) {
            Duration duration = Duration.between(now, endDateTime);
            long days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
            long seconds = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).getSeconds();
            return new TimeRemaining(days, hours, minutes, seconds);
        } else {
            return new TimeRemaining(0, 0, 0, 0);
        }
    }

    public int getParticipantsCountSubscribed(){
        return rankings.size();
    }
}
