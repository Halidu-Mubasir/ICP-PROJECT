import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that represents a search class that looks for the solution.
 * @author Halidu Mubasir
 */
public class SearchRoute {

    /**
     * It takes in a text file with the initial and destination airports, and returns an ArrayList of
     * Strings that contains the path from the initial airport to the destination airport
     * 
     * @return The method returns an ArrayList of Strings (solution path) which contains the airports along the route.
     */
    
    public ArrayList<String> search(){
        var inputFile = new ManageTextFile(); // Instantiates a ManaheTextFile object
        var infoArray = inputFile.readFile("input.txt"); // Reads a file called input.txt and returns an array of the cities and countries
        String initCity = infoArray.get(0);
        String destinationCity = infoArray.get(2);
        String initialCountry = infoArray.get(1);
        String destinationCountry = infoArray.get(3);

        var find = new FindRoute(initCity,initialCountry, destinationCity, destinationCountry); // Instantiates the findRoute class which represents the problem
        var node = new Node(find.getInitAirport()); // Creates a node object
        
       

        // Checking if the initial airport is the destination airport. If it is, then it returns the
        // solution path.
        if (find.goalTest(node.getState())){
            System.out.println("Found the solution at first check");
            return node.solutionPath();
        }

        Queue<Node> frontier = new LinkedList<Node>(); // A queue to do a breadth first search. Stores the nodes(airports) to be explored
        HashSet<Airport> explored = new HashSet<>(); // Hash set to store the already explored nodes (airports)
        
        frontier.add(node); // Add the first node created, if its not the final destination

        // Checking if the frontier is empty. If it is, then it returns null. If it is not, then it
        // removes the first node in the frontier, adds it to the explored set, and finds the
        // successors of the node. It then checks if the successors are in the explored set or the
        // frontier. If they are not, then it checks if the successor is the goal state (airport). If it is, then
        // it returns the solution path. If it is not, then it adds the successor to the frontier.
        while (frontier.size() > 0){
            node = frontier.remove();
            System.out.println("Popped " + node.getState().getAirportName());
            explored.add(node.getState());
            ArrayList<Airport> successors = find.findNextAirports(node.getState());

            
            for (var i = 0; i < successors.size(); i++){
                var child = new Node(successors.get(i), node);
                if (!explored.contains(child.getState()) &&
                    !frontier.contains(child)){
                        if (find.goalTest(child.getState())){
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
