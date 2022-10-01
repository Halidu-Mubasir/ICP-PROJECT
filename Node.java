import java.util.ArrayList;

/**
 * A class that represents an airline.
 * @author Halidu Mubasir
 */
public class Node {
    /**
	 * Instance Variables/Fields
	 */
    private Airport state;
    private Node parent = null;

    /**
     * Constructor:
	 * Build and initialise objects of this class
     * 
     * Gets called when both state and parent are given when object creation
     * @param state   the current airport under consideration
     * @param parent  the node that generated the state    
     */
    public Node(Airport state, Node parent){
        this.state = state;
        this.parent = parent;
    }

   /**
    * This function returns the state of the airport
    * 
    * @return The state of the airport.
    */
    public Airport getState(){
        return this.state;
    }

    /**
     * This function returns the parent of the current node
     * 
     * @return The parent node of the current node.
     */
    public Node getParent(){
        return this.parent;
    }

    /**
     * Constructor:
	 * Build and initialise objects of this class
     * This takes in an airport object and sets the state of the node to the
     *  airport object.
     * @param state
     */
    public Node(Airport state){
        this.state = state;
    }

    /**
     * This function returns an ArrayList of Strings that represents the sequence of states that lead
     * to the current state
     * 
     * @return The solution path is being returned.
     */
    public ArrayList<String> solutionPath(){
        ArrayList<String> states_sequence = new ArrayList<>();
        states_sequence.add(this.state.getAirportName());
        var current_state = this.parent;
        while (current_state != null){
            states_sequence.add(0,current_state.state.getAirportName());
            current_state = current_state.parent;
        }
        return states_sequence;
    }

}
