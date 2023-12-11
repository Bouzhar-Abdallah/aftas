package bouzhar.aftas.demo.dto.competition;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionReq {
    @Pattern(regexp = "^[a-zA-Z]{3}-\\d{2}-\\d{2}-\\d{2}$", message = "Code must be in the format ccc-dd-dd-dd")
    private String code;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm")

    private LocalTime endTime;

    private Integer numberOfParticipants;

    @NotBlank(message = "shouldn't be blank")
    private String location;

    private Float amount;
}
