package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityDocumentationBinding;
import com.vcspinfo.vevist.databinding.ActivityZeroToleranceBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;

import java.util.Objects;

public class ZeroToleranceActivity extends AppCompatActivity {

    ActivityZeroToleranceBinding binding;
    UserSessionManager userSessionManager;
    SharedPreferences mSharedPref;
    SharedPreferences.Editor editor;
    String cspCode;
    Bundle bundle;
    String question_101;
    String question_102;
    String question_103;
    String question_104;
    String question_105;
    String question_106;
    String question_107;
    String question_108;
    String question_109;
    String question_110;
    String question_111;
    String question_112;
    String question_113;
    String question_114;
    String question_115;
    String question_116;
    String question_117;
    String question_118;
    String question_119;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityZeroToleranceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Zero Tolerance");

        mSharedPref = getSharedPreferences("VE_VISIT_ZERO", MODE_PRIVATE);
        editor = mSharedPref.edit();
        userSessionManager = new UserSessionManager(this);

        setData();
        getData();
        binding.btnNext.setOnClickListener(v -> {

            question_117= Objects.requireNonNull(binding.question17.getText()).toString();
            question_118= Objects.requireNonNull(binding.question18.getText()).toString();
            question_119= Objects.requireNonNull(binding.question19.getText()).toString();



            if (binding.radioGroupQuestion1.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion2.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion3.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion4.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion5.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion6.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion7.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion8.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion9.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion10.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion11.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion12.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion13.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion14.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion15.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion16.getCheckedRadioButtonId() != -1 &&
                    !question_117.isEmpty() && !question_118.isEmpty() && !question_119.isEmpty()

            ) {
                userSessionManager.createZeroTolerance(
                        question_101,
                        question_102,
                        question_103,
                        question_104,
                        question_105,
                        question_106,
                        question_107,
                        question_108,
                        question_109,
                        question_110,
                        question_111,
                        question_112,
                        question_113,
                        question_114,
                        question_115,
                        question_116,
                        question_117,
                        question_118,
                        question_119


                );

                editor.putString("et17", question_117);
                editor.putString("et18", question_118);
                editor.putString("et19", question_119);
                editor.apply();

                Intent intent = new Intent(ZeroToleranceActivity.this, CertificationActivity.class);
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
        binding.radioGroupQuestion6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_106 = radioButton.getText().toString();
                editor.putInt("rg6", binding.radioGroupQuestion6.indexOfChild(findViewById(binding.radioGroupQuestion6.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_107 = radioButton.getText().toString();
                editor.putInt("rg7", binding.radioGroupQuestion7.indexOfChild(findViewById(binding.radioGroupQuestion7.getCheckedRadioButtonId())));
                editor.apply();
            }
        });

        binding.radioGroupQuestion8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_108 = radioButton.getText().toString();
                editor.putInt("rg8", binding.radioGroupQuestion8.indexOfChild(findViewById(binding.radioGroupQuestion8.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_109 = radioButton.getText().toString();
                editor.putInt("rg9", binding.radioGroupQuestion9.indexOfChild(findViewById(binding.radioGroupQuestion9.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_110 = radioButton.getText().toString();
                editor.putInt("rg10", binding.radioGroupQuestion10.indexOfChild(findViewById(binding.radioGroupQuestion10.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_111 = radioButton.getText().toString();
                editor.putInt("rg11", binding.radioGroupQuestion11.indexOfChild(findViewById(binding.radioGroupQuestion11.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_112 = radioButton.getText().toString();
                editor.putInt("rg12", binding.radioGroupQuestion12.indexOfChild(findViewById(binding.radioGroupQuestion12.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_113 = radioButton.getText().toString();
                editor.putInt("rg13", binding.radioGroupQuestion13.indexOfChild(findViewById(binding.radioGroupQuestion13.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_114 = radioButton.getText().toString();
                editor.putInt("rg14", binding.radioGroupQuestion14.indexOfChild(findViewById(binding.radioGroupQuestion14.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_115 = radioButton.getText().toString();
                editor.putInt("rg15", binding.radioGroupQuestion15.indexOfChild(findViewById(binding.radioGroupQuestion15.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_116 = radioButton.getText().toString();
                editor.putInt("rg16", binding.radioGroupQuestion16.indexOfChild(findViewById(binding.radioGroupQuestion16.getCheckedRadioButtonId())));
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
        int i6 = mSharedPref.getInt("rg6", -1);
        if (i6 >= 0) {
            ((RadioButton) binding.radioGroupQuestion6.getChildAt(i6)).setChecked(true);
        }
        int i7 = mSharedPref.getInt("rg7", -1);
        if (i7 >= 0) {
            ((RadioButton) binding.radioGroupQuestion7.getChildAt(i7)).setChecked(true);
        }
        int i8 = mSharedPref.getInt("rg8", -1);
        if (i8 >= 0) {
            ((RadioButton) binding.radioGroupQuestion8.getChildAt(i8)).setChecked(true);
        }
        int i9 = mSharedPref.getInt("rg9", -1);
        if (i9 >= 0) {
            ((RadioButton) binding.radioGroupQuestion9.getChildAt(i9)).setChecked(true);
        }
        int i10 = mSharedPref.getInt("rg10", -1);
        if (i10 >= 0) {
            ((RadioButton) binding.radioGroupQuestion10.getChildAt(i10)).setChecked(true);
        }
        int i11 = mSharedPref.getInt("rg11", -1);
        if (i11 >= 0) {
            ((RadioButton) binding.radioGroupQuestion11.getChildAt(i11)).setChecked(true);
        }
        int i12 = mSharedPref.getInt("rg12", -1);
        if (i12 >= 0) {
            ((RadioButton) binding.radioGroupQuestion12.getChildAt(i12)).setChecked(true);
        }
        int i13 = mSharedPref.getInt("rg13", -1);
        if (i13 >= 0) {
            ((RadioButton) binding.radioGroupQuestion13.getChildAt(i13)).setChecked(true);
        }
        int i14 = mSharedPref.getInt("rg14", -1);
        if (i14 >= 0) {
            ((RadioButton) binding.radioGroupQuestion14.getChildAt(i14)).setChecked(true);
        }
        int i15 = mSharedPref.getInt("rg15", -1);
        if (i15 >= 0) {
            ((RadioButton) binding.radioGroupQuestion15.getChildAt(i15)).setChecked(true);
        }
        int i16 = mSharedPref.getInt("rg16", -1);
        if (i16 >= 0) {
            ((RadioButton) binding.radioGroupQuestion16.getChildAt(i16)).setChecked(true);
        }


        question_117=mSharedPref.getString("et17","");
        binding.question17.setText(question_117);

        question_118=mSharedPref.getString("et18","");
        binding.question18.setText(question_118);

        question_119=mSharedPref.getString("et19","");
        binding.question19.setText(question_119);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}