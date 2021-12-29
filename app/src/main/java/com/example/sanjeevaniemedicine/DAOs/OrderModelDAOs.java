package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.DataModels.OwnerModel;

import java.util.List;

@Dao
public interface OrderModelDAOs {

    @Query("SELECT * FROM OrderModel")
    List<OrderModel> getAllOrders();

    @Insert
    long insertOrderModel(OrderModel O);

    @Update
    void updateOrderModel(OrderModel O);

    @Delete
    void deleteOrderModel(OrderModel O);



}
