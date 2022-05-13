package com.scm.ojt.veterinarypharmacy.excel;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.scm.ojt.veterinarypharmacy.entity.Medicine;
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Name", "Category", "Description", "Price","Status","Unit In Stock" };
    static String SHEET = "Medicine Details";
    public static boolean hasExcelFormat(MultipartFile file) {
      if (!TYPE.equals(file.getContentType())) {
        return false;
      }
      return true;
    }
    public static List<Medicine> excelTodb(InputStream is) {
      try {
          Workbook workbook = WorkbookFactory.create(is);
          Sheet sheet = workbook.getSheetAt(0);
       /* Workbook workbook = new HSSFWorkbook(is);
        Sheet sheet = workbook.getSheet(SHEET);*/
        Iterator<Row> rows = sheet.iterator();
        List<Medicine> theMedicines = new ArrayList<Medicine>();
        int rowNumber = 0;
        while (rows.hasNext()) {
          Row currentRow = rows.next();
          // skip header
          if (rowNumber == 0) {
            rowNumber++;
            continue;
          }
          Iterator<Cell> cellsInRow = currentRow.iterator();
          Medicine m = new Medicine();
          int cellIdx = 0;
          while (cellsInRow.hasNext()) {
            Cell currentCell = cellsInRow.next();
            switch (cellIdx) {
            case 1:
              m.setName((String) currentCell.getStringCellValue());
              break;
            case 2:
              m.setCategory(currentCell.getStringCellValue());
              break;
            case 3:
              m.setDescription(currentCell.getStringCellValue());
              break;
            case 4:
              m.setPrice(currentCell.getNumericCellValue());
              break;
            case 5:
                m.setStatus(currentCell.getStringCellValue());
                break;
            case 6:
                m.setUnit((int)currentCell.getNumericCellValue());
                break;
            default:
                break;
              }
              cellIdx++;
            }
            theMedicines.add(m);
          }
          workbook.close();
          return theMedicines;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }
}
