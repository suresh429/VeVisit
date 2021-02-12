package com.vcspinfo.vevist.activities;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vcspinfo.vevist.databinding.ActivityLoginBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.ApiError;
import com.vcspinfo.vevist.models.LoginResonse;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    ActivityLoginBinding binding;

    String username, password;
    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userSessionManager = new UserSessionManager(this);


        binding.btnSubmit.setOnClickListener(v -> {

            username = Objects.requireNonNull(binding.etUsername.getText()).toString().trim();
            password = Objects.requireNonNull(binding.etPassword.getText()).toString().trim();

            if (username.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Enter User Name", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();

            } else {
                networkCall();
            }

        });


    }

    private void networkCall() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<LoginResonse> call = RetrofitService.createService(ApiInterface.class, this).login(username, password);
        call.enqueue(new Callback<LoginResonse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResonse> call, @NonNull Response<LoginResonse> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    LoginResonse baseResponse = response.body();
                    assert baseResponse != null;
                    if (baseResponse.getStatus() == 200) {

                        // session manager
                        userSessionManager.createLogin(baseResponse.getData().getUser().getUsername(),
                                baseResponse.getData().getUser().getName(),
                                baseResponse.getData().getUser().getMobile(),
                                baseResponse.getData().getUser().getState(),
                                baseResponse.getData().getUser().getRole(),
                                baseResponse.getData().getUser().getAuthenticationToken());


                        Intent intentLogin = new Intent(LoginActivity.this, DashboardActivity.class);
                        intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentLogin);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                    }

                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);
                    ApiError errorResponse = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
                    Toast.makeText(LoginActivity.this, errorResponse.getError(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResonse> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }
}