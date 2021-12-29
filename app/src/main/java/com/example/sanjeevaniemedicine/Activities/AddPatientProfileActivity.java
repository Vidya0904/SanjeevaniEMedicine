package com.example.sanjeevaniemedicine.Activities;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.sanjeevaniemedicine.DataModels.PatientModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.AddPatientProfileLayoutBinding;

public class AddPatientProfileActivity extends AppCompatActivity implements View.OnClickListener {

    AddPatientProfileLayoutBinding binding;

    private int PICK_IMAGE = 25;
    private Bitmap imgbit;
    BitmapFactory.Options options;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddPatientProfileLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},44);


        binding.addPatientprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == binding.addPatientprofileimg.getId())
                {
                    Intent pickphoto = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickphoto,PICK_IMAGE);
                }
            }
        });

        binding.patientsvbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (!TextUtils.isEmpty(binding.edtpatientname.getText().toString())
                && !TextUtils.isEmpty(binding.edtpatientmobile.getText().toString())
                && !TextUtils.isEmpty(binding.edtpatientaddress.getText().toString())
                && !TextUtils.isEmpty(binding.edtpatientcity.getText().toString())
                && !TextUtils.isEmpty(binding.edtpatientpin.getText().toString()))
        {
            PatientModel patientModel = new PatientModel();

            patientModel.setUserName(binding.edtpatientname.getText().toString());
            patientModel.setMobileNo(binding.edtpatientmobile.getText().toString());
            patientModel.setAddress(binding.edtpatientaddress.getText().toString());
            patientModel.setCity(binding.edtpatientcity.getText().toString());
            patientModel.setPinCode(Integer.parseInt(binding.edtpatientpin.getText().toString()));
            patientModel.setUserId(SharedPreferenceManager.getUser_Id(this));
            patientModel.setPatientImage(UtilsMethod.imgConvertFromBitmapToByteArray(imgbit));
            DataBaseClient.getInstance(this).getAppDatabaseClient()
                    .patientModelDAOs()
                    .insetPatientModel(patientModel);

            Toast.makeText(this, "Patient added", Toast.LENGTH_SHORT).show();
            SharedPreferenceManager.setIsPatientProfile(AddPatientProfileActivity.this,true);
            clearcontrol();

        }
        else{
            Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(AddPatientProfileActivity.this,PatientHomeActivity.class);
        startActivity(intent);

    }


    private void clearcontrol()
    {
        binding.edtpatientname.setText("");
        binding.edtpatientaddress.setText("");
        binding.edtpatientmobile.setText("");
        binding.edtpatientcity.setText("");
        binding.edtpatientpin.setText("");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && data != null)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage != null)
            {
                Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn,
                        null, null,  null);
                if (cursor != null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imgbit = BitmapFactory.decodeFile(picturePath,options);
                    binding.addPatientprofileimg.setImageBitmap(imgbit);
                    cursor.close();
                }
            }
        }
    }

}
