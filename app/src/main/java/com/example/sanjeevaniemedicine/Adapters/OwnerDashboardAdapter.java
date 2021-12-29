package com.example.sanjeevaniemedicine.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjeevaniemedicine.DataModels.MedicineModel;
import com.example.sanjeevaniemedicine.R;
import com.example.sanjeevaniemedicine.Utilities.UtilsMethod;
import com.example.sanjeevaniemedicine.databinding.DashboardRecycleItemLayoutBinding;

import java.util.List;

public class OwnerDashboardAdapter extends RecyclerView.Adapter<OwnerDashboardAdapter.MyViewHolder>
{

    List<MedicineModel> medicinelist;
    Context context;

    public OwnerDashboardAdapter(List<MedicineModel> medicinelist, Context context) {
        this.medicinelist = medicinelist;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return medicinelist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       DashboardRecycleItemLayoutBinding binding = DashboardRecycleItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false);
       return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerDashboardAdapter.MyViewHolder holder, int position) {
        final MedicineModel singleMedicineModel = medicinelist.get(position);

        Bitmap imgBit= UtilsMethod.imgConvertFromByteArrayToBitmap(singleMedicineModel.getMedicineImage());
        holder.binding.dashMedimg.setImageBitmap(imgBit);

        holder.binding.dashMedName.setText(singleMedicineModel.getMedicineName());
        holder.binding.dashMedprice.setText(context.getResources().getString(R.string.rs_symbol)+""+String.valueOf(singleMedicineModel.getMedicinePrice()));
        holder.binding.dashMedType.setText(singleMedicineModel.getMedicineType());
        holder.binding.dashMedstripSize.setText(String.valueOf(singleMedicineModel.getMedStripSize()));

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        DashboardRecycleItemLayoutBinding binding;

        public MyViewHolder(@NonNull DashboardRecycleItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
