package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.DataModels.OrderItemModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.OrderItemDetailLayoutBinding;

import java.util.List;

public class OrderItemDetailAdapter extends RecyclerView.Adapter<OrderItemDetailAdapter.MyViewHolder> {

    List<OrderItemModel> orderItemModels;
    Context context;

    public OrderItemDetailAdapter(List<OrderItemModel> orderItemModels, Context context) {
        this.orderItemModels = orderItemModels;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return orderItemModels.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemDetailLayoutBinding binding = OrderItemDetailLayoutBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderItemModel singleItemModel = orderItemModels.get(position);

        holder.binding.txtOIDMedName.setText(singleItemModel.getOrdItemName());
        holder.binding.txtOIDMedPrice.setText(context.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleItemModel.getOrdItemPrice()));
        holder.binding.txtOIDMedQty.setText(String.valueOf(singleItemModel.getOrdItemQty()));

    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        OrderItemDetailLayoutBinding binding;

        public MyViewHolder(@NonNull OrderItemDetailLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
