import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that represents the problem (How to find the route).
 * @author Halidu Mubasir
 */
public class FindRoute{
    /**
	 * Instance Variables/Fields
	 */
    Queue<Route> queue = new LinkedList<Route>();
    private Airport airport1;
    private Route rout;
    private ListOfAirports airports = new ListOfAirports();
    private ListOfRoutes routes = new ListOfRoutes();
    private String init_city;
    private String final_city;


    /**
     * 
     * @param init_city the city where the journey starts
     * @param final_city the city the journey ends
     */
    public FindRoute(String init_city, String final_city){
        this.init_city = init_city;
        this.final_city = final_city;
    }

   /**
    * It takes an airport as an argument and returns a list of all the airports that can be reached
    * from that airport
    * 
    * @param airport the current airport
    * @return The method returns an ArrayList of Airport objects.
    */
    public ArrayList<Airport> findNextAirports(Airport airport){

       // Finding the next airport that can be reached from the current airport.
        ArrayList<Airport> succStates = new ArrayList<>();
        for (var route : routes.readroutes().values()){
            if (route.getSourceAirportId().equals(airport.getAirportId())){
                String destination_airport_id = route.getdestinationAirportID();
                var desAirport = this.airports.readAirports().get(destination_airport_id);
                if (desAirport != null)
                    succStates.add(desAirport);
            }       
        }
        return succStates;
    }

   /**
    * It takes the initial city from the user and finds the corresponding airport object from the list
    * of airports
    * 
    * @return The airport object that matches the init_city.
    */
    public Airport getInitAirport(){
        for (var air : airports.readAirports().values()){
            if (air.getAirportCity().equals(this.init_city))
                this.airport1 = air;
        }
        return this.airport1;
    }
    
/**
 * It checks if the airport is the final city, if it is, it checks if there is a route from the airport
 * to the final city, if there is, it prints the route
 * 
 * @param airport the current airport
 * @return Boolean
 */
    public Boolean goalTest(Airport airport){
        boolean dex = false;
        for (var air : airports.readAirports().values()){
            if (air.getAirportCity().equals(this.final_city)){
                for (var route : routes.readroutes().values()){
                    if (route.getSourceAirportId().equals(airport.getAirportId()) && 
                    route.getdestinationAirportID().equals(air.getAirportId())){
                        this.rout = route;
                        String source_airport_id = this.rout.getSourceAirportId();
                        String destination_airport_id = this.rout.getdestinationAirportID();
                        var sorAirport = this.airports.readAirports().get(source_airport_id);

                        var desAirport = this.airports.readAirports().get(destination_airport_id);
                        System.out.println(route.getAirline()+" " +sorAirport.getAirportIATA()+" " +desAirport.getAirportIATA());
                        dex = true;
                        break;
                    }
                }            
            }
        }
        return dex;
    }
}