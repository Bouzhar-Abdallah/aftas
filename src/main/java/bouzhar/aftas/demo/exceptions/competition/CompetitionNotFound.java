package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionNotFound extends CompetitionException{
    public CompetitionNotFound() {
        super("Competition not found");
    }
}
