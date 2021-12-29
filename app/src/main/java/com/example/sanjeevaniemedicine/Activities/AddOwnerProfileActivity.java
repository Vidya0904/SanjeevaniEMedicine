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

import com.example.sanjeevaniemedicine.DataModels.OwnerModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.SharedPreferenceManager;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.AddOwnerProfileLayoutBinding;

public class AddOwnerProfileActivity extends AppCompatActivity implements View.OnClickListener {

    AddOwnerProfileLayoutBinding binding;
    private int PICK_IMAGE = 25;
    private Bitmap imgbit;
    BitmapFactory.Options options;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=AddOwnerProfileLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},44);

        binding.addOwnerprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == binding.addOwnerprofileimg.getId())
                {
                    Intent pickphoto = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickphoto,PICK_IMAGE);
                }
            }
        });

        binding.ownersvbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(binding.edtownername.getText().toString())
            && !TextUtils.isEmpty(binding.edtownershopnm.getText().toString())
            && !TextUtils.isEmpty(binding.edtownermobile.getText().toString())
            && !TextUtils.isEmpty(binding.edtowneraddress.getText().toString())
            && !TextUtils.isEmpty(binding.edtownercity.getText().toString()))
        {

            OwnerModel ownerModel = new OwnerModel();

            ownerModel.setUserName(binding.edtownername.getText().toString());
            ownerModel.setShopName(binding.edtownershopnm.getText().toString());
            ownerModel.setMobileNo(binding.edtownermobile.getText().toString());
            ownerModel.setAddress(binding.edtowneraddress.getText().toString());
            ownerModel.setCity(binding.edtownercity.getText().toString());
            ownerModel.setPinCode(Integer.parseInt(binding.edtownerpin.getText().toString()));
            ownerModel.setUserId(SharedPreferenceManager.getUser_Id(this));
            ownerModel.setOwnerImage(UtilsMethod.imgConvertFromBitmapToByteArray(imgbit));


            DataBaseClient.getInstance(this).getAppDatabaseClient().ownerModelDAOs().insertOwnerModel(ownerModel);

                Toast.makeText(this, "Owner added", Toast.LENGTH_SHORT).show();
                SharedPreferenceManager.setIsOwnerProfile(AddOwnerProfileActivity.this,true);
                clearcontrol();

            }
        else{
                Toast.makeText(this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }

        Intent intent = new Intent(AddOwnerProfileActivity.this,OwnerHomeActivity.class);
        startActivity(intent);

        }

        public void clearcontrol()
        {
            binding.edtownername.setText("");
            binding.edtownershopnm.setText("");
            binding.edtownermobile.setText("");
            binding.edtowneraddress.setText("");
            binding.edtownercity.setText("");
            binding.edtownerpin.setText("");
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
                    binding.addOwnerprofileimg.setImageBitmap(imgbit);
                    cursor.close();
                }
            }
        }
    }



}

