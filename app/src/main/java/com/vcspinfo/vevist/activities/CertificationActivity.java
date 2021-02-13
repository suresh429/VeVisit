package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityCertificationBinding;

import java.util.Objects;

public class CertificationActivity extends AppCompatActivity {

    ActivityCertificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCertificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Certification");


        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(CertificationActivity.this,ActivitiesActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        });
        binding.btnPrevious.setOnClickListener(v -> {
            Intent intent = new Intent(CertificationActivity.this,ZeroToleranceActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
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