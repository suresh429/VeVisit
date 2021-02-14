package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityDocumentationBinding;
import com.vcspinfo.vevist.databinding.ActivityInfraBinding;

import java.util.Objects;

public class DocumentationActivity extends AppCompatActivity {
  ActivityDocumentationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDocumentationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Documentation");

        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(DocumentationActivity.this,ZeroToleranceActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        });
        binding.btnPrevious.setOnClickListener(v -> {
           /* Intent intent = new Intent(DocumentationActivity.this,InfraActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
            onBackPressed();

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