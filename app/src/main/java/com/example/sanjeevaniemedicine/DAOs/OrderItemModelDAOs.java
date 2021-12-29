package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;

import java.util.List;

@Dao
public interface OrderItemModelDAOs
{

    @Query("SELECT * FROM OrderItemModel")
    List<OrderItemModel> getAllOrders();


    @Query("SELECT * FROM OrderItemModel WHERE orderId=:orderId")
    List<OrderItemModel> getOrderItensById(int orderId);

    @Insert
    long insertOrderItemModel(OrderItemModel OI);

    @Update
    void updateOrderItemModel(OrderItemModel OI);

    @Delete
    void deleteOrderItemModel(OrderItemModel OI);



}
