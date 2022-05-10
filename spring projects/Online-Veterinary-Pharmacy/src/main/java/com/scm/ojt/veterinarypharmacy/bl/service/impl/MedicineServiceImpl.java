package com.scm.ojt.veterinarypharmacy.bl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scm.ojt.veterinarypharmacy.persistance.dao.*;
import com.scm.ojt.veterinarypharmacy.entity.Medicine;
import com.scm.ojt.veterinarypharmacy.bl.service.MedicineService;

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
}
