package com.example.sanjeevaniemedicine.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class OrderModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ordID;

    @ColumnInfo(name = "ordDate")
    private String OrdDate;

    @ColumnInfo(name = "ordTotalAmt")
    private float OrdTotalAmt;

    @ColumnInfo(name = "ordPatientName")
    private String OrdPatientName;

    @ColumnInfo(name = "ordPatientAdd")
    private String OrdPatientAdd;

    @ColumnInfo(name = "ordPatientMb")
    private String OrdPatientMb;

    public OrderModel() {
    }

    public int getOrdID() {
        return ordID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public String getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(String ordDate) {
        OrdDate = ordDate;
    }

    public float getOrdTotalAmt() {
        return OrdTotalAmt;
    }

    public void setOrdTotalAmt(float ordTotalAmt) {
        OrdTotalAmt = ordTotalAmt;
    }

    public String getOrdPatientName() {
        return OrdPatientName;
    }

    public void setOrdPatientName(String ordPatientName) {
        OrdPatientName = ordPatientName;
    }

    public String getOrdPatientAdd() {
        return OrdPatientAdd;
    }

    public void setOrdPatientAdd(String ordPatientAdd) {
        OrdPatientAdd = ordPatientAdd;
    }

    public String getOrdPatientMb() {
        return OrdPatientMb;
    }

    public void setOrdPatientMb(String ordPatientMb) {
        OrdPatientMb = ordPatientMb;
    }
}
