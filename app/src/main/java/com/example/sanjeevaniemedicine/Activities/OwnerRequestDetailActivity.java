package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.OwnerRequestDetailActivityLayoutBinding;

import java.util.List;

public class OwnerRequestDetailActivity extends AppCompatActivity {

    OwnerRequestDetailActivityLayoutBinding binding;
    List<RequestModel> requestModels;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OwnerRequestDetailActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RequestModel requestModel = (RequestModel) getIntent().getSerializableExtra("req");

        binding.imgOwnReqDetail.setImageBitmap(UtilsMethod.imgConvertFromByteArrayToBitmap(requestModel.getPrescImg()));
        binding.txtOwnReqdate.setText("Date: " + requestModel.getReqDate());
        binding.txtOwnReqEstPrice.setText("Medicine Price:" +String.valueOf(requestModel.getEstimatePrice()));
        binding.txtOwnReqstatus.setText("Status: " +requestModel.getReqStatus());

        binding.btnOwnReqSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float estPrice=Float.parseFloat(binding.edtmedOwnReqPrice.getText().toString());
                DataBaseClient.getInstance(OwnerRequestDetailActivity.this)
                        .getAppDatabaseClient()
                        .requestModelDAOs()
                        .updateEstimatePrice(requestModel.getReqID(),estPrice);

                DataBaseClient.getInstance(OwnerRequestDetailActivity.this)
                        .getAppDatabaseClient()
                        .requestModelDAOs()
                        .updateStatus(requestModel.getReqID(),"Estimated");

                Toast.makeText(OwnerRequestDetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
