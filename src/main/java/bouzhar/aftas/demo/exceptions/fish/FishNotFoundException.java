package bouzhar.aftas.demo.exceptions.fish;

public class FishNotFoundException extends FishException{
    public FishNotFoundException(String name) {
        super("Fish: '"+name+"' not found");
    }
    public FishNotFoundException() {
        super("Fish not found");
    }
}
