package com.scm.ojt.veterinarypharmacy.bl.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.scm.ojt.veterinarypharmacy.entity.Medicine;

/**
 * <h2>MedicineService Class</h2>
 * <p>
 * Process for Displaying MedicineService
 * </p>
 * 
 * @author khinthantsin
 *
 */
public interface MedicineService {
    /**
     * <h2>getMedicines</h2>
     * <p>
     * Abstract method to get medicine list
     * </p>
     * 
     * @return
     * @return List<Medicine>
     */
    public List<Medicine> getMedicineList();

    /**
     * <h2>saveMedicine</h2>
     * <p>
     * Abstract method to save medicine record
     * </p>
     * 
     * @param theStudent
     * @return void
     */
    public void saveMedicine(Medicine theMedicine);

    /**
     * <h2>getMedicine</h2>
     * <p>
     * Abstract method to get medicine by id
     * </p>
     * 
     * @param theId
     * @return
     * @return Medicine
     */
    public Medicine getMedicine(int theId);

    /**
     * <h2>deleteMedicine</h2>
     * <p>
     * Abstract method to delete medicine by id
     * </p>
     * 
     * @param theId
     * @return void
     */
    public void deleteMedicine(int theId);

    /**
     * <h2>load</h2>
     * <p>
     * method to load data from database
     * </p>
     * 
     * @return ByteArrayInputStream
     */
    public ByteArrayInputStream load();

    /**
     * <h2>save</h2>
     * <p>
     * Method to save excel file to database
     * </p>
     * 
     * @param file
     * @return void
     */
    public void save(MultipartFile file);
}
