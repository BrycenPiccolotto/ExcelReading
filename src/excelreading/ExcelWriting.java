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
    public void excelWriting(String compnayName, double[] arr) throws IOException{
        ToTxt file1 = new ToTxt();
        String excelFilePath = "\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet newSheet = workbook.getSheetAt(0);
            int rowCount = file1.readFromFile();
            Row row = newSheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell2 = row.createCell(columnCount);
            cell2.setCellValue(compnayName);
            for (int i = 0; i<arr.length; i++){
                Cell cell = row.createCell(++columnCount);
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
    public void removeData() throws IOException{
        String excelFilePath = "\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx";
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
            FileOutputStream outputStream = new FileOutputStream("\\\\JFRCVIFS.Student.UGDSB.ED\\Home\\Students\\BrPic4370\\Documents\\NetBeansProjects\\ExcelReading\\SystemData.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }catch(IOException | EncryptedDocumentException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
}
