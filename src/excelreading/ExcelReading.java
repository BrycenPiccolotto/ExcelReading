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
        
        String[] industry = new String[aoc];//String array that gathers the different industry of each company, who's size is the ammount of companies the user entered in the previous line
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
            industry[i] = x;//sets the industry to the industry array
            
            System.out.println("Is this company public?(y/n)");
            y = scan1.nextLine();//scans to ask weither or not the company is public or private
            while(!y.equalsIgnoreCase("y")&&!y.equalsIgnoreCase("n")){//Checks for invalid inputs
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
        ExcelWriting file2 = new ExcelWriting();//class for excel file writing
        ArrayList <double[]> data = new ArrayList <double[]>();//array list for array transportation
        int row = 1;//row counter for iterating through
        int industryCheck = 0;//used to find the position of the current company in the industry array
        int ppCheck = 0;//used to find the position of the current company in the private or public array
        int counter = 0;//used to count the ammount of companies if the user wants to add less companies than are on the sheet
        
        double[] arra = new double[7];//Automotive
        double[] arrs = new double[7];//Service Based
        double[] arrm = new double[7];//Manufacturing
        double[] arrt = new double[7];//Technology
        double[] arrf = new double[7];//Food Services
        
        //double[] arrag = new double[3];//Agricultural (MAYBE)
        
        //Change arr length based on how many cells
        DataGathering file1 = new DataGathering();//calss constructor for data calling class
        try{
            while(counter!=aoc){//while there is a company after this and/or another company the user wants checked
                if(industry[industryCheck].equalsIgnoreCase("automotive")){//if the compnay is in the automotive industry
                    String companyName = file.specificCellString(location, row, 0);//sets the company name
                    System.out.println(companyName);
                    data.add(file1.dataAuto(location, row, arra));//gathers the data
                    file2.excelWriting(companyName, arra);
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                }else if(industry[industryCheck].equalsIgnoreCase("service")){//if the compnay is in the service industry
                    String companyName = file.specificCellString(location, row, 0);//sets the company name
                    System.out.println(companyName);
                    data.add(file1.dataService(location, row, arrs));//gathers the data
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                }else if(industry[industryCheck].equalsIgnoreCase("manufacturing")){//if the compnay is in the manufacturing industry
                    String companyName = file.specificCellString(location, row, 0);//sets the company name
                    System.out.println(companyName);
                    data.add(file1.dataManufacturing(location, row, arrm));//gathers the data
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                }else if(industry[industryCheck].equalsIgnoreCase("technology")){//if the compnay is in the technology industry
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataTechnology(location, row, arrt));//gathers the data
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                }else if(industry[industryCheck].equalsIgnoreCase("food service")){//if the compnay is in the food service industry
                    String companyName = file.specificCellString(location, row, 0);
                    System.out.println(companyName);
                    data.add(file1.dataFood(location, row, arrf));//gathers the data
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                }
                counter++;//increments counter for checking procceding company
            }
        }catch(NullPointerException e){//null pointer exceptions
            System.out.println("Error: can not recieve data from next company");
            System.out.println("Ending data collection");
            //finishes data gathering if there is ever a null pointer exception
        }
        System.out.println("");
        System.out.println("Finished Processing Data");
        //send arrayList to be put onto a spreadsheet
        System.out.println("Data is now on SystemData.xlsx");
        ToTxt file12 = new ToTxt();
        file12.writeToFile(25);
        System.out.println("ty homie <<kisses you>>");
    }
}
