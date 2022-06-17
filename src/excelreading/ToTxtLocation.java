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
 * @author brpic4370
 */
public class ToTxtLocation {
    public File file;
    public ToTxtLocation() throws IOException{
        file = new File("location.txt");
    }
    public ToTxtLocation(String location) throws IOException{
        file = new File(location + "\\location.txt");
    }
    public void writeToFile(String x/*First Data Set*/, String y/*Second Data Set*/, String z){
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
    public String readFromFileLocationOfDataEntrySheet(){
        try{
            File myObj = new File("location.txt");
            Scanner scan = new Scanner(myObj);
            String data = scan.nextLine();
            scan.close();
            return data;
        }catch(NullPointerException e){
            return "no";
        }catch(FileNotFoundException q){
            return "no";
        }
    }
    public String readFromFileLocationOfTemp() throws FileNotFoundException{
        File myObj = new File("location.txt");
        Scanner scan = new Scanner(myObj);
        String data1 = scan.nextLine();
        String data = scan.nextLine();
        scan.close();
        return data;
    }
    public String readFromFileLocationOfSystemData() throws FileNotFoundException{
        File myObj = new File("location.txt");
        Scanner scan = new Scanner(myObj);
        String data2 = scan.nextLine();
        String data1 = scan.nextLine();
        String data = scan.nextLine();
        scan.close();
        return data;
    }
}
