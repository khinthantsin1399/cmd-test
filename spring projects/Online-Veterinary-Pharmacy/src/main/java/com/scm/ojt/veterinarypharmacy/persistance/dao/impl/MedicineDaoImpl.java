package com.scm.ojt.veterinarypharmacy.persistance.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.scm.ojt.veterinarypharmacy.entity.Medicine;
import com.scm.ojt.veterinarypharmacy.persistance.dao.MedicineDao;

@Transactional
@Repository
public class MedicineDaoImpl implements MedicineDao {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>getMedicineList</h2>
     * <p>
     * Override method to get medicine records
     * </p>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Medicine> getMedicineList() {
        TypedQuery<Medicine> query = sessionFactory.getCurrentSession().createQuery("from Medicine");
        return query.getResultList();
    }

    /**
     * <h2>deleteMedicine</h2>
     * <p>
     * Override method to delete medicine record
     * </p>
     *
     * @param id
     */
    @Override
    public void deleteMedicine(int id) {
        Session session = sessionFactory.getCurrentSession();
        Medicine medicineData = session.byId(Medicine.class).load(id);
        session.delete(medicineData);
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
        sessionFactory.getCurrentSession().saveOrUpdate(theMedicine);
    }

    /**
     * <h2>getMedicine</h2>
     * <p>
     * Override method to get medicine record by id
     * </p>
     *
     * @param theId
     * @return
     */
    @Override
    public Medicine getMedicine(int theId) {
        Medicine theMedicine = sessionFactory.getCurrentSession().get(Medicine.class, theId);
        return theMedicine;
    }
}
