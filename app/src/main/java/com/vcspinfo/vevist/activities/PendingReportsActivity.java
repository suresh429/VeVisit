package com.vcspinfo.vevist.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.vcspinfo.vevist.adapter.PendingReportsListAdapter;
import com.vcspinfo.vevist.adapter.ReportsListAdapter;
import com.vcspinfo.vevist.databinding.ActivityPendingReportsBinding;
import com.vcspinfo.vevist.databinding.ActivityReportsBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.VisitPendingReportModel;
import com.vcspinfo.vevist.models.VisitReportModel;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingReportsActivity extends AppCompatActivity {
    ActivityPendingReportsBinding binding;
    UserSessionManager userSessionManager;

    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPendingReportsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pending Reports");
        userSessionManager = new UserSessionManager(this);
        networkCall();

    }

    private void networkCall() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<VisitPendingReportModel> call = RetrofitService.createService(ApiInterface.class, this).getPendingVisitReports(userSessionManager.getUserDetails().get("token"));
        call.enqueue(new Callback<VisitPendingReportModel>() {
            @Override
            public void onResponse(@NonNull Call<VisitPendingReportModel> call, @NonNull Response<VisitPendingReportModel> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    VisitPendingReportModel baseResponse = response.body();
                    assert baseResponse != null;
                    List<VisitPendingReportModel.DataBean> visitReportsBeanList = Collections.singletonList(baseResponse.getData());
                    arrayList.clear();

                    for (VisitPendingReportModel.DataBean dataBean : visitReportsBeanList) {
                        arrayList.addAll(dataBean.getPendings());
                    }
                    binding.recyclerReports.addItemDecoration(new DividerItemDecoration(PendingReportsActivity.this, DividerItemDecoration.VERTICAL));
                    PendingReportsListAdapter reportsListAdapter = new PendingReportsListAdapter(visitReportsBeanList, arrayList, PendingReportsActivity.this);
                    binding.recyclerReports.setAdapter(reportsListAdapter);
                    reportsListAdapter.notifyDataSetChanged();
                    binding.txtError.setVisibility(View.GONE);


                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<VisitPendingReportModel> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(PendingReportsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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