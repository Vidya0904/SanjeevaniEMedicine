package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.CartModel;

import java.util.List;

@Dao
public interface CartModelDAOs {

    @Query("SELECT * FROM CartModel")
    List<CartModel> getAllCart();

    @Insert
    long insertCartModel(CartModel C);

    @Update
    void updateCartModel(CartModel C);

    @Delete
    void deleteCartModel(CartModel C);

    @Query("delete from CartModel")
    void deleteAll();

}
