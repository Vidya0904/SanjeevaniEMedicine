package com.example.sanjeevaniemedicine.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class RequestModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int reqID;

    @ColumnInfo(name = "reqDate")
    private String ReqDate;

    @ColumnInfo(name = "patientID")
    private int PatientID;

    @ColumnInfo(name = "prescImg")
    private byte[] PrescImg;

    @ColumnInfo(name = "estmtPrice")
    private float EstimatePrice;

    @ColumnInfo(name = "reqStatus")
    private String ReqStatus;

    @ColumnInfo(name = "isConfirm")
    private Boolean IsConfirm;

    public RequestModel() {
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public String getReqDate() {
        return ReqDate;
    }

    public void setReqDate(String reqDate) {
        ReqDate = reqDate;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public byte[] getPrescImg() {
        return PrescImg;
    }

    public void setPrescImg(byte[] prescImg) {
        PrescImg = prescImg;
    }

    public float getEstimatePrice() {
        return EstimatePrice;
    }

    public void setEstimatePrice(float estimatePrice) {
        EstimatePrice = estimatePrice;
    }

    public String getReqStatus() {
        return ReqStatus;
    }

    public void setReqStatus(String reqStatus) {
        ReqStatus = reqStatus;
    }

    public Boolean getIsConfirm() {
        return IsConfirm;
    }

    public void setIsConfirm(Boolean isConfirm) {
        IsConfirm = isConfirm;
    }
}
