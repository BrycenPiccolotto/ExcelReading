/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;

import java.io.IOException;

/**
 *
 * @author brpic4370
 */
public class DataGathering {
    public DataGathering(){//basic constructor
        
    }
    /**
     *
     * @param location
     * @param row
     * @param arrs
     * @return
     */
    public double[] dataAuto(String location/*location of excel file*/, int row/*row of the company*/, double[] arra/*array for the respective industry*/) throws IOException{//gathers data for an automotive industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=6; i++){//iterates through all the information needed for this industry in the excel file
            arra[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
            System.out.println(arra[i]);
        }
        return arra;//returns the array
    }
    public double[] dataService(String location/*location of excel file*/, int row/*row of the company*/, double[] arrs/*array for the respective industry*/) throws IOException{//gathers data for a service industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=6; i++){//iterates through all the information needed for this industry in the excel file
            arrs[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
            System.out.println(arrs[i]);
        }
        return arrs;//returns the array
    }
    public double[] dataManufacturing(String location/*location of excel file*/, int row/*row of the company*/, double[] arrm/*array for the respective industry*/) throws IOException{//gathers data for a manufacturing industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=6; i++){//iterates through all the information needed for this industry in the excel file
            arrm[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
            System.out.println(arrm[i]);
        }
        //Call to data proceessing
        return arrm;//returns the array
    }
    public double[] dataTechnology(String location/*location of excel file*/, int row/*row of the company*/, double[] arrt/*array for the respective industry*/) throws IOException{//gathers data for a technology industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=6; i++){//iterates through all the information needed for this industry in the excel file
            arrt[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
            System.out.println(arrt[i]);
        }
        return arrt;//returns the array
    }
    public double[] dataFood(String location/*location of excel file*/, int row/*row of the company*/, double[] arrf/*array for the respective industry*/) throws IOException{//gathers data for a food service industry based company
        ExcelFileReading file = new ExcelFileReading();//constructor for excel file
        for(int i = 0; i<=6; i++){//iterates through all the information needed for this industry in the excel file
            arrf[i] = file.specificCellDouble(location, row, (i+1));//checks each cell in the company's row in the excel sheet and enters the data into the array that will be returned
            System.out.println(arrf[i]);
        }
        return arrf;//returns the array
    }
}
