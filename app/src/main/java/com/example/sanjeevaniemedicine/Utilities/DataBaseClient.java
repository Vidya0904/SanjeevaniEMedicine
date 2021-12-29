package com.example.sanjeevaniemedicine.Utilities;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;


public class DataBaseClient {

    private Context context;
    private static DataBaseClient mInstatnce;

    private AppDataBaseClient appDatabaseClient;

    public DataBaseClient(Context context)
    {
        this.context=context;

        appDatabaseClient = Room.databaseBuilder(context,AppDataBaseClient.class,"SanjeevaniEMedicineDB")
                .allowMainThreadQueries().build();

    }
    public static synchronized DataBaseClient getInstance(Context context)
    {
        if (mInstatnce == null)
        {
            mInstatnce = new DataBaseClient(context);
        }
        return mInstatnce;
    }
    public AppDataBaseClient getAppDatabaseClient()
    {
        return appDatabaseClient;
    }

}
