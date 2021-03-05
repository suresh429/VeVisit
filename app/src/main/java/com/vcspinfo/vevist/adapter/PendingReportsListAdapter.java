package com.vcspinfo.vevist.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vcspinfo.vevist.activities.CSPDetailsActivity;
import com.vcspinfo.vevist.activities.PendingReportsActivity;
import com.vcspinfo.vevist.databinding.PendingReportItemBinding;
import com.vcspinfo.vevist.databinding.ReportItemBinding;
import com.vcspinfo.vevist.models.VisitPendingReportModel;
import com.vcspinfo.vevist.models.VisitReportModel;

import java.util.ArrayList;
import java.util.List;


public class PendingReportsListAdapter extends RecyclerView.Adapter<PendingReportsListAdapter.ViewHolder> {

    List<VisitPendingReportModel.DataBean> modelList;
    ArrayList<String> arrayList;
    Context context;

    public PendingReportsListAdapter(List<VisitPendingReportModel.DataBean> modelList, ArrayList<String> arrayList, Context context) {
        this.modelList = modelList;
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public PendingReportsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(PendingReportItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PendingReportsListAdapter.ViewHolder holder, int position) {


        holder.rowItemBinding.txtCspCode.setText("CSP Code : " + arrayList.get(position));
        holder.rowItemBinding.imageCspcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CSPDetailsActivity.class);
                intent.putExtra("cspCode",arrayList.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
        PendingReportItemBinding rowItemBinding;

        public ViewHolder(@NonNull PendingReportItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}
