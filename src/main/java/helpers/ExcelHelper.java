package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelHelper {

    private final static Logger log = LogManager.getLogger("Помошник для работы с EXcel");

    public static List<String> readColumnFromExcel(String filePath, String sheetName){
        List<String> result = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = workbook.getSheet(sheetName);
            for(int i = 0; i < sheet.getLastRowNum(); i++){
                for(int a =0; a < sheet.getRow(i).getLastCellNum(); a++);{

                }
                result.add(sheet.getRow(i).getCell(0).getStringCellValue());
            }
        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }

    public static void writeToExcelFile(String filePath, String sheetName, String text){
        //prepare data
        List<String> textLines = Arrays.asList(text.split("\n"));
        File file = new File(filePath);
        //write to excel file
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if(sheet==null){
                sheet = workbook.createSheet(sheetName);
            }
            /*
            for(int i = 0; i < sheet.getLastRowNum(); i++){
                sheet.getRow(i).getCell(0).setCellValue("");
            }
            */
            for(int i = 0; i < textLines.size(); i++){
                XSSFRow row = sheet.createRow(i);
                XSSFCell cell = row.createCell(0);
                cell.setCellValue(textLines.get(i));
            }
            sheet.autoSizeColumn(0);
            workbook.write(new FileOutputStream(file));
            workbook.close();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
