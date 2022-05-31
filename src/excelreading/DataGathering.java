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
    public DataGathering(){
        
    }
    /**
     *
     * @param location
     * @param row
     * @param arrs
     * @return
     */
    public double[] dataAuto(String location, int row, double[] arra) throws IOException{
        ExcelFileReading file = new ExcelFileReading();
        for(int i = 0; i<=6; i++){
            arra[i] = file.specificCellDouble(location, row, (i+1));
            System.out.println(arra[i]);
        }
        return arra;
    }
    public double[] dataService(String location, int row, double[] arrs) throws IOException{
        ExcelFileReading file = new ExcelFileReading();
        for(int i = 0; i<=6; i++){
            arrs[i] = file.specificCellDouble(location, row, (i+1));
            System.out.println(arrs[i]);
        }
        return arrs;
    }
    public double[] dataManufacturing(String location, int row, double[] arrm) throws IOException{
        ExcelFileReading file = new ExcelFileReading();
        for(int i = 0; i<=6; i++){
            arrm[i] = file.specificCellDouble(location, row, (i+1));
            System.out.println(arrm[i]);
        }
        //Call to data proceessing
        return arrm;
    }
    public double[] dataTechnology(String location, int row, double[] arrt) throws IOException{
        ExcelFileReading file = new ExcelFileReading();
        for(int i = 0; i<=6; i++){
            arrt[i] = file.specificCellDouble(location, row, (i+1));
            System.out.println(arrt[i]);
        }
        return arrt;
    }
    public double[] dataFood(String location, int row, double[] arrf) throws IOException{
        ExcelFileReading file = new ExcelFileReading();
        for(int i = 0; i<=6; i++){
            arrf[i] = file.specificCellDouble(location, row, (i+1));
            System.out.println(arrf[i]);
        }
        return arrf;
    }
}
