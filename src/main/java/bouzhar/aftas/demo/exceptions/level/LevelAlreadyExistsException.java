package bouzhar.aftas.demo.exceptions.level;

public class LevelAlreadyExistsException extends LevelException{
    public LevelAlreadyExistsException() {
        super("this Level already exists");
    }
}
