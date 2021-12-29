package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.UserModel;

import java.util.List;

@Dao
public interface UserModelDAOs {

    @Query("SELECT * FROM UserModel")
    List<UserModel> getAllUsers();

    @Insert
    long insertUserModel(UserModel U);

    @Update
    void updateUserModel(UserModel U);

    @Delete
    void deleteUserModel(UserModel U);

    @Query("Select * from UserModel WHERE Email=:email and password=:pass")
    UserModel userLogin(String email,String pass);

}
