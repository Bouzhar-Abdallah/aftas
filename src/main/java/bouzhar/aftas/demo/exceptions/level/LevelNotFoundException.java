package bouzhar.aftas.demo.exceptions.level;

public class LevelNotFoundException extends LevelException{
    public LevelNotFoundException() {
        super("Level not found");
    }
}
