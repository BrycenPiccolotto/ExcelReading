/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelreading;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 *
 * @author brycen
 */
public class ExcelWriting{
    public ExcelWriting(){
    
    }
    /**
     * 
     * @param locationOfSys //Location of SystemData.xlsx
     * @param locationOfTemp //Location of temp.txt
     * @param compnayName //Name of current company
     * @param arr //Array that is being entered into the array
     * @throws IOException 
     */
    public void excelWriting(String locationOfSys, String locationOfTemp, String compnayName, double[] arr) throws IOException{//Writes the array into SystemData.xlsx and increments the counter held in temp.txt
        ToTxt file1 = new ToTxt();
        String excelFilePath = locationOfSys;
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet newSheet = workbook.getSheetAt(0);
            int rowCount = file1.readFromFile(locationOfTemp);
            Row row = newSheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell2 = row.createCell(columnCount);
            cell2.setCellValue(compnayName);
            for (int i = 0; i<arr.length; i++){
                Cell cell = row.createCell(++columnCount);
                cell.setCellValue(arr[i]);
            }
            FileOutputStream outputStream = new FileOutputStream(locationOfSys);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch(IOException | EncryptedDocumentException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * 
     * @param location//Location of SystemData.xlsx
     * @throws IOException 
     */
    public void removeData(String location) throws IOException{//Wipes SystemData.xlsx and the counter in temp.txt
        String excelFilePath = location;
        try{
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet newSheet = workbook.getSheetAt(0);
            int rowCount = 0;
            for(int j = 0; j<20; j++){
                Row row = newSheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell2 = row.createCell(columnCount);
                cell2.setCellValue("");
                for (int i = 0; i<30; i++){
                    Cell cell = row.createCell(++columnCount);
                    cell.setCellValue("");
                }
            }
            FileOutputStream outputStream = new FileOutputStream(location);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch(IOException | EncryptedDocumentException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
}
