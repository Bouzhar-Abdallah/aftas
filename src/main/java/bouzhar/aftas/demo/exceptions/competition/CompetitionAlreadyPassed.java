package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionAlreadyPassed extends CompetitionException{
    public CompetitionAlreadyPassed() {
        super("Competition already passed : you can't add participants");
    }
}
