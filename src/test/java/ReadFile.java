import driver.Driver;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    WebDriver driver = Driver.webDriver;
    Demo_Action demo = new Demo_Action(driver);
    public ReadFile(WebDriver driver){
        this.driver = driver;
    }
    public void Read(String pathFile, String fileName, String sheetName) throws IOException {
        File file = new File(pathFile +"\\"+ fileName);
        //tạo biến kiểu FileInputStream để đọc file, xảy ra ngoại lê khi k tìm ra file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru = null;
        //kiểm tra đuôi mở rộng của file excel
        String fileExtension = fileName.substring(fileName.indexOf("."));
        if (fileExtension.equals(".xlsx")){
            guru = new XSSFWorkbook(inputStream);
        }
        else if (fileExtension.equals(".xls")){
            guru = new HSSFWorkbook(inputStream);
        }
        //read sheet
        Sheet sheet =  guru.getSheet(sheetName);
        //dem số hàng
        int rowNumber = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for( int i = 0; i< rowNumber; i++){
            Row row = sheet.getRow(i);
            String locator = String.valueOf(row.getCell(0));
            String action = String.valueOf(row.getCell(1));
            String value = String.valueOf(row.getCell(2));
            switch (action){
                case "input":
                    demo.Input(locator,value);
                case "selector":
                    demo.Select(locator,value);
                case "check":
                    demo.check(locator);
            }
        }
    }
}

