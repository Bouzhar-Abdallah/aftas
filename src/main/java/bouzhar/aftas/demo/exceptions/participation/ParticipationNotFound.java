package bouzhar.aftas.demo.exceptions.participation;

public class ParticipationNotFound extends ParticipationException{
    public ParticipationNotFound() {
        super("participation not found");
    }

    public ParticipationNotFound(String message) {
        super(message);
    }
}
