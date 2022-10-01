public class Airline {

    private String id;
    private String name;
    private String alias;
    private String iata;

    public Airline(String id, String name, String alias, String iata){
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.iata = iata;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAlias(){
        return alias;
    }

    public String getIATA(){
        return iata;
    }
}
