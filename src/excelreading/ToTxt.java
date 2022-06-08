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
 * @author brpic4370
 */
public class ToTxt{
    
    public File file;
    
    public ToTxt() throws IOException{
        file = new File("temp.txt");
    }
    public void writeToFile(int x){
        try{
            FileWriter myWriter = new FileWriter("temp.txt");
            myWriter.write(2);
            myWriter.close();
            System.out.println("pp");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public int readFromFile() throws FileNotFoundException{
        File myObj = new File("temp.txt");
        Scanner scan = new Scanner(myObj);
        int data = scan.nextInt();
        scan.close();
        return data;
    }
}
