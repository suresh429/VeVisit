package com.vcspinfo.vevist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.vcspinfo.vevist.BuildConfig;
import com.vcspinfo.vevist.R;

import com.vcspinfo.vevist.adapter.DashBoardListAdapter;
import com.vcspinfo.vevist.databinding.ActivityDashboardBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.DashBoardModel;
import com.vcspinfo.vevist.models.DashboardResponse;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private static final String TAG = "DashboardActivity";
    ActivityDashboardBinding binding;
    UserSessionManager userSessionManager;
    private List<DashBoardModel> dashBoardModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("DashBoard");

        userSessionManager = new UserSessionManager(this);

        dashBoardModelList = new ArrayList<>();
        networkCall();

    }

    private void networkCall() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<DashboardResponse> call = RetrofitService.createService(ApiInterface.class, this).getDashboard(userSessionManager.getUserDetails().get("token"));
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(@NonNull Call<DashboardResponse> call, @NonNull Response<DashboardResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    DashboardResponse baseResponse = response.body();
                    assert baseResponse != null;
                    if (baseResponse.getStatus() == 200) {

                        dashBoardModelList.clear();

                        dashBoardModelList.add(new DashBoardModel("YOU'RE LOGGED IN AS", baseResponse.getDashboard().getUsername(), R.drawable.ic_user,R.color.blue));
                        dashBoardModelList.add(new DashBoardModel("TODAY VISITS", String.valueOf(baseResponse.getDashboard().getToday()), R.drawable.ic_car,R.color.orange));
                        dashBoardModelList.add(new DashBoardModel("MONTH VISITS", String.valueOf(baseResponse.getDashboard().getMonth()), R.drawable.ic_car,R.color.green));
                        dashBoardModelList.add(new DashBoardModel("TOTAL VISITS", String.valueOf(baseResponse.getDashboard().getTotal()), R.drawable.ic_bus,R.color.red));
                        dashBoardModelList.add(new DashBoardModel("TOTAL 1A90 CSPs", String.valueOf(baseResponse.getDashboard().getCsp1a()), R.drawable.ic_group,R.color.blue));
                        dashBoardModelList.add(new DashBoardModel("TOTAL 3A43 CSPs", String.valueOf(baseResponse.getDashboard().getCsp3a()), R.drawable.ic_group,R.color.red));
                        dashBoardModelList.add(new DashBoardModel("TOTAL 1998 CSPs", String.valueOf(baseResponse.getDashboard().getCsp1998()), R.drawable.ic_group,R.color.orange));
                        dashBoardModelList.add(new DashBoardModel("TOTAL PGB CSPs", String.valueOf(baseResponse.getDashboard().getCspPgb()), R.drawable.ic_group,R.color.green));


                        DashBoardListAdapter dashBoardListAdapter = new DashBoardListAdapter(dashBoardModelList, DashboardActivity.this);
                        binding.recyclerDashBoard.setAdapter(dashBoardListAdapter);
                        dashBoardListAdapter.notifyDataSetChanged();


                    } else {
                        Toast.makeText(DashboardActivity.this, "No data Found", Toast.LENGTH_SHORT).show();
                    }

                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<DashboardResponse> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(DashboardActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.newCSP:

                Intent intent1 = new Intent(DashboardActivity.this, CSPDetailsActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);

                return true;

            case R.id.reports:

                Intent intent2 = new Intent(DashboardActivity.this, ReportsActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);

                return true;

            case R.id.logout:

                userSessionManager.clearSession();
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}