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

import com.example.sanjeevaniemedicine.Adapters.OwnerRequestAdapter;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.databinding.OwnerRequestLayoutBinding;

import java.util.List;

public class owner_request_fragment extends Fragment {

    OwnerRequestLayoutBinding binding;
    List<RequestModel> requestModelList;
    Context cntxt;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.cntxt=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = OwnerRequestLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requestModelList = DataBaseClient.getInstance(cntxt)
                .getAppDatabaseClient()
                .requestModelDAOs()
                .getAllRequest();

        OwnerRequestAdapter ownerRequestAdapter = new OwnerRequestAdapter(requestModelList,cntxt);
        binding.recylerOwnerRequest.setLayoutManager(new LinearLayoutManager(cntxt,LinearLayoutManager.VERTICAL,false));
        binding.recylerOwnerRequest.setAdapter(ownerRequestAdapter);

    }
}

