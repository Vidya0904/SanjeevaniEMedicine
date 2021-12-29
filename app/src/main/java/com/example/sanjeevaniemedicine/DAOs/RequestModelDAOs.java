package com.example.sanjeevaniemedicine.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sanjeevaniemedicine.DataModels.RequestModel;

import java.util.List;

@Dao
public interface RequestModelDAOs {

    @Query("SELECT * FROM RequestModel")
    List<RequestModel> getAllRequest();

    @Insert
    long insertRequestModel(RequestModel R);

    @Update
    void updateRequestModel(RequestModel R);

    @Delete
    void deleteRequestModel(RequestModel R);

    @Query("UPDATE RequestModel SET estmtPrice=:estimatePrice WHERE reqID=:reqId")
    void updateEstimatePrice(int reqId,float estimatePrice);

    @Query("UPDATE RequestModel SET reqStatus=:newStatus WHERE reqID=:reqId")
    void updateStatus(int reqId,String newStatus);


    @Query("UPDATE RequestModel SET isConfirm=:isConfirmation WHERE reqID=:reqId")
    void updateConfirmation(int reqId,boolean isConfirmation);


}
