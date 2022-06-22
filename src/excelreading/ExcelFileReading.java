/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.NullPointerException;

/**
 *
 * @author brycen
 */
public class ExcelFileReading {
    public ExcelFileReading(){//basic constructor
        
    }
    /**
     * 
     * @param locationExcel//location of excel file
     * @param row1//row of the cell the user wants data from
     * @param col//column of the cell the user wants data from
     * @return 
     */
    public String specificCellString(String locationExcel, int row1, int col){//returns the String value in the cell that is entered into the param's of the method
        String value=null;          //variable for storing the cell value  
        Workbook wb=null;           //initialize Workbook null  
        try{  
            //reading data from a file in the form of bytes  
            FileInputStream fis=new FileInputStream(locationExcel);  
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb=new XSSFWorkbook(fis);  
        }  
        catch(FileNotFoundException e){  //if file not found 
            e.printStackTrace();  
        }  
        catch(IOException e1){  //if IOEexception
            e1.printStackTrace();  
        }  
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row=sheet.getRow(row1); //returns the logical row  
        Cell cell=row.getCell(col); //getting the cell representing the given column 
        try{
            value=cell.getStringCellValue();    //getting cell value 
        }
        catch(NullPointerException els){//nullpointer exception return's blank if an incorrect or no value is enetered
            els.printStackTrace(); 
            return "";
        } 
        return value;               //returns the cell value  
    }
    /**
     * 
     * @param locationExcel//location of excel file
     * @param row1//row of the cell the user wants data from
     * @param col//column of the cell the user wants data from
     * @return
     * @throws IOException 
     */
    public double specificCellDouble(String locationExcel, int row1, int col) throws IOException{//returns the double value in the cell that is entered into the param's of the method
        double value=0;          //variable for storing the cell value  
        Workbook wb=null;           //initialize Workbook null  
        try{  
            //reading data from a file in the form of bytes  
            FileInputStream fis=new FileInputStream(locationExcel);  
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb=new XSSFWorkbook(fis);  
        }  
        catch(FileNotFoundException e){ //if file not found 
            e.printStackTrace();  
        }  
        catch(IOException e1){  //if IOEexception
            e1.printStackTrace();  
        }  
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row=sheet.getRow(row1); //returns the logical row  
        Cell cell=row.getCell(col); //getting the cell representing the given column  
        try{
            value=cell.getNumericCellValue(); //getting cell value  
        }
        catch(NullPointerException e){//nullpointer exception return's a 0 if an incorrect or no value is enetered
            return 0;
        }
        return value;//returns the cell value  
    }
}