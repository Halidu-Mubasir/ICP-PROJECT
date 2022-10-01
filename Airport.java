/**
 * A class that represents an airport.
 * @author Halidu Mubasir
 */

public class Airport {
    /**
	 * Instance Variables/Fields
	 */

    private String id;
    private String name;
    private String city;
    private String country;
    private String iata;


    /**
     * Constructor:
	 * Build and initialise objects of this class
     * 
     * @param id        the id of the airport
     * @param name      the name of the airport
     * @param city      the city the airport is located
     * @param country   the country of the airport
     * @param iata      the IATA code of the airport
     */
    public Airport (String id, String name, String city, 
    String country, String iata){
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata = iata;
    }
    
    /**
     *  returns the id
     * @return this.id
     */
    public String getAirportId(){
        return this.id;
    }
    

    /**
     * returns the name
     * @return this.name
     */
    public String getAirportName(){
        return this.name;
    }


    /**
     * returns the city of the airport
     * @return this.city
     */
    public String getAirportCity(){
        return this.city;
    }
    

    /**
     * returns the country of the airport
     * @return this.country
     */
    public String getAirportCountry(){
        return this.country;
    }


    /**
     * returns IATA code
     * @return this.iata
     */
    public String getAirportIATA(){
        return this.iata;
    }
}
