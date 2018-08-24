package automat_new;
public enum StateType {
    INITIAL, FINAL, TRANSITION;

    public String toString(){
        switch (this){
            case INITIAL: return "initial";
            case FINAL: return "final";
            case TRANSITION: return "transition";
            default: return "unknown";
        }
    }
}
