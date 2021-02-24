package com.vcspinfo.vevist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityDocumentationBinding;
import com.vcspinfo.vevist.databinding.ActivityInfraBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;

import java.util.Calendar;
import java.util.Objects;

public class DocumentationActivity extends AppCompatActivity {

    ActivityDocumentationBinding binding;
    UserSessionManager userSessionManager;
    SharedPreferences mSharedPref;
    String cspCode, date_agreement_211 = "0000-00-00", date_pvr_217 = "0000-00-00";
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
    String question_122;
    String question_123;
    String question_124;
    String question_125;
    String question_126;

    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDocumentationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Documentation");

        mSharedPref = getSharedPreferences("VE_VISIT_DOCUMENTATION", MODE_PRIVATE);

        userSessionManager = new UserSessionManager(this);

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
                    binding.radioGroupQuestion26.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion21.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion22.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion23.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion24.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion25.getCheckedRadioButtonId() != -1
            ) {
                userSessionManager.createDocumentation(
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
                        date_agreement_211,
                        question_112,
                        question_113,
                        question_114,
                        question_115,
                        question_116,
                        date_pvr_217,
                        question_118,
                        question_119,
                        question_120,
                        question_121,
                        question_122,
                        question_123,
                        question_124,
                        question_125,
                        question_126

                );
                Intent intent = new Intent(DocumentationActivity.this, ZeroToleranceActivity.class);
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
                if (question_111.equalsIgnoreCase("yes")) {
                    binding.dateAgreementValidLayout.setVisibility(View.VISIBLE);
                    binding.dateAgreementValid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Get Current Date
                            final Calendar c = Calendar.getInstance();
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH);
                            mDay = c.get(Calendar.DAY_OF_MONTH);


                            DatePickerDialog datePickerDialog = new DatePickerDialog(DocumentationActivity.this,
                                    new DatePickerDialog.OnDateSetListener() {

                                        @Override
                                        public void onDateSet(DatePicker view, int year,
                                                              int monthOfYear, int dayOfMonth) {

                                            binding.dateAgreementValid.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                                        }
                                    }, mYear, mMonth, mDay);
                            datePickerDialog.show();

                            date_agreement_211 = binding.dateAgreementValid.getText().toString();

                        }

                    });

                } else {
                    binding.dateAgreementValidLayout.setVisibility(View.GONE);
                    date_agreement_211 = "0000-00-00";
                }
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
                if (question_117.equalsIgnoreCase("yes")) {
                    binding.datePvrValidLayout.setVisibility(View.VISIBLE);
                    binding.datePvrValid.setOnClickListener(v -> {
                        final Calendar c = Calendar.getInstance();
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);


                         DatePickerDialog datePickerDialog = new DatePickerDialog(DocumentationActivity.this,
                                (view, year, monthOfYear, dayOfMonth) -> binding.datePvrValid.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth), mYear, mMonth, mDay);
                        datePickerDialog.show();
                        date_pvr_217 = binding.datePvrValid.getText().toString();
                    });

                } else {
                    binding.datePvrValidLayout.setVisibility(View.GONE);
                    date_pvr_217 = "0000-00-00";
                }
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
        binding.radioGroupQuestion22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_122 = radioButton.getText().toString();
                editor.putInt("rg22", binding.radioGroupQuestion22.indexOfChild(findViewById(binding.radioGroupQuestion22.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_123 = radioButton.getText().toString();
                editor.putInt("rg23", binding.radioGroupQuestion23.indexOfChild(findViewById(binding.radioGroupQuestion23.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_124 = radioButton.getText().toString();
                editor.putInt("rg24", binding.radioGroupQuestion24.indexOfChild(findViewById(binding.radioGroupQuestion24.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_125 = radioButton.getText().toString();
                editor.putInt("rg25", binding.radioGroupQuestion25.indexOfChild(findViewById(binding.radioGroupQuestion25.getCheckedRadioButtonId())));
                editor.apply();
            }
        });
        binding.radioGroupQuestion26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_126 = radioButton.getText().toString();
                editor.putInt("rg26", binding.radioGroupQuestion26.indexOfChild(findViewById(binding.radioGroupQuestion26.getCheckedRadioButtonId())));
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
        int i22 = mSharedPref.getInt("rg22", -1);
        if (i22 >= 0) {
            ((RadioButton) binding.radioGroupQuestion22.getChildAt(i22)).setChecked(true);
        }
        int i23 = mSharedPref.getInt("rg23", -1);
        if (i23 >= 0) {
            ((RadioButton) binding.radioGroupQuestion23.getChildAt(i23)).setChecked(true);
        }
        int i24 = mSharedPref.getInt("rg24", -1);
        if (i24 >= 0) {
            ((RadioButton) binding.radioGroupQuestion24.getChildAt(i24)).setChecked(true);
        }
        int i25 = mSharedPref.getInt("rg25", -1);
        if (i25 >= 0) {
            ((RadioButton) binding.radioGroupQuestion25.getChildAt(i25)).setChecked(true);
        }
        int i26 = mSharedPref.getInt("rg26", -1);
        if (i26 >= 0) {
            ((RadioButton) binding.radioGroupQuestion26.getChildAt(i26)).setChecked(true);
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