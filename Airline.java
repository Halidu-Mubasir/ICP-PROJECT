/**
 * A class that represents an airline.
 * @author Halidu Mubasir
 */
public class Airline {

    /**
     * Instance variables/fields
     */
    private String id;
    private String name;
    private String alias;
    private String iata;

    /**
     * Constructor:
	 * Build and initialise objects of this class
     * 
     * @param id   the id of the airline
     * @param name the name of the airline
     * @param alias the alias (what it is commonly known as) of the airline
     * @param iata 	2-letter IATA code, if available
     */
    public Airline(String id, String name, String alias, String iata){
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.iata = iata;
    }

    /**
     * returns the id of the airline
     * 
     * @return this.id 
     */
    public String getId(){
        return this.id;
    }


    /**
     * returns the name of the airline
     * @return this.name
     */
    public String getName(){
        return this.name;
    }


    /**
     * returns the alias 
     * @return this.alias
     */
    public String getAlias(){
        return this.alias;
    }


    /**
     * returns the iata code
     * @return this.iata
     */
    public String getIATA(){
        return this.iata;
    }
}
