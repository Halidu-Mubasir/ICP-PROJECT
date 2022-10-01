import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ListOfAirlines{

    private Map<String, Airline> listOfAirlines = new HashMap<>();
    private Airline airline;

    public Map<String, Airline> readAirlines(){
        try {
            File myObj = new File("airlines.csv");
            Scanner myReader = new Scanner(myObj, "UTF-8");
                while (myReader.hasNextLine()) {
                  String[] data = myReader.nextLine().split(",");
                  String id = data[0];
                  String name = data[1];
                  String alias = data[2];
                  String iata = data[3];

                  this.airline = new Airline(id, name, alias, iata); 
                  this.listOfAirlines.put(this.airline.getId(), this.airline);
                } 
                myReader.close();
            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return this.listOfAirlines;
    }

    public int getSize(){
        return readAirlines().size();
    }

    public void displayairlines(){
        for(var airline : listOfAirlines.values()) {
            System.out.println(airline.getId());
        }
    }

}