import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that represents the problem (How to find the route).
 * @author Halidu Mubasir
 */
public class RouteProblem{
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
    private String init_country;
    private String final_country;


    /**
     * Constructor:
	 * Build and initialise objects of this class
     * 
     * @param init_city the city where the journey starts
     * @param init_country the country where the journey starts
     * @param final_city the city the journey ends
     * @param final_country the country where the journey ends
     */
    public RouteProblem(String init_city,String init_country,  String final_city, String final_country){
        this.init_city = init_city;
        this.final_city = final_city;
        this.init_country = init_country;
        this.final_country = final_country;
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
                if (desAirport != null){
                    succStates.add(desAirport);
                }
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
            if (air.getAirportCity().equals(this.init_city) && air.getAirportCountry().equals(this.init_country))
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
        boolean isGoal = false;
        for (var air : airports.readAirports().values()){
            if (air.getAirportCity().equals(this.final_city) && air.getAirportCountry().equals(this.final_country)){
                for (var route : routes.readroutes().values()){
                    if (route.getSourceAirportId().equals(airport.getAirportId()) && 
                    route.getdestinationAirportID().equals(air.getAirportId())){
                        this.rout = route;
            
                        String destination_airport_id = this.rout.getdestinationAirportID();
                        var desAirport = this.airports.readAirports().get(destination_airport_id);
                        System.out.println("The destination airport is " +desAirport.getAirportName());
                        isGoal = true;
                        break;
                    }
                }            
            }
        }
        return isGoal;
    }
}