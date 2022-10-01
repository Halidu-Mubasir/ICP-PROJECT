public class Main {
    public static void main(String[] args) {
        
        /* var airports = new ListOfAirports();
        System.out.println(airports.getSize()); 
        airports.displayAirports();  */

        /* var airlines = new ListOfAirlines();
        airlines.displayairlines();
        System.out.println(airlines.getSize()); */

        /* var routes = new ListOfRoutes();
        routes.displayroutes();
        System.out.println(routes.getSize()); */

        /* var route = new FindRoute();
        System.out.println(route.test("Minneapolis", "Winnipeg")); */

        var file = new ManageTextFile();
        //file.createFile("input.txt");
        file.writeToFile("input.txt");
        var search1 = new SearchRoute();
        System.out.println(search1.search());

    }
}