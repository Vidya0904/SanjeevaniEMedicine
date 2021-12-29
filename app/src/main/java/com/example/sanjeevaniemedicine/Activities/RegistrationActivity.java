package com.example.sanjeevaniemedicine.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sanjeevaniemedicine.DataModels.UserModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.EmailMobileValidator;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.databinding.RegistrationLayoutBinding;

public class RegistrationActivity extends AppCompatActivity {

    RegistrationLayoutBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=RegistrationLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        binding.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EmailMobileValidator emailMobileValidtor = new EmailMobileValidator();

                if (!TextUtils.isEmpty(binding.fname.getText().toString())
                        &&  !TextUtils.isEmpty(binding.email.getText().toString())
                        &&  !TextUtils.isEmpty(binding.pass.getText().toString())
                        &&  !TextUtils.isEmpty(binding.mobile.getText().toString())){

                    if (emailMobileValidtor.validate(binding.email.getText().toString()) == true
                            && emailMobileValidtor.mobvalidate(binding.mobile.getText().toString()))
                    {
                        UserModel usermodel = new UserModel();

                        usermodel.setUsername(binding.fname.getText().toString());
                        usermodel.setEmail(binding.email.getText().toString());
                        usermodel.setPassword(binding.pass.getText().toString());
                        usermodel.setMobno(binding.mobile.getText().toString());
                        usermodel.setUsertype(getUserTypeValue());


                        long uId = DataBaseClient
                                .getInstance(getApplicationContext())
                                .getAppDatabaseClient().userDaos()
                                .insertUserModel(usermodel);

                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        SharedPreferenceManager.setUser_ID(RegistrationActivity.this,(int)uId);
                        SharedPreferenceManager.setUser_Type(RegistrationActivity.this, getUserTypeValue());
                        SharedPreferenceManager.setUser_Mob_No(RegistrationActivity.this,
                                binding.mobile.getText().toString());
                        SharedPreferenceManager.setUser_Email(RegistrationActivity.this, binding.email.getText().toString());
                        SharedPreferenceManager.setUser_Name(RegistrationActivity.this, binding.fname.getText().toString());

                        Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                        intent.putExtra("usertype", getUserTypeValue());
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Please Enter Valid Mobile No. or Email", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }



    private String getUserTypeValue()
    {
        int chkusertype=binding.rdgr.getCheckedRadioButtonId();
        if (chkusertype== R.id.ownerrdo)
        {
            return "Owner" ;
        }
        else
        {
            return "Patient";
        }
    }
}
