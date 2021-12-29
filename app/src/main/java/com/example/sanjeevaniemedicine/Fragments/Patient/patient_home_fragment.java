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

import com.example.sanjeevaniemedicine.Adapters.CartModelAdapter;
import com.example.sanjeevaniemedicine.Adapters.PatientHomeAdapter;
import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.PatientHomeLayoutBinding;

import java.util.List;

public class patient_home_fragment extends Fragment {
    PatientHomeLayoutBinding binding;
    List<MedicineModel> medList;
    Context context5;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context5=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=PatientHomeLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medList = DataBaseClient.getInstance(context5)
                .getAppDatabaseClient()
                .medicineModelDAOs()
                .getAllMedicine();

        PatientHomeAdapter patientHomeAdapter = new PatientHomeAdapter(medList,context5);
        binding.recylerHome.setLayoutManager(new LinearLayoutManager(context5,LinearLayoutManager.VERTICAL,false));
        binding.recylerHome.setAdapter(patientHomeAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
