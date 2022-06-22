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
 * @author brycen
 */
public class ExcelReading {

    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Scanner scan =  new Scanner(System.in);//initialises scanner
        ToTxt file12 = new ToTxt();//intialises temp text file
        ToTxtLocation file5 = new ToTxtLocation();
        int rowcounter = 0;//used to input the ammount of rows in the ranking sheet, having it save from use to use so we never overwrite previous data
        ExcelWriting file2 = new ExcelWriting();//class for excel file writing
        String locationOfData;
        String locationOfLeaderboard;
        String locationOfTemp; 
        
        
        System.out.println("Would you like to remove all data from the ranking sheet?(y/n)");
        String z = scan.nextLine();//scans to ask weither or not the company is public or private
        while(!z.equalsIgnoreCase("y")&&!z.equalsIgnoreCase("n")){//Checks for invalid inputs
            System.out.println("Invalid input");
            System.out.println("Would you like to remove all data from the ranking sheet?(y/n)");
            z = scan.nextLine();
        } 
        if(file5.readFromFileLocationOfDataEntrySheet().equals("no")||file5.readFromFileLocationOfDataEntrySheet().equals("")){
            System.out.println("Please enter the file's location (Go to the file's location, click on its properties and copy and paste the file location)");
            String il = scan.nextLine();//Scan's the file location
            System.out.println("Please enter the name of the file (Please include \".xlsx\" at the end of your name");
            String fn = scan.nextLine();//Scan's the file name
            ToTxtLocation file6 = new ToTxtLocation(il);

            locationOfData = (il + "\\" + fn);//creates the location string off of the two previous inputs
            locationOfLeaderboard = (il + "\\SystemData.xlsx");
            locationOfTemp = (il + "\\temp.txt");
            file6.writeToFile(locationOfData, locationOfTemp, locationOfLeaderboard);
        }else{
            locationOfData = file5.readFromFileLocationOfDataEntrySheet();
            locationOfTemp = file5.readFromFileLocationOfTemp();
            locationOfLeaderboard = file5.readFromFileLocationOfSystemData();
        }
        
        
        if(z.equalsIgnoreCase("y")){
            file12.writeToFile(locationOfTemp, 0);//resets the ranking sheet
            file2.removeData(locationOfLeaderboard);
        }
        rowcounter = file12.readFromFile(locationOfTemp);//Sets rowcounter as to either not write over previous data or to restart the ranking sheet
        
        System.out.println("How many companies did you enter?");
        int aoc = scan.nextInt();//Scan's the ammount of companies the user enters
        
        ArrayList <double[]> data = new ArrayList <double[]>();//array list for keeping the company data
        /*
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
        */
        ExcelFileReading file = new ExcelFileReading();//class for excel file reading
        
        int row = 1;//row counter for iterating through
        //int industryCheck = 0;//used to find the position of the current company in the industry array
        //int ppCheck = 0;//used to find the position of the current company in the private or public array
        int counter = 0;//used to count the ammount of companies if the user wants to add less companies than are on the sheet
        
        double[] arra = new double[15];//Automotive
        double[] arrs = new double[15];//Service Based
        double[] arrm = new double[15];//Manufacturing
        double[] arrt = new double[15];//Technology
        double[] arrf = new double[15];//Food Services
        
        //Change arr length based on how many cells
        DataGathering file1 = new DataGathering();//calss constructor for data calling class
        try{
            while(counter!=aoc){//while there is a company after this and/or another company the user wants checked
                //if(industry[industryCheck].equalsIgnoreCase("automotive")){//if the compnay is in the automotive industry
                    String companyName = file.specificCellString(locationOfData, row, 0);//sets the company name
                    System.out.println(companyName + "\n");
                    data.add(file1.dataAuto(locationOfData, row, arra));//gathers the data
                    file2.excelWriting(locationOfLeaderboard, locationOfTemp, companyName, arra);
                    row++;//increments row counter
                    //industryCheck++;//increments industryCheck counter
                    rowcounter++;//increments rowcounter
                    file12.writeToFile(locationOfTemp, rowcounter);
                /*}else if(industry[industryCheck].equalsIgnoreCase("service")){//if the compnay is in the service industry
                    String companyName = file.specificCellString(locationOfData, row, 0);//sets the company name
                    System.out.println(companyName + "\n");
                    data.add(file1.dataService(locationOfData, row, arrs));//gathers the data
                    file2.excelWriting(locationOfLeaderboard, locationOfTemp, companyName, arrs);
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                    rowcounter++;//increments rowcounter
                    file12.writeToFile(locationOfTemp, rowcounter);
                }else if(industry[industryCheck].equalsIgnoreCase("manufacturing")){//if the compnay is in the manufacturing industry
                    String companyName = file.specificCellString(locationOfData, row, 0);//sets the company name
                    System.out.println(companyName + "\n");
                    data.add(file1.dataManufacturing(locationOfData, row, arrm));//gathers the data
                    file2.excelWriting(locationOfLeaderboard, locationOfTemp, companyName, arrm);
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                    rowcounter++;//increments rowcounter
                    file12.writeToFile(locationOfTemp, rowcounter);
                }else if(industry[industryCheck].equalsIgnoreCase("technology")){//if the compnay is in the technology industry
                    String companyName = file.specificCellString(locationOfData, row, 0);
                    System.out.println(companyName + "\n");
                    data.add(file1.dataTechnology(locationOfData, row, arrt));//gathers the data
                    file2.excelWriting(locationOfLeaderboard, locationOfTemp, companyName, arrt);
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                    rowcounter++;//increments rowcounter
                    file12.writeToFile(locationOfTemp, rowcounter);
                }else if(industry[industryCheck].equalsIgnoreCase("food service")){//if the compnay is in the food service industry
                    String companyName = file.specificCellString(locationOfData, row, 0);
                    System.out.println(companyName + "\n");
                    data.add(file1.dataFood(locationOfData, row, arrf));//gathers the data
                    file2.excelWriting(locationOfLeaderboard, locationOfTemp, companyName, arrf);
                    row++;//increments row counter
                    industryCheck++;//increments industryCheck counter
                    rowcounter++;//increments rowcounter
                    file12.writeToFile(locationOfTemp, rowcounter);*/
                //}
                counter++;//increments counter for checking procceding company
            }
        }catch(NullPointerException e){//null pointer exceptions
            System.out.println("Error: can not recieve data from next company");
            System.out.println("Ending data collection");
            //finishes data gathering if there is ever a null pointer exception
        }
        System.out.println("");
        System.out.println("Finished Processing Data");
        System.out.println("Data is now on SystemData.xlsx");
        file12.writeToFile(locationOfTemp, rowcounter);
    }
}
