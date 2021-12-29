package com.example.sanjeevaniemedicine.Fragments.Patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Activities.PlaceOrderActivity;
import com.example.sanjeevaniemedicine.Adapters.CartModelAdapter;
import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.OnIncrDecrAmountListener;
import com.example.sanjeevaniemedicine.databinding.PatientCartLayoutBinding;

import java.util.List;

public class patient_cart_fragment extends Fragment implements OnIncrDecrAmountListener {
    PatientCartLayoutBinding binding;
    List<CartModel> cartModelList;
    Context context3;


    private float totalAmount;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context3=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=PatientCartLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cartModelList = DataBaseClient.getInstance(context3)
                .getAppDatabaseClient()
                .cartModelDAOs()
                .getAllCart();

        CartModelAdapter cartModelAdapter = new CartModelAdapter(cartModelList,context3);
        cartModelAdapter.setOnIncreDecreAmountListner(this);
        binding.recylercart.setLayoutManager(new LinearLayoutManager(context3,LinearLayoutManager.VERTICAL,false));
        binding.recylercart.setAdapter(cartModelAdapter);

        binding.txtCartTotalAmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context3, PlaceOrderActivity.class);
                i.putExtra("totalAmt", totalAmount);
                startActivity(i);

            }
        });

    }

    private void calculateAmount()
    {
        for (CartModel cm:cartModelList)
        {
            totalAmount += cm.getCartMedPrice();
        }
        binding.txtCartTotalAmt.setText("Check Out "+context3.getResources().getString(R.string.rs_symbol)+" "+ String.valueOf(totalAmount));
    }

    @Override
    public void onIncrementAmount(float amount) {
        totalAmount += amount;
        binding.txtCartTotalAmt.setText("Check Out "+context3.getResources().getString(R.string.rs_symbol)+" "+ String.valueOf(totalAmount));

    }

    @Override
    public void onDecrementAmount(float amount) {
        totalAmount -= amount;
        binding.txtCartTotalAmt.setText("Check Out "+context3.getResources().getString(R.string.rs_symbol)+" "+ String.valueOf(totalAmount));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
