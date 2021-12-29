package com.example.sanjeevaniemedicine.Fragments.Patient;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sanjeevaniemedicine.Activities.PatientRequestListActivity;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PatientMedRequestLayoutBinding;

public class Patient_Med_Request_Fragment extends Fragment implements View.OnClickListener {

    PatientMedRequestLayoutBinding binding;
    private int PICK_IMAGE = 25;
    BitmapFactory.Options options;
    private Bitmap imgBit;
    Context ctx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.ctx=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PatientMedRequestLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.reqTxtprsc.setOnClickListener(this);
        binding.reqSubmit.setOnClickListener(this);
        binding.reqBtnMyRequest.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == binding.reqTxtprsc.getId()){
            Intent pickphoto = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickphoto,PICK_IMAGE );

        }
        if (view.getId() == binding.reqSubmit.getId()){
            RequestModel requestModel=new RequestModel();

            requestModel.setReqDate(UtilsMethod.getDateAndTime());
            requestModel.setEstimatePrice(0f);
            requestModel.setReqStatus("pending");
            requestModel.setPrescImg(UtilsMethod.imgConvertFromBitmapToByteArray(imgBit));
            requestModel.setIsConfirm(false);

            DataBaseClient.getInstance(ctx).getAppDatabaseClient()
                    .requestModelDAOs().insertRequestModel(requestModel);

            Toast.makeText(ctx, "Request added", Toast.LENGTH_SHORT).show();
              }

        if(view.getId() == binding.reqBtnMyRequest.getId()){
            Intent i = new Intent(ctx, PatientRequestListActivity.class);
            ctx.startActivity(i);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            Uri reqselectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (reqselectedImage != null) {
                Cursor cursor = ctx.getContentResolver().query(reqselectedImage, filePathColumn,
                        null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imgBit = BitmapFactory.decodeFile(picturePath, options);
                    binding.reqPrsImg.setImageBitmap(imgBit);
                    cursor.close();
                }
            }
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
