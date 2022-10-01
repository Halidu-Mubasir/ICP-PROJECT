/**
 * A class that represents a route.
 * @author Halidu Mubasir
 */

public class Route {
    /**
     * Instance variables/fields
     */

    private String airline;
    private String airlineID;
    private String sourceAirport;
    private String sourceAirportId;
    private String destinationAirport;
    private String destinationAirportId;
    private int stops;


    /**
     *  * Constructor:
	 * Build and initialise objects of this class
     * 
     * @param airline               the airline IATA code
     * @param airlineID             the airline id for the route
     * @param sourceAirport         the source airport of the route
     * @param sourceAirportId       the source airport id for the route
     * @param destinationAirport    the destination airport for the route
     * @param destinationAirportId  the destination airport id for the route
     * @param stops                 the number of stops along the route
     */
    public Route(String airline, String airlineID, String sourceAirport, 
                String sourceAirportId, String destinationAirport, 
                String destinationAirportId, int stops){
                    this.airline = airline;
                    this.airlineID = airlineID;
                    this.sourceAirport = sourceAirport;
                    this.sourceAirportId = sourceAirportId;
                    this.destinationAirport = destinationAirport;
                    this.destinationAirportId = destinationAirportId;
                    this.stops = stops;
    }


    /**
     * returns airline id
     * @return this.airlineID
     */
    public String getAirlineID(){
        return this.airlineID;
    }


    /**
     * returns source airport id
     * @return this.sourceAirportId
     */
    public String getSourceAirportId(){
        return this.sourceAirportId;
    }

    /**
     * returns destination airport id
     * @return this.destinationAirportId
     */
    public String getdestinationAirportID(){
        return this.destinationAirportId;
    }


    /**
     * returns number of stops
     * @return this.stops
     */
    public int getStops(){
        return this.stops;
    }


    /**
     * returns airline IATA
     * @return this.airline
     */
    public String getAirline(){
        return this.airline;
    }

    /**
     * returns source airport
     * @return this.sourceAirport
     */
    public String getSourceAirport(){
        return this.sourceAirport;
    }


    /**
     * returns destination airport
     * @return this.destiantionAirport
     */
    public String getdestinationAirport(){
        return this.destinationAirport;
    }
}
