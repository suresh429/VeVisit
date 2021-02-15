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
import com.vcspinfo.vevist.databinding.ActivityActivitiesBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;

import java.util.Objects;

public class ActivitiesActivity extends AppCompatActivity {

    ActivityActivitiesBinding binding;
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
    String comments_head;
    String question_114;
    String comments_branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActivitiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Activities");

        mSharedPref = getSharedPreferences("VE_VISIT_ACTIVITIES", MODE_PRIVATE);
        editor = mSharedPref.edit();
        userSessionManager = new UserSessionManager(this);

        setData();
        getData();
        binding.btnNext.setOnClickListener(v -> {

            question_101 = Objects.requireNonNull(binding.question1.getText()).toString();
            question_102 = Objects.requireNonNull(binding.question2.getText()).toString();
            question_103 = Objects.requireNonNull(binding.question3.getText()).toString();
            question_104 = Objects.requireNonNull(binding.question4.getText()).toString();
            question_105 = Objects.requireNonNull(binding.question5.getText()).toString();
            question_106 = Objects.requireNonNull(binding.question6.getText()).toString();
            question_107 = Objects.requireNonNull(binding.question7.getText()).toString();
            question_108 = Objects.requireNonNull(binding.question8.getText()).toString();
            question_109 = Objects.requireNonNull(binding.question9.getText()).toString();
            question_110 = Objects.requireNonNull(binding.question10.getText()).toString();
            question_111 = Objects.requireNonNull(binding.question11.getText()).toString();
            question_112 = Objects.requireNonNull(binding.question12.getText()).toString();
            comments_branch = Objects.requireNonNull(binding.commentsBranch.getText()).toString();
            comments_head = Objects.requireNonNull(binding.commentsHead.getText()).toString();


            if (!question_101.isEmpty() && !question_102.isEmpty() && !question_103.isEmpty() &&
                            !question_104.isEmpty() && !question_105.isEmpty() && !question_106.isEmpty() &&
                            !question_107.isEmpty() && !question_108.isEmpty() && !question_109.isEmpty() &&
                            !question_110.isEmpty() && !question_111.isEmpty() && !question_112.isEmpty() &&
                            binding.radioGroupQuestion13.getCheckedRadioButtonId() != -1 &&
                            binding.radioGroupQuestion14.getCheckedRadioButtonId() != -1


            ) {
                userSessionManager.createActivities(
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
                        comments_head,
                        question_114,
                        comments_branch


                        );

                editor.putString("et1", question_101);
                editor.putString("et2", question_102);
                editor.putString("et3", question_103);
                editor.putString("et4", question_104);
                editor.putString("et5", question_105);
                editor.putString("et6", question_106);
                editor.putString("et7", question_107);
                editor.putString("et8", question_108);
                editor.putString("et9", question_109);
                editor.putString("et10", question_110);
                editor.putString("et11", question_111);
                editor.putString("et12", question_112);
                editor.putString("com_head", comments_head);
                editor.putString("com_branch", comments_branch);

                editor.apply();

               /* Intent intent = new Intent(ActivitiesActivity.this, CertificationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/

            } else {
                Toast.makeText(this, "All Details are Mandatory", Toast.LENGTH_SHORT).show();
            }


        });
        binding.btnPrevious.setOnClickListener(v -> {

            onBackPressed();

        });
    }

    private void setData() {


        binding.radioGroupQuestion13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_113 = radioButton.getText().toString();
                editor.putInt("rg13", binding.radioGroupQuestion13.indexOfChild(findViewById(binding.radioGroupQuestion13.getCheckedRadioButtonId())));
                editor.apply();

                if (question_113.equalsIgnoreCase("Yes")){
                    binding.commentsHeadLayout.setVisibility(View.VISIBLE);
                }else {
                    binding.commentsHeadLayout.setVisibility(View.GONE);
                }
            }
        });
        binding.radioGroupQuestion14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_114 = radioButton.getText().toString();
                editor.putInt("rg14", binding.radioGroupQuestion14.indexOfChild(findViewById(binding.radioGroupQuestion14.getCheckedRadioButtonId())));
                editor.apply();

                if (question_114.equalsIgnoreCase("Yes")){
                    binding.commentsBranchLayout.setVisibility(View.VISIBLE);
                }else {
                    binding.commentsBranchLayout.setVisibility(View.GONE);
                }
            }
        });

    }

    public void getData() {


        question_101 = mSharedPref.getString("et1", "");
        binding.question1.setText(question_101);

        question_102 = mSharedPref.getString("et2", "");
        binding.question2.setText(question_102);

        question_103 = mSharedPref.getString("et3", "");
        binding.question3.setText(question_103);

        question_104 = mSharedPref.getString("et4", "");
        binding.question4.setText(question_104);

        question_105 = mSharedPref.getString("et5", "");
        binding.question5.setText(question_105);

        question_106 = mSharedPref.getString("et6", "");
        binding.question6.setText(question_106);

        question_107 = mSharedPref.getString("et7", "");
        binding.question7.setText(question_107);

        question_108 = mSharedPref.getString("et8", "");
        binding.question8.setText(question_108);

        question_109 = mSharedPref.getString("et9", "");
        binding.question9.setText(question_109);

        question_110 = mSharedPref.getString("et10", "");
        binding.question10.setText(question_110);

        question_111 = mSharedPref.getString("et11", "");
        binding.question11.setText(question_111);

        question_112 = mSharedPref.getString("et12", "");
        binding.question12.setText(question_112);

        int i13 = mSharedPref.getInt("rg13", -1);
        if (i13 >= 0) {
            ((RadioButton) binding.radioGroupQuestion13.getChildAt(i13)).setChecked(true);
        }

        comments_head = mSharedPref.getString("com_head", "");
        binding.commentsHead.setText(comments_head);

        int i14 = mSharedPref.getInt("rg14", -1);
        if (i14 >= 0) {
            ((RadioButton) binding.radioGroupQuestion14.getChildAt(i14)).setChecked(true);
        }

        comments_branch = mSharedPref.getString("com_branch", "");
        binding.commentsBranch.setText(comments_branch);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}