import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ListOfRoutes {
    
    private Map<String, Route> listOfRoutes = new HashMap<>();
    private Route route;

    public Map<String, Route> readroutes(){
        try {
            File myObj = new File("routes.csv");
            Scanner myReader = new Scanner(myObj, "UTF-8");
                while (myReader.hasNextLine()) {
                  String[] data = myReader.nextLine().split(",");

                  String airline = data[0];
                  String airlineID = data[1];
                  String sourceAirport = data[2];
                  String sourceAirportId = data[3];
                  String destinationAirport = data[4];
                  String destinationAirportId = data[5];
                  int stops = Integer.parseInt(data[7]);

                  String uniqueID = airline + sourceAirport + destinationAirport;

                  this.route = new Route(airline, airlineID, sourceAirport, sourceAirportId,
                                         destinationAirport, destinationAirportId, stops); 
                  this.listOfRoutes.put(uniqueID, this.route);
                } 
                myReader.close();
            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return this.listOfRoutes;
    }

    public int getSize(){
        return readroutes().size();
    }

    public void displayroutes(){
        for(var route : listOfRoutes.values()) {
            System.out.println(route.getAirline());
        }
    }
}
