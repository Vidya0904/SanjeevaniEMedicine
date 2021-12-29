package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.OrderItemDetailAdapter;
import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.OwnerOrderDetailActivityLayoutBinding;

import java.util.List;

public class OwnerOrderDetailActivity extends AppCompatActivity {

    OwnerOrderDetailActivityLayoutBinding binding;
    List<OrderModel> orderModels;
    private List<OrderItemModel> orderItemModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OwnerOrderDetailActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        OrderModel orderModel = (OrderModel)getIntent().getSerializableExtra("order");

        binding.txtODOName.setText(orderModel.getOrdPatientName());
        binding.txtODOMobNo.setText(orderModel.getOrdPatientMb());
        binding.txtODOAddress.setText(orderModel.getOrdPatientAdd());
        binding.txtODOTotalAmt.setText(String.valueOf(orderModel.getOrdTotalAmt()));

        orderItemModelList= DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .orderItemModelDAOs()
                .getOrderItensById(orderModel.getOrdID());

        OrderItemDetailAdapter orderItemDetailAdapter=new OrderItemDetailAdapter(orderItemModelList
                ,OwnerOrderDetailActivity.this);

        binding.rvOOrderDetail.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvOOrderDetail.setAdapter(orderItemDetailAdapter);

    }
}
