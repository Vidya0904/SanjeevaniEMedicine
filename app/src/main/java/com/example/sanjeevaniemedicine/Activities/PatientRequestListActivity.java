package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.OwnerDashboardAdapter;
import com.example.sanjeevaniemedicine.Adapters.PatientRequestAdapter;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.PatientRequestActivityLayoutBinding;

import java.util.List;

public class PatientRequestListActivity extends AppCompatActivity {

    PatientRequestActivityLayoutBinding binding;
    List<RequestModel> requestModels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=PatientRequestActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        requestModels = DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .requestModelDAOs()
                .getAllRequest();

        PatientRequestAdapter patientRequestAdapter = new PatientRequestAdapter(requestModels,this);
        binding.recylerPatientrequest.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.recylerPatientrequest.setAdapter(patientRequestAdapter);

    }
}
