import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindRoute{
    
    Queue<Route> queue = new LinkedList<Route>();
    private Airport airport1;
    private Route rout;
    private ListOfAirports airports = new ListOfAirports();
    private ListOfRoutes routes = new ListOfRoutes();
    private String init_city;
    private String final_city;

    public FindRoute(String init_city, String final_city){
        this.init_city = init_city;
        this.final_city = final_city;
    }

    public ArrayList<Airport> findNextAirports(Airport airport){

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

    public Airport getInitAirport(){
        for (var air : airports.readAirports().values()){
            if (air.getAirportCity().equals(this.init_city))
                this.airport1 = air;
        }
        return this.airport1;
    }

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