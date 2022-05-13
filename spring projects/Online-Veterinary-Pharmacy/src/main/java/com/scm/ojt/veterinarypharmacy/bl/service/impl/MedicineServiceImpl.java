package com.scm.ojt.veterinarypharmacy.bl.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.scm.ojt.veterinarypharmacy.bl.service.MedicineService;
import com.scm.ojt.veterinarypharmacy.entity.Medicine;
import com.scm.ojt.veterinarypharmacy.excel.ExcelImport;
import com.scm.ojt.veterinarypharmacy.persistance.dao.MedicineDao;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDAO;

    /**
     * <h2>getMedicines</h2>
     * <p>
     * Override method to get medicine records
     * </p>
     *
     * @return
     */
    @Override
    public List<Medicine> getMedicineList() {
        return medicineDAO.getMedicineList();
    }

    /**
     * <h2>saveMedicine</h2>
     * <p>
     * Override method to save medicine record
     * </p>
     *
     * @param theMedicine
     */
    @Override
    public void saveMedicine(Medicine theMedicine) {
        medicineDAO.saveMedicine(theMedicine);
    }

    /**
     * <h2>getMedicine</h2>
     * <p>
     * Override method to get student record by id
     * </p>
     *
     * @param theId
     * @return
     */
    @Override
    public Medicine getMedicine(int theId) {
        return medicineDAO.getMedicine(theId);
    }

    /**
     * <h2>deleteMedicine</h2>
     * <p>
     * Override method to delete medicine record
     * </p>
     *
     * @param theId
     */
    @Override
    public void deleteMedicine(int theId) {
        medicineDAO.deleteMedicine(theId);
    }

    @Override
    public ByteArrayInputStream load() {
        List<Medicine> theMedicines = medicineDAO.getMedicineList();
        ByteArrayInputStream in = ExcelImport.tutorialsToExcel(theMedicines);
        return in;
    }

    /**
     * <h2>save</h2>
     * <p>
     * Override method to save excel data to database
     * </p>
     *
     * @param file
     */
    @Override
    public void save(MultipartFile file) {
        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Medicine> theMedicines = new ArrayList<Medicine>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
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
                    case 0:
                        m.setName((String) currentCell.getStringCellValue());
                        break;
                    case 1:
                        m.setCategory(currentCell.getStringCellValue());
                        break;
                    case 2:
                        m.setDescription(currentCell.getStringCellValue());
                        break;
                    case 3:
                        m.setPrice(currentCell.getNumericCellValue());
                        break;
                    case 4:
                        m.setStatus(currentCell.getStringCellValue());
                        break;
                    case 5:
                        m.setUnit((int) currentCell.getNumericCellValue());
                        break;
                    default:
                        break;
                    }
                    cellIdx++;
                }
                theMedicines.add(m);
            }
            workbook.close();
            for (Medicine MedicineData : theMedicines) {
                this.medicineDAO.saveMedicine(MedicineData);
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
