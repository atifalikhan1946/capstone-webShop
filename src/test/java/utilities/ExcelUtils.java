package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    @DataProvider(name = "InvalidCredentialsProvider")
    public static Object[][] readInvalidCredentials() {
        String filePath = "C:\\Users\\ADMIN\\eclipse-workspace\\WebShop\\Credentials.xlsx"; // file path
        Object[][] data = new Object[3][2]; // 3 data rows, 2 columns

        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowNum = 1; rowNum <= 3; rowNum++) { // Loop through data rows (1, 2, 3)
                Row row = sheet.getRow(rowNum);

                String email = getCellValueAsString(row.getCell(0));
                String password = getCellValueAsString(row.getCell(1));

                data[rowNum - 1][0] = email; // Store email
                data[rowNum - 1][1] = password; // Store password
            }

            workbook.close();
            file.close();

        } catch (IOException e) {
            System.err.println("Error reading Excel: " + e.getMessage());
            return new Object[0][0]; // Return empty array on error
        }

        return data;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()).trim();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()).trim();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}