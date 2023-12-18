package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionNotFound extends CompetitionException{
    public CompetitionNotFound(String code) {
        super("Competition ".concat(code).concat(" not found"));
    }
}
