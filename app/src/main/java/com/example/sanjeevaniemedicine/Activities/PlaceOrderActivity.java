package com.example.sanjeevaniemedicine.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.PlaceOrderItemAdapter;
import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PlaceOrderActivityLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity {

    PlaceOrderActivityLayoutBinding binding;
    private List<CartModel> cartList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=PlaceOrderActivityLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        float totalAmt=getIntent().getFloatExtra("totalAmt",0);

        binding.txtPOTotalAmt.setText("Total :"+String.valueOf(totalAmt));


        cartList = DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .cartModelDAOs()
                .getAllCart();

        PlaceOrderItemAdapter placeOrderAdapter=new PlaceOrderItemAdapter(cartList,this);
        binding.rvPlaceOrder.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL
                ,false));
        binding.rvPlaceOrder.setAdapter(placeOrderAdapter);

        binding.btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName=binding.edtPOCustName.getText().toString();
                String strMobNo=binding.edtPOCustMobNo.getText().toString();
                String strAddress=binding.edtPOCustAddress.getText().toString();

                OrderModel orderModel=new OrderModel();
                if (!TextUtils.isEmpty(strName)
                        && !TextUtils.isEmpty(strMobNo)
                        && !TextUtils.isEmpty(strAddress)){

                    orderModel.setOrdPatientName(strName);
                    orderModel.setOrdPatientMb(strMobNo);
                    orderModel.setOrdPatientAdd(strAddress);
                    orderModel.setOrdDate(UtilsMethod.getDateAndTime());
                    orderModel.setOrdTotalAmt(totalAmt);

                    saveOrder(orderModel);
                    clearControls();
                }else{
                    Toast.makeText(PlaceOrderActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void saveOrder(OrderModel orderModel){
        long lastOrderId=DataBaseClient.getInstance(this)
                .getAppDatabaseClient().orderModelDAOs()
                .insertOrderModel(orderModel);

        List<OrderItemModel> itemList=new ArrayList<>();

        for (CartModel cm:cartList){
            OrderItemModel orderItemModel=new OrderItemModel();
            orderItemModel.setOrdItemName(cm.getCartMedName());
            orderItemModel.setOrdItemImg(cm.getCartMedImg());
            orderItemModel.setOrdItemPrice(cm.getCartMedPrice());
            orderItemModel.setOrdItemQty(cm.getCartMedQty());
            orderItemModel.setOrderId(lastOrderId);

            DataBaseClient.getInstance(this)
                    .getAppDatabaseClient()
                    .orderItemModelDAOs()
                    .insertOrderItemModel(orderItemModel);
        }
        DataBaseClient.getInstance(this)
                .getAppDatabaseClient()
                .cartModelDAOs()
                .deleteAll();

        Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void clearControls(){
        binding.edtPOCustMobNo.setText("");
        binding.edtPOCustMobNo.setText("");
        binding.edtPOCustAddress.setText("");
    }

}
