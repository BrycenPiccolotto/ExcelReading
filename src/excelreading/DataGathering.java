/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;

import java.io.IOException;

/**
 * 
 * @author brycen
 */
public class DataGathering {
    public DataGathering(){//basic constructor
        
    }
    /**
     * 
     * @param location //Location of SystemData.xlsx
     * @param row //row of the company
     * @param arra //array for the respective industry
     * @return the array of the company's data
     * @throws IOException 
     */
    public double[] dataAuto(String location, int row, double[] arra) throws IOException{//gathers data for an automotive industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=14; i++){//iterates through all the information needed for this industry in the excel file
            arra[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
        }
        return arra;//returns the array
    }
    /**
     * 
     * @param location //Location of SystemData.xlsx
     * @param row //row of the company
     * @param arrs //array for the respective industry
     * @return
     * @throws IOException 
     */
    /*
    public double[] dataService(String location, int row, double[] arrs) throws IOException{//gathers data for a service industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=14; i++){//iterates through all the information needed for this industry in the excel file
            arrs[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
        }
        return arrs;//returns the array
    }
    */
    /**
     * 
     * @param location //Location of SystemData.xlsx
     * @param row //row of the company
     * @param arrm //array for the respective industry
     * @return
     * @throws IOException 
     */
    /*
    public double[] dataManufacturing(String location, int row, double[] arrm) throws IOException{//gathers data for a manufacturing industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=14; i++){//iterates through all the information needed for this industry in the excel file
            arrm[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
        }
        //Call to data proceessing
        return arrm;//returns the array
    }
    */
    /**
     * 
     * @param location //Location of SystemData.xlsx
     * @param row //row of the company
     * @param arrt //array for the respective industry
     * @return
     * @throws IOException 
     */
    /*
    public double[] dataTechnology(String location, int row, double[] arrt) throws IOException{//gathers data for a technology industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=14; i++){//iterates through all the information needed for this industry in the excel file
            arrt[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
        }
        return arrt;//returns the array
    }
    */
    /**
     * 
     * @param location //Location of SystemData.xlsx
     * @param row //row of the company
     * @param arrf //array for the respective industry
     * @return
     * @throws IOException 
     */
    /*
    public double[] dataFood(String location, int row, double[] arrf) throws IOException{//gathers data for a food service industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=14; i++){//iterates through all the information needed for this industry in the excel file
            arrf[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
        }
        return arrf;//returns the array
    }
    */
}
