import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * A class that represents a list of airports.
 * @author Halidu Mubasir
 */

public class ListOfAirports {
    /**
     * Instance variables/fields
     */

    private Map<String, Airport> listOfAirports = new HashMap<>(); // Maps all airports to their IDs
    private Airport airport; // Airport object

    /**
     * Reading the airports.csv file and creating a hashmap of airports with their IDs as keys.
     * returns a hash map
     * @return this.listOfAirports
     */
    public Map<String, Airport> readAirports(){
        try {
            File myObj = new File("airports.csv");
            Scanner myReader = new Scanner(myObj, "UTF-8");
                while (myReader.hasNextLine()) {
                  String[] data = myReader.nextLine().split(",");
                  String id = data[0];
                  String name = data[1];
                  String city = data[2];
                  String country = data[3];
                  String iata = data[4];

                  this.airport = new Airport(id, name, city, country, iata); 
                  this.listOfAirports.put(this.airport.getAirportId(), this.airport);
                } 
                myReader.close();
            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return this.listOfAirports;
    }

    /**
     * This function returns the size of the list of airports
     * 
     * @return The size of the hashmap.
     */
    public int getSize(){
        return readAirports().size();
    }

    /**
     * This function displays the list of airports
     */
    public void displayAirports(){
        for(var airport : listOfAirports.values()) {
            System.out.println(airport.getAirportCity());
        }
    }
}
