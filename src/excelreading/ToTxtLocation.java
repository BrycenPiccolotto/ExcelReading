/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.NullPointerException;

/**
 *
 * @author brycen
 */
public class ToTxtLocation {
    public File file;
    /**
     * 
     * @throws IOException 
     */
    public ToTxtLocation() throws IOException{ //Creates location if file locations are already known 
        file = new File("location.txt");
    }
    /**
     * 
     * @param location//location of file (Ex: C:Download)
     * @throws IOException 
     */
    public ToTxtLocation(String location) throws IOException{ //Creates file location on first run of program
        file = new File(location + "\\location.txt");
    }
    /**
     * 
     * @param x//The location of the data entry sheet
     * @param y//The location of temp.txt
     * @param z //The location of SystemData.xlsx
     */
    public void writeToFile(String x, String y, String z){ //writes all of the other file locations to a text file
        try {
            try(FileWriter myWriter = new FileWriter("location.txt")) {
                myWriter.write(x + "\n" + y + "\n" + z + "\n");
            } 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NullPointerException q){
            q.printStackTrace();
        }
    }
    /**
     * 
     * @return returns string of file's location or no to indicate an error to poll the user on their files location
     */
    public String readFromFileLocationOfDataEntrySheet(){ //Reads the location of the data entry sheet
        try{
            File myObj = new File("location.txt");
            Scanner scan = new Scanner(myObj);
            String data = scan.nextLine();
            scan.close();
            return data;
        }catch(NullPointerException e){//if the file's data is corrupt
            return "no";
        }catch(FileNotFoundException q){//if the file is not present on the computer
            return "no";
        }
    }
    /**
     * 
     * @return string of file's location
     * @throws FileNotFoundException 
     */
    public String readFromFileLocationOfTemp() throws FileNotFoundException{ //Reads the location of the temp text file with the row count
        File myObj = new File("location.txt");
        Scanner scan = new Scanner(myObj);
        String data1 = scan.nextLine();
        String data = scan.nextLine();
        scan.close();
        return data;
    }
    /**
     * 
     * @return string of file's location
     * @throws FileNotFoundException 
     */
    public String readFromFileLocationOfSystemData() throws FileNotFoundException{ //Reads the location of the systemdata sheet
        File myObj = new File("location.txt");
        Scanner scan = new Scanner(myObj);
        String data2 = scan.nextLine();
        String data1 = scan.nextLine();
        String data = scan.nextLine();
        scan.close();
        return data;
    }
}
