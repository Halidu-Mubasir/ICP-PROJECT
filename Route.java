public class Route {
    
    private String airline;
    private String airlineID;
    private String sourceAirport;
    private String sourceAirportId;
    private String destinationAirport;
    private String destinationAirportId;
    private int stops;


    /**
     * 
     * @param airline
     * @param airlineID
     * @param sourceAirport
     * @param sourceAirportId
     * @param destinationAirport
     * @param destinationAirportId
     * @param stops
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

    public String getAirlineID(){
        return airlineID;
    }

    public String getSourceAirportId(){
        return sourceAirportId;
    }

    public String getdestinationAirportID(){
        return destinationAirportId;
    }

    public int getStops(){
        return stops;
    }

    public String getAirline(){
        return airline;
    }

    public String getSourceAirport(){
        return sourceAirport;
    }

    public String getdestinationAirport(){
        return destinationAirport;
    }
}
