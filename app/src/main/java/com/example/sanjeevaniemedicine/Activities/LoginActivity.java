package com.example.sanjeevaniemedicine.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sanjeevaniemedicine.DataModels.UserModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.databinding.LoginLayoutBinding;

public class LoginActivity extends AppCompatActivity {

    LoginLayoutBinding binding;

    String uType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        uType=getIntent().getStringExtra("usertype");

        binding.regtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

        binding.loginFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail=binding.loginEmail.getText().toString();
                String strPass=binding.loginPass.getText().toString();
                if(!TextUtils.isEmpty(strEmail)
                        && !TextUtils.isEmpty(strPass))
                {
                    if (strEmail.equals("Admin")
                            && strPass.equals("Admin"))
                    {
                        Intent i=new Intent(LoginActivity.this,OwnerHomeActivity.class);
                        startActivity(i);
                    }
                    else {
                        UserModel userModel = DataBaseClient.getInstance(getApplicationContext())
                                .getAppDatabaseClient().userDaos().userLogin(binding.loginEmail.getText().toString()
                                        ,binding.loginPass.getText().toString());

                        if (userModel != null)
                        {

                            SharedPreferenceManager.setUser_ID(LoginActivity.this, userModel.getID());
                            SharedPreferenceManager.setUser_Type(LoginActivity.this,userModel.getUsertype());
                            SharedPreferenceManager.setUser_Mob_No(LoginActivity.this, userModel.getMobno());
                            SharedPreferenceManager.setUser_Email(LoginActivity.this, userModel.getEmail());
                            if (userModel.getUsertype().equals("Owner"))
                            {
                                if (SharedPreferenceManager.getIsOwnerProfile(LoginActivity.this)){
                                    Intent i=new Intent(LoginActivity.this,OwnerHomeActivity.class);
                                    startActivity(i);
                                }else{
                                    Intent i=new Intent(LoginActivity.this,AddOwnerProfileActivity.class);
                                    startActivity(i);
                                }
                            }else {
                                if (SharedPreferenceManager.getIsPatientProf(LoginActivity.this)){
                                    Intent i=new Intent(LoginActivity.this,PatientHomeActivity.class);
                                    startActivity(i);
                                }else{
                                    Intent i=new Intent(LoginActivity.this,AddPatientProfileActivity.class);
                                    startActivity(i);
                                }

                            }
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "You are not Register", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
