package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.DataModels.CartModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.OnIncrDecrAmountListener;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.CartItemLayoutBinding;

import java.util.List;

public class CartModelAdapter extends RecyclerView.Adapter<CartModelAdapter.MyViewHolder> {
    List<CartModel> cartModels;
    Context context2;


    private OnIncrDecrAmountListener onIncrDecrAmountListener;


    public void setOnIncreDecreAmountListner(OnIncrDecrAmountListener onIncrDecrAmountListener) {
        this.onIncrDecrAmountListener = onIncrDecrAmountListener;
    }

    public CartModelAdapter(List<CartModel> cartModels, Context context2) {
        this.cartModels = cartModels;
        this.context2 = context2;
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemLayoutBinding binding = CartItemLayoutBinding.inflate(LayoutInflater.from(context2),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartModelAdapter.MyViewHolder holder, int position) {
        final CartModel singleCartModel = cartModels.get(position);

        Bitmap imgBit= UtilsMethod.imgConvertFromByteArrayToBitmap(singleCartModel.getCartMedImg());
        holder.binding.imgCart.setImageBitmap(imgBit);

        holder.binding.txtCartMedName.setText(singleCartModel.getCartMedName());
        holder.binding.txtCartMedPrice.setText(String.valueOf(singleCartModel.getCartMedPrice()));
        holder.binding.txtCartMedStrip.setText(String.valueOf(singleCartModel.getCartMedStripSize()));
        holder.binding.txtCartQty.setText(String.valueOf(singleCartModel.getCartMedQty()));



        final float originalPrize=singleCartModel.getCartMedPrice();

        holder.binding.imgCartUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int newQty= Integer.parseInt(holder.binding.txtCartQty.getText().toString())+1;
                float newPrize=originalPrize*newQty;

                holder.binding.txtCartMedPrice.setText(context2.getResources().getString(R.string.rs_symbol)+" "+String.valueOf(newPrize));
                holder.binding.txtCartQty.setText(String.valueOf(newQty));


                onIncrDecrAmountListener.onIncrementAmount(originalPrize);
                singleCartModel.setCartMedPrice(newPrize);
                singleCartModel.setCartMedQty(newQty);
            }
        });

        holder.binding.imgCartDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQty= Integer.parseInt(holder.binding.txtCartQty.getText().toString())-1;
                float newPrize=originalPrize*newQty;

                holder.binding.txtCartMedPrice.setText(context2.getResources().getString(R.string.rs_symbol)+" "+String.valueOf(newPrize));
                holder.binding.txtCartQty.setText(String.valueOf(newQty));


                onIncrDecrAmountListener.onDecrementAmount(originalPrize);
                singleCartModel.setCartMedPrice(newPrize);
                singleCartModel.setCartMedQty(newQty);

            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CartItemLayoutBinding binding;

        public MyViewHolder(@NonNull CartItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
