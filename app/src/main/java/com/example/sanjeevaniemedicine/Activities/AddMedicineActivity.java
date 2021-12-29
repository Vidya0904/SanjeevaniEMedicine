package com.example.sanjeevaniemedicine.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sanjeevaniemedicine.databinding.AddMedicineLayoutBinding;

public class AddMedicineActivity extends AppCompatActivity implements View.OnClickListener {
    AddMedicineLayoutBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=AddMedicineLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.selectstrip.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


    }
}
