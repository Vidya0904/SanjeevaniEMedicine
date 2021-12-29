package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.OwnerModel;

import java.util.List;

@Dao
public interface OwnerModelDAOs {

    @Query("SELECT * FROM OwnerModel")
    List<OwnerModel> getAllOwners();

    @Insert
    long insertOwnerModel(OwnerModel O);

    @Update
    void updateOwnerModel(OwnerModel O);

    @Delete
    void delteOwnerModel(OwnerModel O);

    @Query("SELECT * FROM OwnerModel WHERE uId=:ownerId")
    OwnerModel getOwnerProfile(int ownerId);

}
