package com.vcspinfo.vevist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.adapter.DashBoardListAdapter;
import com.vcspinfo.vevist.adapter.ReportsListAdapter;
import com.vcspinfo.vevist.databinding.ActivityDashboardBinding;
import com.vcspinfo.vevist.databinding.ActivityReportsBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.DashBoardModel;
import com.vcspinfo.vevist.models.DashboardResponse;
import com.vcspinfo.vevist.models.VisitReportModel;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportsActivity extends AppCompatActivity {
    ActivityReportsBinding binding;
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReportsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Reports");
        userSessionManager = new UserSessionManager(this);
        networkCall();

    }

    private void networkCall() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<VisitReportModel> call = RetrofitService.createService(ApiInterface.class, this).getVisitReports(userSessionManager.getUserDetails().get("token"));
        call.enqueue(new Callback<VisitReportModel>() {
            @Override
            public void onResponse(@NonNull Call<VisitReportModel> call, @NonNull Response<VisitReportModel> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    VisitReportModel baseResponse = response.body();
                    List<VisitReportModel.DataBean.VisitReportsBean> visitReportsBeanList = baseResponse.getData().getVisitReports();

                    if (visitReportsBeanList.size() > 0) {

                        binding.recyclerReports.addItemDecoration(new DividerItemDecoration(ReportsActivity.this, DividerItemDecoration.VERTICAL));
                        ReportsListAdapter reportsListAdapter = new ReportsListAdapter(visitReportsBeanList, ReportsActivity.this);
                        binding.recyclerReports.setAdapter(reportsListAdapter);
                        reportsListAdapter.notifyDataSetChanged();
                        binding.txtError.setVisibility(View.GONE);


                    } else {
                        binding.txtError.setVisibility(View.VISIBLE);
                    }

                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<VisitReportModel> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(ReportsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}