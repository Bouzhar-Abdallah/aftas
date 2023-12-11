package bouzhar.aftas.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
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
}
