package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.DataBaseClient;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PatientHomeItemLayoutBinding;

import java.util.List;

public class PatientHomeAdapter extends RecyclerView.Adapter<PatientHomeAdapter.MyViewHolder> {
    List<MedicineModel> medicineModelList;
    Context context4;

    public PatientHomeAdapter(List<MedicineModel> medicineModelList, Context context4) {
        this.medicineModelList = medicineModelList;
        this.context4 = context4;
    }

    @NonNull
    @Override
    public PatientHomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PatientHomeItemLayoutBinding binding = PatientHomeItemLayoutBinding.inflate(LayoutInflater.from(context4),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return medicineModelList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final MedicineModel singleMedModel = medicineModelList.get(position);

        Bitmap imgBit= UtilsMethod.imgConvertFromByteArrayToBitmap(singleMedModel.getMedicineImage());
        holder.binding.imgCartmed.setImageBitmap(imgBit);

        holder.binding.txthomeMedName.setText(singleMedModel.getMedicineName());
        holder.binding.txtHomeMedPrice.setText(context4.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleMedModel.getMedicinePrice()));
        holder.binding.txtHomeMedStrip.setText(String.valueOf(singleMedModel.getMedStripSize()));

        holder.binding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CartModel cartItem=new CartModel();
                cartItem.setCartMedImg(singleMedModel.getMedicineImage());
                cartItem.setCartMedName(singleMedModel.getMedicineName());
                cartItem.setCartMedPrice(singleMedModel.getMedicinePrice());
                cartItem.setCartMedStripSize(singleMedModel.getMedStripSize());
                cartItem.setCartMedQty(1);

                DataBaseClient.getInstance(context4)
                        .getAppDatabaseClient()
                        .cartModelDAOs()
                        .insertCartModel(cartItem);

                Toast.makeText(context4, "Added To Cart", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        PatientHomeItemLayoutBinding binding;

        public MyViewHolder(@NonNull PatientHomeItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
}
