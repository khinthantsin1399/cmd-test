package com.scm.ojt.veterinarypharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "medicine")
@SQLDelete(sql = "update medicine set deleted=true where medicine_id=?")
@Where(clause = "deleted = false")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    @Column(name = "name")
    private String medicineName;

    @Column(name = "category")
    private String medicineCategory;

    @Column(name = "description")
    private String medicineDescription;

    @Column(name = "price")
    private Double medicinePrice;

    @Column(name = "status")
    private String status;

    @Column(name = "unitInStock")
    private int unitInStock;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public Medicine() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return medicineName;
    }

    public void setName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCategory() {
        return medicineCategory;
    }

    public void setCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public String getDescription() {
        return medicineDescription;
    }

    public void setDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public Double getPrice() {
        return medicinePrice;
    }

    public void setPrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUnit() {
        return unitInStock;
    }

    public void setUnit(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public boolean getDeleted() {
        return deleted;
    }

    @PreRemove
    public void setDeleted(boolean deleted﻿) {
        this.deleted = false;
    }

    @Override
    public String toString() {
        return "Medicine [id=" + id + ", medicineName=" + medicineName + ", medicineCategory=" + medicineCategory
                + ",medicineDescription=" + medicineDescription + ",medicinePrice=" + medicinePrice + ",status="
                + status + ",unitInStock=" + unitInStock + "]";
    }
}
