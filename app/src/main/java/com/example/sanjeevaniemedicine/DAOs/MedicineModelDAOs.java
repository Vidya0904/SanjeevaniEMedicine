package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.MedicineModel;

import java.util.List;

@Dao
public interface MedicineModelDAOs {

    @Query("SELECT * FROM MedicineModel")
    List<MedicineModel> getAllMedicine();

    @Insert
    long insertMedicineModel(MedicineModel M);

    @Update
    void updateMedicineModel(MedicineModel M);

    @Delete
    void deleteMedicineModel(MedicineModel M);

}
