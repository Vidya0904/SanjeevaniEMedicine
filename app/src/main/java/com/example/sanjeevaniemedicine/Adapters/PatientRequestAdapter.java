package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.Activities.PatientRequestDetailActivity;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.PatientRequestItemLayoutBinding;

import java.util.List;

public class PatientRequestAdapter extends RecyclerView.Adapter<PatientRequestAdapter.MyViewHolder> {

    List<RequestModel> requestModels;
    Context context8;

    public PatientRequestAdapter(List<RequestModel> requestModels, Context context8) {
        this.requestModels = requestModels;
        this.context8 = context8;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PatientRequestItemLayoutBinding binding = PatientRequestItemLayoutBinding.inflate(LayoutInflater.from(context8),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return requestModels.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PatientRequestAdapter.MyViewHolder holder, int position) {
        final RequestModel singleRequestModel = requestModels.get(position);

        holder.binding.txtreqdate.setText(singleRequestModel.getReqDate());
        holder.binding.txtreqstatus.setText(singleRequestModel.getReqStatus());
        holder.binding.txtreqestprice.setText(context8.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleRequestModel.getEstimatePrice()));
        holder.binding.reqDetailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context8,PatientRequestDetailActivity.class);
                i.putExtra("req",singleRequestModel);
                context8.startActivity(i);

            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        PatientRequestItemLayoutBinding binding;

        public MyViewHolder(@NonNull PatientRequestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
}}
