package com.scm.ojt.veterinarypharmacy.persistance.dao;

import java.util.List;

import com.scm.ojt.veterinarypharmacy.entity.Medicine;

public interface MedicineDao {

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
     * @param theMedicine
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
    public Medicine getMedicine(int id);

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

}
