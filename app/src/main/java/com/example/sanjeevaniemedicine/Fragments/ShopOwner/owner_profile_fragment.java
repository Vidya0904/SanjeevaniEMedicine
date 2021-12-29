package com.example.sanjeevaniemedicine.Fragments.ShopOwner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanjeevaniemedicine.DataModels.OwnerModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.OwnerProfileLayoutBinding;

public class owner_profile_fragment extends Fragment {
    OwnerProfileLayoutBinding binding;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=OwnerProfileLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OwnerModel ownProfile= DataBaseClient.getInstance(context)
                .getAppDatabaseClient()
                .ownerModelDAOs()
                .getOwnerProfile(SharedPreferenceManager.getUser_Id(context));

        binding.ownProfileName.setText(ownProfile.getUserName());
        binding.ownShopName.setText(ownProfile.getShopName());
        binding.ownPromobileno.setText(ownProfile.getMobileNo());

        binding.ownProfileImg.setImageBitmap(UtilsMethod.imgConvertFromByteArrayToBitmap(ownProfile.getOwnerImage()));
    }
}
