package bouzhar.aftas.demo.entitie;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
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
