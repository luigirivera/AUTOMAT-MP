package automat_new;
public class Transition {
    private String name;
    private State destinationState;

    public Transition(String name, State destinationState){
        this.name = name;
        this.destinationState = destinationState;
    }

    public String getName() {
        return name;
    }

    public State getDestinationState() {
        return destinationState;
    }
}
