package com.vcspinfo.vevist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.vcspinfo.vevist.databinding.DashboardListItemBinding;
import com.vcspinfo.vevist.databinding.ReportItemBinding;
import com.vcspinfo.vevist.models.DashBoardModel;
import com.vcspinfo.vevist.models.VisitReportModel;

import java.util.List;


public class ReportsListAdapter extends RecyclerView.Adapter<ReportsListAdapter.ViewHolder> {

    List<VisitReportModel.DataBean.VisitReportsBean> modelList;
    Context context;

    public ReportsListAdapter(List<VisitReportModel.DataBean.VisitReportsBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @NonNull
    @Override
    public ReportsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ReportItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReportsListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtDate.setText("Date of Visit : "+modelList.get(position).getDateOfVisit());

        holder.rowItemBinding.txtCspCode.setText("CSP Code : "+modelList.get(position).getCspCode());
        holder.rowItemBinding.txtStatus.setText("Status : "+modelList.get(position).isStatus());



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
        ReportItemBinding rowItemBinding;

        public ViewHolder(@NonNull ReportItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}
