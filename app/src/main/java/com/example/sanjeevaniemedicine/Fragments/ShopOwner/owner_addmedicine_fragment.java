package com.example.sanjeevaniemedicine.Fragments.ShopOwner;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.AddMedicineLayoutBinding;
import com.example.sanjeevaniemedicine.databinding.OwnerAddmedicineLayoutBinding;

public class owner_addmedicine_fragment extends Fragment implements View.OnClickListener {
    AddMedicineLayoutBinding binding;
    private int PICK_IMAGE = 25;
    BitmapFactory.Options options;
    private Bitmap imgBit;
    private Context ctx;
    String strStrip, strMedType;
    String[]  arrmedStrip = {"5","10","20"};
    String[]  arrmedType = {"Tablet", "Capsule", "Syrup"};

    private static int GALLERY_REQ=22;

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        this.ctx=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=AddMedicineLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.selectstrip.setOnClickListener(this);
        binding.selecttype.setOnClickListener(this);
        binding.selectimg.setOnClickListener(this);
        binding.svaddmed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == binding.selectstrip.getId()){
            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Medicine Strip");
            builder.setSingleChoiceItems(arrmedStrip, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    strStrip = arrmedStrip[i];
                    binding.selectstrip.setText("Medicine Strip : " +strStrip);

                }
            });

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        if (view.getId() == binding.selecttype.getId())
        {
            final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Medicine Type");
            builder.setSingleChoiceItems(arrmedType, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    strMedType = arrmedType[i];
                    binding.selecttype.setText("Medicine Type : "+strMedType);
                }
            });

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        if (view.getId() == binding.selectimg.getId()){
            Intent pickphoto = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickphoto,PICK_IMAGE );

        }

        if (view.getId() == binding.svaddmed.getId()){
            if(!TextUtils.isEmpty(binding.medname.getText().toString())
               && !TextUtils.isEmpty(binding.medPrice.getText().toString())){

                MedicineModel medicineModel = new MedicineModel();

                medicineModel.setMedicineName(binding.medname.getText().toString());
                medicineModel.setMedStripSize(Integer.parseInt(strStrip));
                medicineModel.setMedicinePrice(Float.parseFloat(binding.medPrice.getText().toString()));
                medicineModel.setMedicineType(binding.selecttype.getText().toString());
                medicineModel.setMedicineImage(UtilsMethod.imgConvertFromBitmapToByteArray(imgBit));
                DataBaseClient.getInstance(ctx).getAppDatabaseClient()
                        .medicineModelDAOs().insertMedicineModel(medicineModel);

                Toast.makeText(ctx, "Medicine added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ctx, "Enter Valid Data", Toast.LENGTH_SHORT).show();
            }

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage != null) {
                Cursor cursor = ctx.getContentResolver().query(selectedImage, filePathColumn,
                        null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imgBit = BitmapFactory.decodeFile(picturePath, options);
                    binding.medimg.setImageBitmap(imgBit);
                    cursor.close();
                }
            }
        }

    }
}
