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
 * @author brpic4370
 */
public class ExcelFileReading {
    public ExcelFileReading(){
        
    }
    
    
    
    public boolean newCompany(String locationExcel) throws IOException{
        try{  
            File file = new File(locationExcel);   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);   
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            if (itr.hasNext()){
                return true;
            }
        }catch(Exception e){       
            e.printStackTrace();  
        } 
        return false;
    }
    public String specificCellString(String locationExcel, int row1, int col){
        String value=null;          //variable for storing the cell value  
        Workbook wb=null;           //initialize Workbook null  
        try{  
            //reading data from a file in the form of bytes  
            FileInputStream fis=new FileInputStream(locationExcel);  
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb=new XSSFWorkbook(fis);  
        }  
        catch(FileNotFoundException e){  
            e.printStackTrace();  
        }  
        catch(IOException e1){  
            e1.printStackTrace();  
        }  
        catch(NullPointerException els){
            els.printStackTrace(); 
            return "";
        }
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row=sheet.getRow(row1); //returns the logical row  
        Cell cell=row.getCell(col); //getting the cell representing the given column 
        value=cell.getStringCellValue();    //getting cell value  
        return value;               //returns the cell value  
    }
    public double specificCellDouble(String locationExcel, int row1, int col) throws IOException{
        double value=0;          //variable for storing the cell value  
        Workbook wb=null;           //initialize Workbook null  
        try{  
            //reading data from a file in the form of bytes  
            FileInputStream fis=new FileInputStream(locationExcel);  
            //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
            wb=new XSSFWorkbook(fis);  
        }  
        catch(FileNotFoundException e){  
            e.printStackTrace();  
        }  
        catch(IOException e1){  
            e1.printStackTrace();  
        }  
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
        Row row=sheet.getRow(row1); //returns the logical row  
        Cell cell=row.getCell(col); //getting the cell representing the given column  
        try{
        value=cell.getNumericCellValue(); //getting cell value  
        }
        catch(NullPointerException e){
            return 0;
        }
        return value;//returns the cell value  
    }
}