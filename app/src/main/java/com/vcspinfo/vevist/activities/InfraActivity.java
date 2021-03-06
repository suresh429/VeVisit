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
import com.vcspinfo.vevist.databinding.ActivityCSPDetailsBinding;
import com.vcspinfo.vevist.databinding.ActivityInfraBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;

import java.util.Objects;

public class InfraActivity extends AppCompatActivity {
    ActivityInfraBinding binding;
    UserSessionManager userSessionManager;
    SharedPreferences mSharedPref;
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
    String question_120;
    String question_121;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Infra");

        mSharedPref = getSharedPreferences("VE_VISIT_INFRA", MODE_PRIVATE);

        userSessionManager = new UserSessionManager(this);

        bundle = new Bundle();
        if (getIntent() != null) {
            cspCode = getIntent().getStringExtra("csp_code");
        }


        setData();
        getData();
        binding.btnNext.setOnClickListener(v -> {

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
                    binding.radioGroupQuestion17.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion18.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion19.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion20.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion21.getCheckedRadioButtonId() != -1
            ) {
                userSessionManager.createInfra(cspCode,
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
                        question_119,
                        question_120,
                        question_121

                );
                Intent intent = new Intent(InfraActivity.this, DocumentationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            } else {
                Toast.makeText(this, "All Details are Mandatory", Toast.LENGTH_SHORT).show();
            }


        });
        binding.btnPrevious.setOnClickListener(v -> {
            //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
           /* Intent intent = new Intent(InfraActivity.this,CSPDetailsActivity.class);
            intent.putExtra("csp_code",cspCode);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
            onBackPressed();

        });
    }

    private void setData() {
        SharedPreferences.Editor editor = mSharedPref.edit();

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
        binding.radioGroupQuestion17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_117 = radioButton.getText().toString();
                editor.putInt("rg17", binding.radioGroupQuestion17.indexOfChild(findViewById(binding.radioGroupQuestion17.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_118 = radioButton.getText().toString();
                editor.putInt("rg18", binding.radioGroupQuestion18.indexOfChild(findViewById(binding.radioGroupQuestion18.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_119 = radioButton.getText().toString();
                editor.putInt("rg19", binding.radioGroupQuestion19.indexOfChild(findViewById(binding.radioGroupQuestion19.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_120 = radioButton.getText().toString();
                editor.putInt("rg20", binding.radioGroupQuestion20.indexOfChild(findViewById(binding.radioGroupQuestion20.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_121 = radioButton.getText().toString();
                editor.putInt("rg21", binding.radioGroupQuestion21.indexOfChild(findViewById(binding.radioGroupQuestion21.getCheckedRadioButtonId())));
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
        int i17 = mSharedPref.getInt("rg17", -1);
        if (i17 >= 0) {
            ((RadioButton) binding.radioGroupQuestion17.getChildAt(i17)).setChecked(true);
        }
        int i18 = mSharedPref.getInt("rg18", -1);
        if (i18 >= 0) {
            ((RadioButton) binding.radioGroupQuestion18.getChildAt(i18)).setChecked(true);
        }
        int i19 = mSharedPref.getInt("rg19", -1);
        if (i19 >= 0) {
            ((RadioButton) binding.radioGroupQuestion19.getChildAt(i19)).setChecked(true);
        }
        int i20 = mSharedPref.getInt("rg20", -1);
        if (i20 >= 0) {
            ((RadioButton) binding.radioGroupQuestion20.getChildAt(i20)).setChecked(true);
        }
        int i21 = mSharedPref.getInt("rg21", -1);
        if (i21 >= 0) {
            ((RadioButton) binding.radioGroupQuestion21.getChildAt(i21)).setChecked(true);
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