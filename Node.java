import java.util.ArrayList;

public class Node {
    public Airport state;
    public Node parent = null;

    public Node(Airport state, Node parent){
        this.state = state;
        this.parent = parent;
    }

    public Node(Airport state){
        this.state = state;
    }

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
