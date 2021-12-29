package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.Activities.PatientOrderDetailActivity;
import com.example.sanjeevaniemedicine.DataModels.OrderModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.PatientOrderItemLayoutBinding;

import java.util.List;

public class PatientOrderAdapter extends RecyclerView.Adapter<PatientOrderAdapter.MyViewHolder> {

    List<OrderModel> orderModelList;
    Context context6;

    public PatientOrderAdapter(List<OrderModel> orderModelList, Context context6) {
        this.orderModelList = orderModelList;
        this.context6 = context6;
    }

    @NonNull
    @Override
    public PatientOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PatientOrderItemLayoutBinding binding = PatientOrderItemLayoutBinding.inflate(LayoutInflater.from(context6),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PatientOrderAdapter.MyViewHolder holder, int position) {

        final OrderModel singleOrderModel = orderModelList.get(position);

        holder.binding.ordPatientName.setText(singleOrderModel.getOrdPatientName());
        holder.binding.ordAmt.setText(String.valueOf(context6.getResources().getString(R.string.rs_symbol)+""+singleOrderModel.getOrdTotalAmt()));
        holder.binding.ordDate.setText(singleOrderModel.getOrdDate());
        holder.binding.btnPatientDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context6, PatientOrderDetailActivity.class);
                i.putExtra("order",singleOrderModel);
                context6.startActivity(i);


            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        PatientOrderItemLayoutBinding binding;

        public MyViewHolder(@NonNull PatientOrderItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }

}
