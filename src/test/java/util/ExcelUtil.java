package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ExcelUtil {


	public static String[][] getExcelDataAsArray(String filePath, String sheetName) throws IOException {
	       
    	// Excel file
        File file = new File(filePath);

        // Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Read excel sheet by sheet name
        Sheet sheet = workbook.getSheet(sheetName);

        // Find number of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        System.out.println(rowCount+" last row "+sheet.getLastRowNum()+" first row"+sheet.getFirstRowNum() );
        int colCount = sheet.getRow(0).getLastCellNum();

        // Create a loop over all the rows of excel file to read it
        DataFormatter formatter = new DataFormatter();
        // load data into this 2D array
        String[][] arrData = new String[rowCount][colCount];

        for (int i = 0; i <rowCount; i++) {

            Row row = sheet.getRow(i);

            // Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {

                // Print Excel data in console
                String cellData = formatter.formatCellValue(row.getCell(j)); //0.getcell(0)
                arrData[i][j] = cellData;

            }
        }
        System.out.println(Arrays.toString(arrData));
        return arrData;
    }

    public static void writeDataToExcel(String filePath, String sheetName, String[] dataToWrite) throws IOException {

        // Create an object of File class to open xlsx file
        File file = new File(filePath);

        // Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);

        // Read excel sheet by sheet name
        Sheet sheet = workbook.getSheet(sheetName);

        // Get the current count of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        System.out.println("rows "+rowCount);
        // Get the first row from the sheet
        Row row = sheet.getRow(0);

        // Create a new row and append it at last of sheet
        Row newRow = sheet.createRow(rowCount + 1);

        // Create a loop over the cell of newly created Row
        for (int j = 0; j < row.getLastCellNum(); j++) {
            // Fill data in row
            Cell cell = newRow.createCell(j);

            cell.setCellValue(dataToWrite[j]);
        }

        // Close input stream
        inputStream.close();

        // Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream outputStream = new FileOutputStream(file);

        // write data in the excel file
        workbook.write(outputStream);

        // close output stream
        outputStream.close();

    }
}
