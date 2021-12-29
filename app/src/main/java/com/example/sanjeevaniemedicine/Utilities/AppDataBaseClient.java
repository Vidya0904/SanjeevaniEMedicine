package com.example.sanjeevaniemedicine.Utilities;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sanjeevaniemedicine.DAOs.CartModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.MedicineModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.OrderItemModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.OrderModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.OwnerModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.PatientModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.RequestModelDAOs;
import com.example.sanjeevaniemedicine.DAOs.UserModelDAOs;
import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.DataModels.OwnerModel;
import com.example.sanjeevaniemedicine.DataModels.PatientModel;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.DataModels.UserModel;

@Database(entities = {UserModel.class, PatientModel.class, OwnerModel.class, MedicineModel.class,
        CartModel.class, RequestModel.class, OrderModel.class, OrderItemModel.class}, version = 1,exportSchema = false)

public abstract class AppDataBaseClient extends RoomDatabase {


    public abstract UserModelDAOs userDaos();
    public abstract PatientModelDAOs patientModelDAOs();
    public abstract OwnerModelDAOs ownerModelDAOs();
    public abstract MedicineModelDAOs medicineModelDAOs();
    public abstract CartModelDAOs cartModelDAOs();
    public abstract RequestModelDAOs requestModelDAOs();
    public abstract OrderModelDAOs orderModelDAOs();
    public abstract OrderItemModelDAOs orderItemModelDAOs();
}
