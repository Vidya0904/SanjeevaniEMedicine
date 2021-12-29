package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.Activities.OwnerOrderDetailActivity;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.OwnerOrderItemLayoutBinding;

import java.util.List;

public class  OwnerOrderAdapter extends RecyclerView.Adapter<OwnerOrderAdapter.MyViewHolder> {

    List<OrderModel> orderModel;
    Context cntxt;

    public OwnerOrderAdapter(List<OrderModel> orderModel, Context cntxt) {
        this.orderModel = orderModel;
        this.cntxt = cntxt;
    }

    @NonNull
    @Override
    public OwnerOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OwnerOrderItemLayoutBinding binding = OwnerOrderItemLayoutBinding.inflate(LayoutInflater.from(cntxt),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return orderModel.size();
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerOrderAdapter.MyViewHolder holder, int position) {
        final OrderModel singleOrderModel = orderModel.get(position);

        holder.binding.ownordPatientName.setText(singleOrderModel.getOrdPatientName());
        holder.binding.ownordAmt.setText(cntxt.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleOrderModel.getOrdTotalAmt()));
        holder.binding.ownordDate.setText(singleOrderModel.getOrdDate());
        holder.binding.btnOwnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(cntxt, OwnerOrderDetailActivity.class);
                i.putExtra("order",singleOrderModel);
                cntxt.startActivity(i);

            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        OwnerOrderItemLayoutBinding binding;

        public MyViewHolder(@NonNull OwnerOrderItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
