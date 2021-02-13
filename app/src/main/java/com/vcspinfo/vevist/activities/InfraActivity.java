package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityCSPDetailsBinding;
import com.vcspinfo.vevist.databinding.ActivityInfraBinding;

import java.util.Objects;

public class InfraActivity extends AppCompatActivity {
 ActivityInfraBinding binding;
 String cspCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Infra");

        if (getIntent() != null){
            cspCode = getIntent().getStringExtra("csp_code");
        }

        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(InfraActivity.this,DocumentationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        });
        binding.btnPrevious.setOnClickListener(v -> {
            //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
            Intent intent = new Intent(InfraActivity.this,CSPDetailsActivity.class);
            intent.putExtra("csp_code",cspCode);
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