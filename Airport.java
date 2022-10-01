

public class Airport {

    private String id;
    private String name;
    private String city;
    private String country;
    private String iata;


    /**
     * 
     * @param id
     * @param name
     * @param city
     * @param country
     * @param iata
     */
    public Airport (String id, String name, String city, 
    String country, String iata){
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata = iata;
    }
    
    public String getAirportId(){
        return id;
    }
    
    public String getAirportName(){
        return name;
    }

    public String getAirportCity(){
        return city;
    }
    
    public String getAirportCountry(){
        return country;
    }

    public String getAirportIATA(){
        return iata;
    }




}
