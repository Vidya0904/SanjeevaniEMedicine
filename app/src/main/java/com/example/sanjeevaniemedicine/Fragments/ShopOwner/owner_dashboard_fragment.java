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
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.Adapters.OwnerDashboardAdapter;
import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.OwnerDashboardLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class owner_dashboard_fragment extends Fragment {
    OwnerDashboardLayoutBinding binding;
    List<MedicineModel> medicineModels;
    Context context1;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context1=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=OwnerDashboardLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicineModels = DataBaseClient.getInstance(context1)
                .getAppDatabaseClient()
                .medicineModelDAOs()
                .getAllMedicine();

        OwnerDashboardAdapter ownerDashboardAdapter = new OwnerDashboardAdapter(medicineModels,context1);
        binding.recylermedicine.setLayoutManager(new LinearLayoutManager(context1,LinearLayoutManager.VERTICAL,false));
        binding.recylermedicine.setAdapter(ownerDashboardAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
