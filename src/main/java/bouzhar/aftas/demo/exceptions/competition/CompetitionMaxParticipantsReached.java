package bouzhar.aftas.demo.exceptions.competition;

public class CompetitionMaxParticipantsReached extends CompetitionException{
    public CompetitionMaxParticipantsReached() {
        super("Competition Max reached");
    }
}
