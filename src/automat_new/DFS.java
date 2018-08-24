package automat_new;

import java.util.ArrayList;

public class DFS {
	
	private Automaton automaton;
	
	private ArrayList<ArrayList<State>> solutions = new ArrayList<>();
	private ArrayList<ArrayList<Transition>> solutionTransitions = new ArrayList<>();
	State finalState = automaton.getStates().get(17);
	
	
	public DFS (Automaton automaton) {
		this.automaton = automaton;
		State startState = automaton.getStates().get(0);
		
		ArrayList<State> checkedStates = new ArrayList<>();
		checkedStates.add(startState);
		ArrayList<Transition> transitions = new ArrayList();
		
		search(startState, checkedStates, transitions);
		
	}


	private void search(State curState, ArrayList<State> checkedStates, ArrayList<Transition> transitions) {
		// TODO Auto-generated method stub
		if(curState != finalState) {
			for(Transition t : curState.getTransitionsList()) {
				State destState = t.getDestinationState();
				if(!checkedStates.contains(destState)) {
					checkedStates.add(destState);
					transitions.add(t);
					search(destState, checkedStates, transitions);
					checkedStates.remove(checkedStates.size()-1);
					transitions.remove(transitions.size()-1);
				}
			}
		}else {
			ArrayList<State> tempStateList = new ArrayList();
			ArrayList<Transition> tempTransList = new ArrayList();
			tempStateList.addAll(checkedStates);
			tempTransList.addAll(transitions);
			solutions.add(tempStateList);
			solutionTransitions.add(tempTransList);
		}
		
	}
}
