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
 * @author brpic4370
 */
public class ExcelWriting{
    public ExcelWriting(){
    
    }
    public void excelWriting(String compnayName, double[] arr){
        String excelFilePath = "\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            //Sheet newSheet = workbook.createSheet("Data");
            Sheet newSheet = workbook.getSheetAt(0);
            int rowCount = 0;
            Row row = newSheet.createRow(++rowCount);
            int columnCount = 0;
            for (int i = 0; i<arr.length; i++){
                Cell cell = row.createCell(++columnCount);
                System.out.println(arr[i]);
                cell.setCellValue(arr[i]);
            }
            FileOutputStream outputStream = new FileOutputStream("\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch(IOException | EncryptedDocumentException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
    public void excelAppend(String companyName, double[] arr){
        String excelFilePath = "\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Object[][] bookData = {{"Updated ", "Java"},{"Entire sheet ", "code"},{" done", "done"},};
            int rowCount = sheet.getLastRowNum();
            for(Object[] aBook : bookData){
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                for(Object field : aBook){
                    cell = row.createCell(++columnCount);
                    if(field instanceof String){
                        cell.setCellValue((String) field);
                    }else if(field instanceof Integer){
                        cell.setCellValue((Integer) field);
                    }
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch(IOException | EncryptedDocumentException | InvalidFormatException ex){
            ex.printStackTrace();
        }
    }
}
