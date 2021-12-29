package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.OrderItemDetailAdapter;
import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.PatientOrderDetailActivityLayoutBinding;

import java.util.List;

public class PatientOrderDetailActivity extends AppCompatActivity {

    PatientOrderDetailActivityLayoutBinding binding;
    List<OrderModel> orderModels;
    private List<OrderItemModel> orderItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=PatientOrderDetailActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        OrderModel orderModel = (OrderModel) getIntent().getSerializableExtra("order");

        binding.txtPDOName.setText(orderModel.getOrdPatientName());
        binding.txtPDOMobNo.setText(orderModel.getOrdPatientMb());
        binding.txtPDOAddress.setText(orderModel.getOrdPatientAdd());
        binding.txtPDOTotalAmt.setText(String.valueOf(orderModel.getOrdTotalAmt()));


        orderItemList= DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .orderItemModelDAOs()
                .getOrderItensById(orderModel.getOrdID());

        OrderItemDetailAdapter orderItemDetailAdapter=new OrderItemDetailAdapter(orderItemList
        ,PatientOrderDetailActivity.this);

        binding.rvPOrderDetail.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvPOrderDetail.setAdapter(orderItemDetailAdapter);
    }
}
