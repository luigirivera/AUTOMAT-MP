package automat_new;
import java.util.ArrayList;

public class Automaton {
    private ArrayList<State> stateList;

    public Automaton() {
        stateList = new ArrayList<State>();
        init();
    }

    private void init() {
        //Create all the states
        State q0 = new State("q0", StateType.INITIAL);

        State q1 = new State("q1", StateType.TRANSITION);
        State q2 = new State("q2", StateType.TRANSITION);
        State q3 = new State( "q3", StateType.TRANSITION);
        State q4 = new State( "q4", StateType.TRANSITION);
        State q5 = new State( "q5", StateType.TRANSITION);
        State q6 = new State( "q6", StateType.TRANSITION);
        State q7 = new State( "q7", StateType.TRANSITION);
        State q8 = new State( "q8", StateType.TRANSITION);
        State q9 = new State( "q9", StateType.TRANSITION);
        State q10 = new State( "q10", StateType.TRANSITION);
        State q11 = new State( "q11", StateType.TRANSITION);
        State q12 = new State( "q12", StateType.TRANSITION);
        State q13 = new State( "q13", StateType.TRANSITION);
        State q14 = new State( "q14", StateType.TRANSITION);
        State q15 = new State( "q15", StateType.TRANSITION);
        State q16 = new State( "q16", StateType.TRANSITION);
        
        State q17 = new State( "q17", StateType.FINAL);

        //Add the states to the list of states
        stateList.add(q0);
        stateList.add(q1);
        stateList.add(q2);
        stateList.add(q3);
        stateList.add(q4);
        stateList.add(q5);
        stateList.add(q6);
        stateList.add(q7);
        stateList.add(q8);
        stateList.add(q9);
        stateList.add(q10);
        stateList.add(q11);
        stateList.add(q12);
        stateList.add(q13);
        stateList.add(q14);
        stateList.add(q15);
        stateList.add(q16);
        stateList.add(q17);

        //Create the transitions then add each transition to the corresponding state
//        q0.getTransitionsList().add(new Transition(Planet.EARTH))
        q0.addTransition(new Transition("SLC", q1));

        q1.addTransition(new Transition("SLC", q0));
        q1.addTransition(new Transition("SL", q2));
        q1.addTransition(new Transition("SC", q3));

        q2.addTransition(new Transition("SL", q1));
        q2.addTransition(new Transition("SHL", q4));
        q2.addTransition(new Transition("SHH", q6));
        q2.addTransition(new Transition("SLG", q14));

        q3.addTransition(new Transition("SC", q1));
        q3.addTransition(new Transition("SHC", q4));
        q3.addTransition(new Transition("SCG", q14));

        q4.addTransition(new Transition("SHL", q2));
        q4.addTransition(new Transition("SHC", q3));
        q4.addTransition(new Transition("SLC", q5));

        q5.addTransition(new Transition("SLC", q4));
        q5.addTransition(new Transition("SHC", q6));

        q6.addTransition(new Transition("SHC", q5));
        q6.addTransition(new Transition("SC", q7));
        q6.addTransition(new Transition("SHH", q2));

        q7.addTransition(new Transition("SC", q6));
        q7.addTransition(new Transition("SLC", q8));
        q7.addTransition(new Transition("SLG", q9));
        q7.addTransition(new Transition("SGC", q10));

        q8.addTransition(new Transition("SLC", q10));

        q9.addTransition(new Transition("SLG", q7));
        q9.addTransition(new Transition("SHL", q11));
        q9.addTransition(new Transition("SHH", q13));
        q9.addTransition(new Transition("SL", q16));

        q10.addTransition(new Transition("SGC", q7));
        q10.addTransition(new Transition("SHC", q11));
        q10.addTransition(new Transition("SC", q16));

        q11.addTransition(new Transition("SHL", q9));
        q11.addTransition(new Transition("SHC", q10));
        q11.addTransition(new Transition("SLC", q12));

        q12.addTransition(new Transition("SLC", q11));
        q12.addTransition(new Transition("SHC", q13));

        q13.addTransition(new Transition("SHH", q9));
        q13.addTransition(new Transition("SHC", q12));
        q13.addTransition(new Transition("SC", q14));

        q14.addTransition(new Transition("SLG", q2));
        q14.addTransition(new Transition("SCG", q3));
        q14.addTransition(new Transition("SC", q13));
        q14.addTransition(new Transition("SLC", q15));

        q15.addTransition(new Transition("SLC", q14));

        q16.addTransition(new Transition("SC", q10));
        q16.addTransition(new Transition("SL", q9));
        q16.addTransition(new Transition("SLC", q17));

    }
}
