package automat_new;

import java.util.ArrayList;

public class Main {
    public static void main(String ... args){
        Automaton a = new Automaton();
        DFS d = new DFS(a);
        ArrayList<Transition> temp = new ArrayList<>();
        for(int i = 0; i < d.getSolutionTransitions().size(); i++) {
        	temp.addAll(d.getSolutionTransitions().get(i)); 
            for(Transition t : temp) {
            	System.out.print(t.getName() + "-> ");
            }
            System.out.println();
            temp.clear();
        }
        
    }
}
