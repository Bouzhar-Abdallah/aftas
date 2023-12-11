package bouzhar.aftas.demo.exceptions.member;

public class MemberNotFoundException extends MemberException {
    public MemberNotFoundException() {
        super("Member not found");
    }

    public MemberNotFoundException(String message) {
        super(message);
    }
}
