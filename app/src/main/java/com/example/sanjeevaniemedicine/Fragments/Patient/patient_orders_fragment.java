package com.example.sanjeevaniemedicine.Fragments.Patient;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sanjeevaniemedicine.Adapters.PatientOrderAdapter;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.PatientOrdersLayoutBinding;
import java.util.List;

public class patient_orders_fragment extends Fragment {
    PatientOrdersLayoutBinding binding;
    List<OrderModel> orderModelList;
    Context context7;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context7=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=PatientOrdersLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderModelList = DataBaseClient.getInstance(context7)
                .getAppDatabaseClient()
                .orderModelDAOs()
                .getAllOrders();

        PatientOrderAdapter patientOrderAdapter = new PatientOrderAdapter(orderModelList,context7);
        binding.recylerPatientOrder.setLayoutManager(new LinearLayoutManager(context7,LinearLayoutManager.VERTICAL,false));
        binding.recylerPatientOrder.setAdapter(patientOrderAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
