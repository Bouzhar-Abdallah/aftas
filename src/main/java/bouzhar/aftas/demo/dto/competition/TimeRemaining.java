package bouzhar.aftas.demo.dto.competition;

import lombok.Data;

@Data
public class TimeRemaining {
    private long days;
    private long hours;
    private long minutes;
    private long seconds;

    public TimeRemaining(long days, long hours, long minutes, long seconds) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%d days, %d hours, %d minutes, %d seconds", days, hours, minutes, seconds);
    }
}
