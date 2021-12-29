package com.example.sanjeevaniemedicine.Fragments.Patient;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanjeevaniemedicine.DataModels.PatientModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PatientProfileLayoutBinding;

public class patient_profile_fragment extends Fragment {

    PatientProfileLayoutBinding binding;
    Context context;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=PatientProfileLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PatientModel patProfile= DataBaseClient.getInstance(context)
                .getAppDatabaseClient()
                .patientModelDAOs()
                .getPatientProfile(SharedPreferenceManager.getUser_Id(context));

        binding.ptProfileName.setText(patProfile.getUserName());
        binding.ptProaddress.setText(patProfile.getAddress()
        );
        binding.ptPromobileno.setText(patProfile.getMobileNo());

        binding.ptProfileImg.setImageBitmap(UtilsMethod.imgConvertFromByteArrayToBitmap(patProfile.getPatientImage()));
    }
}
