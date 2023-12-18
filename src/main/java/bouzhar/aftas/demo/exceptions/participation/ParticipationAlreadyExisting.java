package bouzhar.aftas.demo.exceptions.participation;

public class ParticipationAlreadyExisting extends ParticipationException{
    public ParticipationAlreadyExisting() {
        super("participation Already existing");
    }

    public ParticipationAlreadyExisting(String message) {
        super(message);
    }
}
