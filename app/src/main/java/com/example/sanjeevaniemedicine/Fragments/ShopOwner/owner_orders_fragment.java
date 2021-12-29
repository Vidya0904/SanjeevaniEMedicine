package com.example.sanjeevaniemedicine.Fragments.ShopOwner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.OwnerOrderAdapter;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.OwnerOrdersLayoutBinding;

import java.util.List;

public class owner_orders_fragment extends Fragment {
    OwnerOrdersLayoutBinding binding;
    List<OrderModel> orderModelList;
    Context cntxt2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.cntxt2=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=OwnerOrdersLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderModelList = DataBaseClient.getInstance(cntxt2)
                .getAppDatabaseClient()
                .orderModelDAOs()
                .getAllOrders();

        OwnerOrderAdapter patientOrderAdapter = new OwnerOrderAdapter(orderModelList,cntxt2);
        binding.recylerOwnerOrder.setLayoutManager(new LinearLayoutManager(cntxt2,LinearLayoutManager.VERTICAL,false));
        binding.recylerOwnerOrder.setAdapter(patientOrderAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
