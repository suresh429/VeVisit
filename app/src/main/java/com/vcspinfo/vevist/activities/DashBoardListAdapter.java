package com.vcspinfo.vevist.activities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.DashboardListItemBinding;
import com.vcspinfo.vevist.models.DashBoardModel;

import java.util.List;


public class DashBoardListAdapter extends RecyclerView.Adapter<DashBoardListAdapter.ViewHolder> {

    List<DashBoardModel> modelList;
    Context context;

    public DashBoardListAdapter(List<DashBoardModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @NonNull
    @Override
    public DashBoardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DashboardListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DashBoardListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtDasBoardTitle.setText(modelList.get(position).getDashBoardTitle());

        holder.rowItemBinding.txtDasBoardCount.setText(modelList.get(position).getCount());
        holder.rowItemBinding.txtDasBoardCount.setTextColor(ContextCompat.getColor(context, modelList.get(position).getColor()));


        holder.rowItemBinding.image.setImageResource(modelList.get(position).getIcon());
        holder.rowItemBinding.image.setColorFilter(ContextCompat.getColor(context,modelList.get(position).getColor()), android.graphics.PorterDuff.Mode.SRC_IN);




    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        DashboardListItemBinding rowItemBinding;

        public ViewHolder(@NonNull DashboardListItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}
