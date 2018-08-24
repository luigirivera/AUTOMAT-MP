package automat_new;
import java.util.ArrayList;

public class State {
    private ArrayList<Transition> transitionsList;
    private String name;
    private StateType stateType;

    public State(String name, StateType stateType){
        this.name = name;
        this.stateType = stateType;
        transitionsList = new ArrayList<>();

    }

    public ArrayList<Transition> getTransitionsList(){
        return transitionsList;
    }

    public String getName(){
        return name;
    }

    public String getStateType(){
        return stateType.toString();
    }

    public void addTransition(Transition transition){
        transitionsList.add(transition);
    }
}
