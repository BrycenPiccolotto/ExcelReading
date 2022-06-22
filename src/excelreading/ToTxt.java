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

/**
 *
 * @author brycen
 */
public class ToTxt{
    
    public File file;
    /**
     * 
     * @throws IOException 
     */
    public ToTxt() throws IOException{
        file = new File("temp.txt");
    }
    /**
     * 
     * @param location
     * @param x 
     */
    public void writeToFile(String location, int x){
        try{
            FileWriter myWriter = new FileWriter(location);
            myWriter.write(x + "\n");
            myWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param location
     * @return
     * @throws FileNotFoundException 
     */
    public int readFromFile(String location) throws FileNotFoundException{
        File myObj = new File(location);
        Scanner scan = new Scanner(myObj);
        int data = scan.nextInt();
        scan.close();
        return data;
    }
}
