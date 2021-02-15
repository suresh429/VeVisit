package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityCertificationBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;

import java.util.Objects;

public class CertificationActivity extends AppCompatActivity {

    ActivityCertificationBinding binding;
    UserSessionManager userSessionManager;
    SharedPreferences mSharedPref;
    SharedPreferences.Editor editor;
    String question_101;
    String question_102;
    String question_103;
    String question_104;
    String question_105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCertificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Certification");


        mSharedPref = getSharedPreferences("VE_VISIT_CERTIFICATION", MODE_PRIVATE);

        userSessionManager = new UserSessionManager(this);

        setData();
        getData();
        binding.btnNext.setOnClickListener(v -> {


            if (binding.radioGroupQuestion1.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion2.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion3.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion4.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion5.getCheckedRadioButtonId() != -1


            ) {
                userSessionManager.createCertifications(
                        question_101,
                        question_102,
                        question_103,
                        question_104,
                        question_105


                );


                Intent intent = new Intent(CertificationActivity.this, ActivitiesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            } else {
                Toast.makeText(this, "All Details are Mandatory", Toast.LENGTH_SHORT).show();
            }


        });
        binding.btnPrevious.setOnClickListener(v -> {

            onBackPressed();

        });
    }

    private void setData() {


        editor = mSharedPref.edit();
        binding.radioGroupQuestion1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_101 = radioButton.getText().toString();
                editor.putInt("rg1", binding.radioGroupQuestion1.indexOfChild(findViewById(binding.radioGroupQuestion1.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_102 = radioButton.getText().toString();
                editor.putInt("rg2", binding.radioGroupQuestion2.indexOfChild(findViewById(binding.radioGroupQuestion2.getCheckedRadioButtonId())));
                editor.apply();

            }
        });
        binding.radioGroupQuestion3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_103 = radioButton.getText().toString();
                editor.putInt("rg3", binding.radioGroupQuestion3.indexOfChild(findViewById(binding.radioGroupQuestion3.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_104 = radioButton.getText().toString();
                editor.putInt("rg4", binding.radioGroupQuestion4.indexOfChild(findViewById(binding.radioGroupQuestion4.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_105 = radioButton.getText().toString();
                editor.putInt("rg5", binding.radioGroupQuestion5.indexOfChild(findViewById(binding.radioGroupQuestion5.getCheckedRadioButtonId())));
                editor.apply();
            }
        });


    }

    public void getData() {
        int i1 = mSharedPref.getInt("rg1", -1);
        if (i1 >= 0) {
            ((RadioButton) binding.radioGroupQuestion1.getChildAt(i1)).setChecked(true);
        }
        int i2 = mSharedPref.getInt("rg2", -1);
        if (i2 >= 0) {
            ((RadioButton) binding.radioGroupQuestion2.getChildAt(i2)).setChecked(true);
        }
        int i3 = mSharedPref.getInt("rg3", -1);
        if (i3 >= 0) {
            ((RadioButton) binding.radioGroupQuestion3.getChildAt(i3)).setChecked(true);
        }
        int i4 = mSharedPref.getInt("rg4", -1);
        if (i4 >= 0) {
            ((RadioButton) binding.radioGroupQuestion4.getChildAt(i4)).setChecked(true);
        }
        int i5 = mSharedPref.getInt("rg5", -1);
        if (i5 >= 0) {
            ((RadioButton) binding.radioGroupQuestion5.getChildAt(i5)).setChecked(true);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}