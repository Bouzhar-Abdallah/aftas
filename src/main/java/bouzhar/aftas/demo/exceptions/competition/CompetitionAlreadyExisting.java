package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionAlreadyExisting extends CompetitionException{
    public CompetitionAlreadyExisting() {
        super("Competition already existing");
    }
}
