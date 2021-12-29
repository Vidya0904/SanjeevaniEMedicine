package com.example.sanjeevaniemedicine.Utilities;

import android.content.Context;

public class SharedPreferenceManager
{

    public static boolean setUser_ID(Context context, int User_Id)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putInt(SharedPreferenceKeyConstraint.USER_ID,User_Id).commit();
    }

    public static int getUser_Id(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.USER_ID,0);
    }

    public static long getMYAPP_ID(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.MYAPP_ID,0);
    }

    public static boolean setMYAPP_ID(Context context,long MyApp_Id)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.MYAPP_ID,MyApp_Id).commit();
    }

    public static boolean setAPP_List(Context context,long AppList_Id)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.APPLIST_ID,AppList_Id).commit();
    }

    public static long getAppList_Id(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.APPLIST_ID,0);
    }

    public static boolean setIs_Registration(Context context,long Is_Registration)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.IS_REGISTRATION,Is_Registration).commit();
    }

    public static long getIs_Registration(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.IS_REGISTRATION,0);
    }

    public static boolean setUser_Name(Context context,String User_Name)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putString(SharedPreferenceKeyConstraint.USER_NAME,User_Name).commit();
    }

    public static String getUser_Name(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceKeyConstraint.USER_NAME,"");
    }

    public static boolean setDisplay_Name(Context context,long Display_Name)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.DISPLAY_NAME,Display_Name).commit();
    }

    public static long getDisplay_Name(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.DISPLAY_NAME,0);
    }

    public static boolean setUser_Email(Context context,String User_Email)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putString(SharedPreferenceKeyConstraint.USER_EMAIL, User_Email).commit();
    }

    public static String getUser_Email(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceKeyConstraint.USER_EMAIL,"");
    }

    public static boolean setUser_Mob_No(Context context,String User_Mob_Id)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putString(SharedPreferenceKeyConstraint.USER_MOB_NO,User_Mob_Id).commit();
    }

    public static String getUser_Mob_No(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceKeyConstraint.USER_MOB_NO,"");
    }

    public static boolean setUser_Address(Context context,long User_Address)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.USER_ADDREES,User_Address).commit();
    }

    public static long getUser_Address(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.USER_ADDREES,0);
    }

    public static long getUser_Type(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.USER_TYPE,0);
    }
    public static boolean setUser_Type(Context context,String User_Type)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putString(SharedPreferenceKeyConstraint.USER_TYPE,User_Type).commit();
    }


    public static boolean setGender(Context context,String Gender)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putString(SharedPreferenceKeyConstraint.GENDER,Gender).commit();
    }

    public static long getGender(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.GENDER,0);
    }

    public static boolean setUser_Login(Context context,long User_Login)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putLong(SharedPreferenceKeyConstraint.IS_LOGIN,User_Login).commit();
    }

    public static long getUser_Login(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceKeyConstraint.IS_LOGIN,0);
    }




    public static boolean setIsOwnerProfile(Context context,boolean isOwnProf)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putBoolean(SharedPreferenceKeyConstraint.OWNER_PROFILE,isOwnProf)
                .commit();
    }

    public static boolean getIsOwnerProfile(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getBoolean(SharedPreferenceKeyConstraint.OWNER_PROFILE,false);
    }


    public static boolean setIsPatientProfile(Context context,boolean isPatientProf)
    {
        return MyApplication.getInstance().getSharedPreferences(context).edit()
                .putBoolean(SharedPreferenceKeyConstraint.PATIENT_PROFILE,isPatientProf)
                .commit();
    }

    public static boolean getIsPatientProf(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getBoolean(SharedPreferenceKeyConstraint.PATIENT_PROFILE,false);
    }



}
