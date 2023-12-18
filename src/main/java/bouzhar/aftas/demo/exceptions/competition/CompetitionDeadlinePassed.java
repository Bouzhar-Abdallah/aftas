package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionDeadlinePassed extends CompetitionException{
    public CompetitionDeadlinePassed() {
        super("Deadline of this competition passed");
    }
}
