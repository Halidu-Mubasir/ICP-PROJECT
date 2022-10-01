import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ListOfAirports {
    
    private Map<String, Airport> listOfAirports = new HashMap<>();
    private Airport airport;

    /* public void addAirport(){
        airport = readAirports();
        listOfAirports.put(airport.getAirportId(), airport);
    } */

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

    public int getSize(){
        return readAirports().size();
    }

    public void displayAirports(){
        for(var airport : listOfAirports.values()) {
            System.out.println(airport.getAirportCity());
        }
    }
}
