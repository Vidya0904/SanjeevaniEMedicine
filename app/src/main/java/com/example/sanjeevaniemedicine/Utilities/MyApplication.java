package com.example.sanjeevaniemedicine.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication {

    private static MyApplication my_application_Instance;
    private SharedPreferences sharedPreferences;

    public static synchronized MyApplication getInstance()
    {
        if(my_application_Instance == null)
        {
            my_application_Instance = new MyApplication();
        }
        return my_application_Instance;
    }

    public SharedPreferences getSharedPreferences(Context context)
    {
        if (sharedPreferences == null)
        {
            sharedPreferences=context
                    .getSharedPreferences(SharedPreferenceKeyConstraint.PREF_NAME,0);
        }
        return sharedPreferences;
    }


}
