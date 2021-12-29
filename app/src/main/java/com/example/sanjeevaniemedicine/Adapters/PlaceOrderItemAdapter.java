package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.PlaceOrderItemLayoutBinding;

import java.util.List;

public class PlaceOrderItemAdapter extends RecyclerView.Adapter<PlaceOrderItemAdapter.MyViewHolder> {

        List<CartModel> itemsList;
        Context context9;

    public PlaceOrderItemAdapter(List<CartModel> itemsList, Context context9) {
        this.itemsList = itemsList;
        this.context9 = context9;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlaceOrderItemLayoutBinding binding = PlaceOrderItemLayoutBinding.inflate(LayoutInflater.from(context9),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CartModel singleItem=itemsList.get(position);

        Bitmap imgBit= UtilsMethod.imgConvertFromByteArrayToBitmap(singleItem.getCartMedImg());
        holder.binding.placeMedImage.setImageBitmap(imgBit);

        holder.binding.txtplaceMedName.setText(singleItem.getCartMedName());
        holder.binding.txtPlaceMedPrice.setText(context9.getResources().getString(R.string.rs_symbol)
        +" "+String.valueOf(singleItem.getCartMedPrice()));

        holder.binding.txtplaceMedQty.setText("Qty "+String.valueOf(singleItem.getCartMedQty()));

        }

@Override
public int getItemCount() {
        return itemsList.size();
        }

class MyViewHolder extends RecyclerView.ViewHolder{

    PlaceOrderItemLayoutBinding binding;
    public MyViewHolder(@NonNull PlaceOrderItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
}
}