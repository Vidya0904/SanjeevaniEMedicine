package com.example.sanjeevaniemedicine.Activities;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.PatientHomeActivityLayoutBinding;

public class PatientHomeActivity extends AppCompatActivity {
    PatientHomeActivityLayoutBinding binding;

    NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=PatientHomeActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.mn_patient_home,
                R.id.mn_Patient_orders,R.id.mn_patient_cart,R.id.mn_patient_profile,R.id.mn_Patient_request).build();

        navController = Navigation.findNavController(this,R.id.patient_home_act);

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomPatientHome,navController);
    }
}
