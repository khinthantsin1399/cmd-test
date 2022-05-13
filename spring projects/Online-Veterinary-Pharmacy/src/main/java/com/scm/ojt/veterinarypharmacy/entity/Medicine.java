package com.scm.ojt.veterinarypharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *<h2> Medicine Class</h2>
 * <p>
 * Process for Displaying Medicine
 * </p>
 *@author khinthantsin
 *
 */
@Entity
@Table(name = "medicine")
@SQLDelete(sql = "update medicine set deleted=true where medicine_id=?")
@Where(clause = "deleted = false")
public class Medicine {
    /**
     * <h2> id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    /**
     * <h2> medicineName</h2>
     * <p>
     * medicineName
     * </p>
     */
    @Column(name = "name")
    @NotEmpty(message = "Medicine Name is required!")
    private String medicineName;

    /**
     * <h2> medicineCategory</h2>
     * <p>
     * medicineCategory
     * </p>
     */
    @Column(name = "category")
    @NotEmpty(message = "Category Name  is required!")
    private String medicineCategory;

    /**
     * <h2> medicineDescription</h2>
     * <p>
     * medicineDescription
     * </p>
     */
    @Column(name = "description")
    @NotEmpty(message = "Description for this item  is required!")
    private String medicineDescription;

    /**
     * <h2> medicinePrice</h2>
     * <p>
     * medicinePrice
     * </p>
     */
    @Column(name = "price")
    private Double medicinePrice;

    /**
     * <h2> status</h2>
     * <p>
     * status
     * </p>
     */
    @Column(name = "status")
    private String status;

    /**
     * <h2> unitInStock</h2>
     * <p>
     * unitInStock
     * </p>
     */
    @Column(name = "unitInStock")
    private int unitInStock;

    /**
     * <h2> deleted</h2>
     * <p>
     * deleted
     * </p>
     */
    @Column(name = "deleted")
    private Boolean deleted = false;

    /**
     * <h2> Constructor for Medicine </h2>
     * <p>
     * Constructor for Medicine
     * </p>
     */
    public Medicine() {

    }

    /**
     * <h2> getId</h2>
     * <p>
     *getter method for id
     * </p>
     * @return
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * <h2> setId</h2>
     * <p>
     *Setter method for id
     * </p>
     * @param id
     * @return void
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <h2> getName</h2>
     * <p>
     *getter method for name
     * </p>
     * @return
     * @return String
     */
    public String getName() {
        return medicineName;
    }

    /**
     * <h2> setName</h2>
     * <p>
     *Setter method for name
     * </p>
     * @param medicineName
     * @return void
     */
    public void setName(String medicineName) {
        this.medicineName = medicineName;
    }

    /**
     * <h2> getCategory</h2>
     * <p>
     *getter method for category
     * </p>
     * @return
     * @return String
     */
    public String getCategory() {
        return medicineCategory;
    }

    /**
     * <h2> setCategory</h2>
     * <p>
     *Setter method for category
     * </p>
     * @param medicineCategory
     * @return void
     */
    public void setCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    /**
     * <h2> getDescription</h2>
     * <p>
     *getter method for description
     * </p>
     * @return
     * @return String
     */
    public String getDescription() {
        return medicineDescription;
    }

    /**
     * <h2> setDescription</h2>
     * <p>
     *Setter method for description
     * </p>
     * @param medicineDescription
     * @return void
     */
    public void setDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    /**
     * <h2> getPrice</h2>
     * <p>
     *getter method for price
     * </p>
     * @return
     * @return Double
     */
    public Double getPrice() {
        return medicinePrice;
    }

    /**
     * <h2> setPrice</h2>
     * <p>
     *Setter method for price
     * </p>
     * @param medicinePrice
     * @return void
     */
    public void setPrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    /**
     * <h2> getStatus</h2>
     * <p>
     *getter method for status
     * </p>
     * @return
     * @return String
     */
    public String getStatus() {
        return status;
    }

    /**
     * <h2> setStatus</h2>
     * <p>
     *Setter method for status
     * </p>
     * @param status
     * @return void
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * <h2> getUnit</h2>
     * <p>
     *getter method for unit in stock
     * </p>
     * @return
     * @return int
     */
    public int getUnit() {
        return unitInStock;
    }

    /**
     * <h2> setUnit</h2>
     * <p>
     *Setter method for unit in stock
     * </p>
     * @param unitInStock
     * @return void
     */
    public void setUnit(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    /**
     * <h2> getDeleted</h2>
     * <p>
     *getter method for delete flag
     * </p>
     * @return
     * @return boolean
     */
    public boolean getDeleted() {
        return deleted;
    }

    /**
     * <h2> setDeleted</h2>
     * <p>
     *Setter method for delete flag
     * </p>
     * @param deleted﻿
     * @return void
     */
    @PreRemove
    public void setDeleted(boolean deleted﻿) {
        this.deleted = false;
    }

    /**
     * <h2> toString </h2>
     * <p>
     *
     * </p>
     *
     * @return
     */
    @Override
    public String toString() {
        return "Medicine [id=" + id + ", medicineName=" + medicineName + ", medicineCategory=" + medicineCategory
                + ",medicineDescription=" + medicineDescription + ",medicinePrice=" + medicinePrice + ",status="
                + status + ",unitInStock=" + unitInStock + "]";
    }
}
