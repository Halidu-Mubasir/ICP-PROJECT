import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ManageTextFile {

    public void createFile(String filename){
        try {
            File fileObject = new File(filename);
            if (fileObject.createNewFile())
                System.out.println("File created "+ fileObject.getName());
            System.out.println("File already exists");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeToFile(String pathname){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter start city and country: ");
            String startCity = scanner.nextLine();

            String destinationCity = scanner.nextLine();
            FileWriter writerObject = new FileWriter(pathname);
            writerObject.write(startCity + "\n");
            writerObject.write(destinationCity);
            writerObject.close();
            scanner.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(String pathname){
        ArrayList<String> inputInfo = new ArrayList<>();
        try {
            File readerObject = new File(pathname);
            Scanner myReader = new Scanner(readerObject);
            while (myReader.hasNextLine()){
                String[] sourceInfo = myReader.nextLine().split(" ");   
                for (var info : sourceInfo){
                    inputInfo.add(info);
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
            fnfe.printStackTrace();
        }
        return inputInfo;
    }
}
