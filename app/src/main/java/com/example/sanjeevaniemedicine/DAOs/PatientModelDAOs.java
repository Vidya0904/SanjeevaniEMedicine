package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.PatientModel;

import java.util.List;

@Dao
public interface PatientModelDAOs {

    @Query("SELECT * FROM PatientModel")
    List<PatientModel> getAllPatients();

    @Insert
    long insetPatientModel(PatientModel P);

    @Update
    void updatePatientModel(PatientModel P);

    @Delete
    void deletePatientModel(PatientModel P);

    @Query("SELECT * FROM PatientModel WHERE uId=:patientId")
    PatientModel getPatientProfile(int patientId);


}
