package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PatientRequestDetailActivityLayoutBinding;

import java.util.List;

public class PatientRequestDetailActivity extends AppCompatActivity {

    PatientRequestDetailActivityLayoutBinding binding;
    List<RequestModel> requestMod;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=PatientRequestDetailActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RequestModel requestModel =(RequestModel) getIntent().getSerializableExtra("req");

        binding.imgReqDetail.setImageBitmap(UtilsMethod.imgConvertFromByteArrayToBitmap(requestModel.getPrescImg()));
        binding.txtdtldate.setText("Date: " + requestModel.getReqDate());
        binding.txtdtlEstPrice.setText("Medicine Price: " +String.valueOf(requestModel.getEstimatePrice()));
        binding.txtdtlstatus.setText("Status: " +requestModel.getReqStatus());

        binding.btnPatientReqDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataBaseClient.getInstance(PatientRequestDetailActivity.this)
                        .getAppDatabaseClient()
                        .requestModelDAOs()
                        .updateConfirmation(requestModel.getReqID(),true);

                DataBaseClient.getInstance(PatientRequestDetailActivity.this)
                        .getAppDatabaseClient()
                        .requestModelDAOs()
                        .updateStatus(requestModel.getReqID(),"Confirmed");

                Toast.makeText(PatientRequestDetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
