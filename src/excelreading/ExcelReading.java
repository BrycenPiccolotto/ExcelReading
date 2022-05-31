/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brpic4370
 */
public class ExcelReading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scan =  new Scanner(System.in);//initialises scanner
        System.out.println("Please enter the file's location (Go to the file's location, click on its properties and copy and paste the file location)");
        String il = scan.nextLine();//Scan's the file location
        System.out.println("Please enter the name of the file (Please include \".xlsx\" at the end of your name");
        String fn = scan.nextLine();//Scan's the file name
        System.out.println("How many companies did you enter?");
        int aoc = scan.nextInt();//Scan's the ammount of companies the user enters
        
        
        String[] ioc = new String[aoc];//String array that gathers the different industry of each company, who's size is the ammount of companies the user entered in the previous line
        String[] pp = new String[aoc];//String array that gathers weither the company is public or private for each company, who's size is the ammount of companies the user entered in the previous line
        Scanner scan1 = new Scanner(System.in);//New scanner to stop overloading the previous scanner
        String x = "";//checker/temp string for industry
        String y = "";//checker/temp string for private or public 
        
        
        for(int i = 0; i<=aoc-1; i++){
            System.out.println("Which industry is the company in row " + (i+1) + " in?");
            x = scan1.nextLine();//scans to ask which industry the companies are in
            while(!x.equalsIgnoreCase("automotive")&&!x.equalsIgnoreCase("service")&&!x.equalsIgnoreCase("manufacturing")&&!x.equalsIgnoreCase("technology")&&!x.equalsIgnoreCase("food service")){//checks for invalid inputs
                System.out.println("Invalid input");
                System.out.println("Which industry is the company in row " + (i+1) + " in?");
                x = scan1.nextLine();
            }
            ioc[i] = x;//sets the industry to the industry array
            
            System.out.println("Is this company public?(y/n)");
            y = scan1.nextLine();//scans to ask weither or not the company is public or private
            while(!y.equalsIgnoreCase("y")&&!y.equalsIgnoreCase("x")){
                System.out.println("Invalid input");
                System.out.println("Is this company public?(y/n)");
                y = scan1.nextLine();
            }
            pp[i] = y;//sets the private or public descision to the array
        }
        System.out.println("\n");
        //String location = (il + "\\" + fn);//creates the location string off of the two previous inputs
        String location = "Y:\\Documents\\NetBeansProjects\\Eccel Reading_Txt Writing (FINAL)\\Big epic testing tester page.xlsx";
        
        ExcelFileReading file = new ExcelFileReading();//class for excel file reading
        ArrayList <double[]> data = new ArrayList <double[]>();//array list for array transportation
        int row = 1;//row counter for iterating through
        int industryCheck = 0;//used to find the position of the current company in the industry array
        int ppCheck = 0;//used to find the position of the current company in the private or public array
        int counter = 1;//used to count the ammount of companies if the user wants to add less companies than are on the sheet
        
        double[] arra = new double[7];//Automotive
        double[] arrs = new double[7];//Service Based
        double[] arrm = new double[7];//Manufacturing
        double[] arrt = new double[7];//Technology
        double[] arrf = new double[7];//Food Services
        
        //double[] arrag = new double[3];//Agricultural (MAYBE)
        
        //Change arr length based on how many cells
        DataGathering file1 = new DataGathering();
        String temp;
        temp = file.specificCellString(location, row, 0);
        try{
            while(!temp.equals("")&&counter!=aoc){
                if(ioc[industryCheck].equalsIgnoreCase("automotive")){
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataAuto(location, row, arra));
                    row++;
                    industryCheck++;
                    temp = file.specificCellString(location, row, 0);
                }else if(ioc[industryCheck].equalsIgnoreCase("service")){
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataService(location, row, arrs));
                    row++;
                    industryCheck++;
                    temp = file.specificCellString(location, row, 0);
                }else if(ioc[industryCheck].equalsIgnoreCase("manufacturing")){
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataManufacturing(location, row, arrm));
                    row++;
                    industryCheck++;
                    temp = file.specificCellString(location, row, 0);
                }else if(ioc[industryCheck].equalsIgnoreCase("technology")){
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataTechnology(location, row, arrt));
                    row++;
                    industryCheck++;
                    temp = file.specificCellString(location, row, 0);
                }else if(ioc[industryCheck].equalsIgnoreCase("food service")){
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataFood(location, row, arrf));
                    row++;
                    industryCheck++;
                    temp = file.specificCellString(location, row, 0);
                }
                counter++;
            }
        }catch(NullPointerException e){
            System.out.println(":)");
        }
        System.out.println("");
        System.out.println("Finished Processing Data");
        //send arrayList to be put onto a spreadsheet
        System.out.println("Data is now on SystemData.xlsx");
        System.out.println("ty homie <<kisses you>>");
    }
}
