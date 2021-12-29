package com.example.sanjeevaniemedicine.DataModels;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class MedicineModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int medID;

    @ColumnInfo(name = "medName")
    private String MedicineName;

    @ColumnInfo(name = "medPrice")
    private float MedicinePrice;

    @ColumnInfo(name = "medImg")
    private byte[] MedicineImage;

    @ColumnInfo(name = "medStripSize")
    private int MedStripSize;

    @ColumnInfo(name = "medType")
    private String MedicineType;

    public MedicineModel() {
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public Float getMedicinePrice() {
        return MedicinePrice;
    }

    public void setMedicinePrice(Float medicinePrice) {
        MedicinePrice = medicinePrice;
    }

    public byte[] getMedicineImage() {
        return MedicineImage;
    }

    public void setMedicineImage(byte[] medicineImage) {
        MedicineImage = medicineImage;
    }

    public int getMedStripSize() {
        return MedStripSize;
    }

    public void setMedStripSize(int medStripSize) {
        MedStripSize = medStripSize;
    }

    public String getMedicineType() {
        return MedicineType;
    }

    public void setMedicineType(String medicineType) {
        MedicineType = medicineType;
    }
}
