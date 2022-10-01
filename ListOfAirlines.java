import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * A class that represents list of airlines.
 * @author Halidu Mubasir
 */

public class ListOfAirlines{
    /**
	 * Instance Variables/Fields
	 */

    private Map<String, Airline> listOfAirlines = new HashMap<>(); // Hashmap to contain the list of all airline with their IDs as keys
    private Airline airline; // Private airline object


    /**
     * Reading the airlines.csv file and creating a hashmap of airlines with their IDs as keys.
     * returns a hash map
     * @return this.listOfAirlines
     */
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

    /**
     * This function returns the size of the list of airlines
     * 
     * @return The size of the hashmap
     */
    public int getSize(){
        return readAirlines().size();
    }

    /**
     * This function displays the list of airlines
     */
    public void displayairlines(){
        for(var airline : listOfAirlines.values()) {
            System.out.println(airline.getId());
        }
    }

}