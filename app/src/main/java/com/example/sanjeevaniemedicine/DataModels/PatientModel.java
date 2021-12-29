package com.example.sanjeevaniemedicine.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class PatientModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "uId")
    private int UserId;

    @ColumnInfo(name = "uName")
    private String UserName;

    @ColumnInfo(name = "gender")
    private String Gender;

    @ColumnInfo(name = "mbno")
    private String MobileNo;

    @ColumnInfo(name = "address")
    private String Address;

    @ColumnInfo(name = "city")
    private String City;

    @ColumnInfo(name = "pincode")
    private int PinCode;

    @ColumnInfo(name = "patientImage")
    private byte[] patientImage;



    public PatientModel() {
    }


    public byte[] getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(byte[] patientImage) {
        this.patientImage = patientImage;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAddress() {
        return Address;
    }



    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPinCode() {
        return PinCode;
    }

    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }
}
