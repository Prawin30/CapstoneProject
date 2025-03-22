package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData{
    private Workbook workbook;

    public ExcelData(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
    }

    public String getCellData(int sheetIndex, int row, int col) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}

