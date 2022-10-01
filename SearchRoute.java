import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SearchRoute {
    public ArrayList<String> search(){
        var inputFile = new ManageTextFile();
        var infoArray = inputFile.readFile("input.txt");
        String initCity = infoArray.get(0);
        String destinationCity = infoArray.get(2);


        var find = new FindRoute(initCity, destinationCity);
        var node = new Node(find.getInitAirport());
        //System.out.println(node.state.getAirportName());
        
        if (find.goalTest(node.state)){
            System.out.println("Found the solution at first check");
            return node.solutionPath();
        }

        Queue<Node> frontier = new LinkedList<Node>();
        HashSet<Airport> explored = new HashSet<>();

        frontier.add(node);

        while (frontier.size() > 0){
            node = frontier.remove();
            System.out.println("Popped " + node.state.getAirportName());
            explored.add(node.state);
            ArrayList<Airport> successors = find.findNextAirports(node.state);
            // for (var airport : successors){
            //     System.out.println(airport.getAirportName());
            // }
            for (var i = 0; i < successors.size(); i++){
                var child = new Node(successors.get(i), node);
                if (!explored.contains(child.state) &&
                    !frontier.contains(child)){
                        if (find.goalTest(child.state)){
                            System.out.println("Found a solution");
                            return child.solutionPath();
                        }
                    frontier.add(child);
                }
            }
        }
        System.out.println("No solution found");
        return null;
    }
}
