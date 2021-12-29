package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.Activities.OwnerRequestDetailActivity;
import com.example.sanjeevaniemedicine.DataModels.RequestModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.databinding.OwnerRequestItemLayoutBinding;

import java.util.List;

public class OwnerRequestAdapter extends RecyclerView.Adapter<OwnerRequestAdapter.MyViewHolder> {

    List<RequestModel> requestModels;
    Context cntxt;

    public OwnerRequestAdapter(List<RequestModel> requestModels, Context cntxt) {
        this.requestModels = requestModels;
        this.cntxt = cntxt;
    }


    @Override
    public int getItemCount() {
        return requestModels.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OwnerRequestItemLayoutBinding  binding = OwnerRequestItemLayoutBinding.inflate(LayoutInflater.from(cntxt),parent,false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final RequestModel singleRequestModel = requestModels.get(position);

        holder.binding.txtOreqdate.setText(singleRequestModel.getReqDate());
        holder.binding.txtOreqstatus.setText(singleRequestModel.getReqStatus());
        holder.binding.txtOreqestprice.setText(cntxt.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleRequestModel.getEstimatePrice()));
        holder.binding.reqOdetailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(cntxt, OwnerRequestDetailActivity.class);
                i.putExtra("req",singleRequestModel);
                cntxt.startActivity(i);

            }
        });
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        OwnerRequestItemLayoutBinding binding;

        public MyViewHolder(@NonNull OwnerRequestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
