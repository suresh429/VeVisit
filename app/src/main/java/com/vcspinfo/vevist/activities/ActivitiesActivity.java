package com.vcspinfo.vevist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityActivitiesBinding;
import com.vcspinfo.vevist.helper.FileCompressor;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.ApiError;
import com.vcspinfo.vevist.models.CreateVisitResponse;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivitiesActivity extends AppCompatActivity {
    private static final String TAG = "ActivitiesActivity";
    String currentPhotoPath;

    ActivityActivitiesBinding binding;
    UserSessionManager userSessionManager;

    SharedPreferences mSharedPref;
    SharedPreferences.Editor editor;
    String csp_code, token, latitude, longitude;
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
    String question_201;
    String question_202;
    String question_203;
    String question_204;
    String question_205;
    String question_206;
    String question_207;
    String question_208;
    String question_209;
    String question_210;
    String question_211;
    String question_212;
    String question_213;
    String question_214;
    String question_215;
    String question_216;
    String question_217;
    String question_218;
    String question_219;
    String question_220;
    String question_221;
    String question_222;
    String question_223;
    String question_224;
    String question_225;
    String question_301;
    String question_302;
    String question_303;
    String question_304;
    String question_305;
    String question_306;
    String question_307;
    String question_308;
    String question_309;
    String question_310;
    String question_311;
    String question_312;
    String question_313;
    String question_314;
    String question_315;
    String question_316;
    String question_317;
    String question_318;
    String question_319;
    String question_401;
    String question_402;
    String question_403;
    String question_404;
    String question_405;
    String question_501;
    String question_502;
    String question_503;
    String question_504;
    String question_505;
    String question_506;
    String question_507;
    String question_508;
    String question_509;
    String question_510;
    String question_511;
    String question_512;
    String question_513;
    String comments_head;
    String question_514;
    String comments_branch;

    public static final int REQUEST_TAKE_PHOTO = 1;

    File mPhotoFile;
    FileCompressor mCompressor;

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
        mCompressor = new FileCompressor(this);


        csp_code = userSessionManager.getInfra().get("csp_code");
        token = userSessionManager.getUserDetails().get("token");
        latitude = userSessionManager.getLocation().get("latitude");
        longitude = userSessionManager.getLocation().get("longitude");
        question_101 = userSessionManager.getInfra().get("question_101");
        question_102 = userSessionManager.getInfra().get("question_102");
        question_103 = userSessionManager.getInfra().get("question_103");
        question_104 = userSessionManager.getInfra().get("question_104");
        question_105 = userSessionManager.getInfra().get("question_105");
        question_106 = userSessionManager.getInfra().get("question_106");
        question_107 = userSessionManager.getInfra().get("question_107");
        question_108 = userSessionManager.getInfra().get("question_108");
        question_109 = userSessionManager.getInfra().get("question_109");
        question_110 = userSessionManager.getInfra().get("question_110");
        question_111 = userSessionManager.getInfra().get("question_111");
        question_112 = userSessionManager.getInfra().get("question_112");
        question_113 = userSessionManager.getInfra().get("question_113");
        question_114 = userSessionManager.getInfra().get("question_114");
        question_115 = userSessionManager.getInfra().get("question_115");
        question_116 = userSessionManager.getInfra().get("question_116");
        question_117 = userSessionManager.getInfra().get("question_117");
        question_118 = userSessionManager.getInfra().get("question_118");
        question_119 = userSessionManager.getInfra().get("question_119");
        question_120 = userSessionManager.getInfra().get("question_120");
        question_121 = userSessionManager.getInfra().get("question_121");

        question_201 = userSessionManager.getDocumentation().get("question_201");
        question_202 = userSessionManager.getDocumentation().get("question_202");
        question_203 = userSessionManager.getDocumentation().get("question_203");
        question_204 = userSessionManager.getDocumentation().get("question_204");
        question_205 = userSessionManager.getDocumentation().get("question_205");
        question_206 = userSessionManager.getDocumentation().get("question_206");
        question_207 = userSessionManager.getDocumentation().get("question_207");
        question_208 = userSessionManager.getDocumentation().get("question_208");
        question_209 = userSessionManager.getDocumentation().get("question_209");
        question_210 = userSessionManager.getDocumentation().get("question_210");
        question_211 = userSessionManager.getDocumentation().get("question_211");
        question_212 = userSessionManager.getDocumentation().get("question_212");
        question_213 = userSessionManager.getDocumentation().get("question_213");
        question_214 = userSessionManager.getDocumentation().get("question_214");
        question_215 = userSessionManager.getDocumentation().get("question_215");
        question_216 = userSessionManager.getDocumentation().get("question_216");
        question_217 = userSessionManager.getDocumentation().get("question_217");
        question_218 = userSessionManager.getDocumentation().get("question_218");
        question_219 = userSessionManager.getDocumentation().get("question_219");
        question_220 = userSessionManager.getDocumentation().get("question_220");
        question_221 = userSessionManager.getDocumentation().get("question_221");
        question_222 = userSessionManager.getDocumentation().get("question_222");
        question_223 = userSessionManager.getDocumentation().get("question_223");
        question_224 = userSessionManager.getDocumentation().get("question_224");
        question_225 = userSessionManager.getDocumentation().get("question_225");

        question_301 = userSessionManager.getZeroTolerance().get("question_301");
        question_302 = userSessionManager.getZeroTolerance().get("question_302");
        question_303 = userSessionManager.getZeroTolerance().get("question_303");
        question_304 = userSessionManager.getZeroTolerance().get("question_304");
        question_305 = userSessionManager.getZeroTolerance().get("question_305");
        question_306 = userSessionManager.getZeroTolerance().get("question_306");
        question_307 = userSessionManager.getZeroTolerance().get("question_307");
        question_308 = userSessionManager.getZeroTolerance().get("question_308");
        question_309 = userSessionManager.getZeroTolerance().get("question_309");
        question_310 = userSessionManager.getZeroTolerance().get("question_310");
        question_311 = userSessionManager.getZeroTolerance().get("question_311");
        question_312 = userSessionManager.getZeroTolerance().get("question_312");
        question_313 = userSessionManager.getZeroTolerance().get("question_313");
        question_314 = userSessionManager.getZeroTolerance().get("question_314");
        question_315 = userSessionManager.getZeroTolerance().get("question_315");
        question_316 = userSessionManager.getZeroTolerance().get("question_316");
        question_317 = userSessionManager.getZeroTolerance().get("question_317");
        question_318 = userSessionManager.getZeroTolerance().get("question_318");
        question_319 = userSessionManager.getZeroTolerance().get("question_319");

        question_401 = userSessionManager.getCertificates().get("question_401");
        question_402 = userSessionManager.getCertificates().get("question_402");
        question_403 = userSessionManager.getCertificates().get("question_403");
        question_404 = userSessionManager.getCertificates().get("question_404");
        question_405 = userSessionManager.getCertificates().get("question_405");


        setData();
        getData();


        binding.btnNext.setOnClickListener(v -> {

            question_501 = Objects.requireNonNull(binding.question1.getText()).toString();
            question_502 = Objects.requireNonNull(binding.question2.getText()).toString();
            question_503 = Objects.requireNonNull(binding.question3.getText()).toString();
            question_504 = Objects.requireNonNull(binding.question4.getText()).toString();
            question_505 = Objects.requireNonNull(binding.question5.getText()).toString();
            question_506 = Objects.requireNonNull(binding.question6.getText()).toString();
            question_507 = Objects.requireNonNull(binding.question7.getText()).toString();
            question_508 = Objects.requireNonNull(binding.question8.getText()).toString();
            question_509 = Objects.requireNonNull(binding.question9.getText()).toString();
            question_510 = Objects.requireNonNull(binding.question10.getText()).toString();
            question_511 = Objects.requireNonNull(binding.question11.getText()).toString();
            question_512 = Objects.requireNonNull(binding.question12.getText()).toString();
            comments_branch = Objects.requireNonNull(binding.commentsBranch.getText()).toString();
            comments_head = Objects.requireNonNull(binding.commentsHead.getText()).toString();


            if (!question_501.isEmpty() && !question_502.isEmpty() && !question_503.isEmpty() &&
                    !question_504.isEmpty() && !question_505.isEmpty() && !question_506.isEmpty() &&
                    !question_507.isEmpty() && !question_508.isEmpty() && !question_509.isEmpty() &&
                    !question_510.isEmpty() && !question_511.isEmpty() && !question_512.isEmpty() &&
                    binding.radioGroupQuestion13.getCheckedRadioButtonId() != -1 &&
                    binding.radioGroupQuestion14.getCheckedRadioButtonId() != -1


            ) {

                saveData();

            } else {
                Toast.makeText(this, "All Details are Mandatory", Toast.LENGTH_SHORT).show();
            }


        });
        binding.btnPrevious.setOnClickListener(v -> {

            editor.putString("et1", question_501);
            editor.putString("et2", question_502);
            editor.putString("et3", question_503);
            editor.putString("et4", question_504);
            editor.putString("et5", question_505);
            editor.putString("et6", question_506);
            editor.putString("et7", question_507);
            editor.putString("et8", question_508);
            editor.putString("et9", question_509);
            editor.putString("et10", question_510);
            editor.putString("et11", question_511);
            editor.putString("et12", question_512);
            editor.putString("com_head", comments_head);
            editor.putString("com_branch", comments_branch);

            editor.apply();
            onBackPressed();

        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
    }


    private void setData() {


        binding.radioGroupQuestion13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_513 = radioButton.getText().toString();
                editor.putInt("rg13", binding.radioGroupQuestion13.indexOfChild(findViewById(binding.radioGroupQuestion13.getCheckedRadioButtonId())));
                editor.apply();

                if (question_513.equalsIgnoreCase("Yes")) {
                    binding.commentsHeadLayout.setVisibility(View.VISIBLE);
                } else {
                    binding.commentsHeadLayout.setVisibility(View.GONE);
                }
            }
        });
        binding.radioGroupQuestion14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                question_514 = radioButton.getText().toString();
                editor.putInt("rg14", binding.radioGroupQuestion14.indexOfChild(findViewById(binding.radioGroupQuestion14.getCheckedRadioButtonId())));
                editor.apply();

                if (question_514.equalsIgnoreCase("Yes")) {
                    binding.commentsBranchLayout.setVisibility(View.VISIBLE);
                } else {
                    binding.commentsBranchLayout.setVisibility(View.GONE);
                }
            }
        });

    }

    public void getData() {


        question_501 = mSharedPref.getString("et1", "");
        binding.question1.setText(question_501);

        question_502 = mSharedPref.getString("et2", "");
        binding.question2.setText(question_502);

        question_503 = mSharedPref.getString("et3", "");
        binding.question3.setText(question_503);

        question_504 = mSharedPref.getString("et4", "");
        binding.question4.setText(question_504);

        question_505 = mSharedPref.getString("et5", "");
        binding.question5.setText(question_505);

        question_506 = mSharedPref.getString("et6", "");
        binding.question6.setText(question_506);

        question_507 = mSharedPref.getString("et7", "");
        binding.question7.setText(question_507);

        question_508 = mSharedPref.getString("et8", "");
        binding.question8.setText(question_508);

        question_509 = mSharedPref.getString("et9", "");
        binding.question9.setText(question_509);

        question_510 = mSharedPref.getString("et10", "");
        binding.question10.setText(question_510);

        question_511 = mSharedPref.getString("et11", "");
        binding.question11.setText(question_511);

        question_512 = mSharedPref.getString("et12", "");
        binding.question12.setText(question_512);

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


    private void selectImage() {
        final CharSequence[] items = {"Take Photo",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivitiesActivity.this);
        builder.setItems(items, (dialog, item) -> {
            if (items[item].equals("Take Photo")) {
                requestStoragePermission();

            } else if (items[item].equals("Cancel")) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /**
     * Capture image from camera
     */

  /*  private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }*/
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.vcspinfo.vevist.provider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {

            try {

                binding.imageView.setImageBitmap(BitmapFactory.decodeFile(currentPhotoPath));
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else {
            Log.d(TAG, "onActivityResult: " + "No Data");
        }

    }

    /**
     * Requesting multiple permissions (storage and camera) at once
     * This uses multiple permission model from dexter
     * On permanent denial opens settings dialog
     */
    private void requestStoragePermission() {
        Dexter.withActivity(this).withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            dispatchTakePictureIntent();
                        }
                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).withErrorListener(error -> Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show())
                .onSameThread()
                .check();
    }


    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivitiesActivity.this);
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    /**
     * Create file with current timestamp name
     *
     * @return
     * @throws IOException
     */
   /* private File createImageFile() throws IOException {
        // Create an image file name
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File mFile = File.createTempFile(mFileName, ".jpg", storageDir);
        Log.d(TAG, "createImageFile: "+mFile);
        // Save a file: path for use with ACTION_VIEW intents
        return mFile;
    }*/
    private File createImageFile() throws IOException {
        // Create an image file name
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void saveData() {

        binding.progressCircular.setVisibility(View.VISIBLE);
        // File file = new File("/storage/emulated/0/Download/Corrections 6.jpg");
        RequestBody requestFile = RequestBody.create(currentPhotoPath, MediaType.parse("multipart/form-data"));
        // RequestBody requestFile = RequestBody.create(mPhotoFile, MediaType.parse("image/jpeg"));

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("visit[photo]", currentPhotoPath, requestFile);

        RequestBody cspCodeBody = RequestBody.create(csp_code, MediaType.parse("text/plain"));
        RequestBody question_101_body = RequestBody.create(question_101, MediaType.parse("text/plain"));
        RequestBody question_102_body = RequestBody.create(question_102, MediaType.parse("text/plain"));
        RequestBody question_103_body = RequestBody.create(question_103, MediaType.parse("text/plain"));
        RequestBody question_104_body = RequestBody.create(question_104, MediaType.parse("text/plain"));
        RequestBody question_105_body = RequestBody.create(question_105, MediaType.parse("text/plain"));
        RequestBody question_106_body = RequestBody.create(question_106, MediaType.parse("text/plain"));
        RequestBody question_107_body = RequestBody.create(question_107, MediaType.parse("text/plain"));
        RequestBody question_108_body = RequestBody.create(question_108, MediaType.parse("text/plain"));
        RequestBody question_109_body = RequestBody.create(question_109, MediaType.parse("text/plain"));
        RequestBody question_110_body = RequestBody.create(question_110, MediaType.parse("text/plain"));
        RequestBody question_111_body = RequestBody.create(question_111, MediaType.parse("text/plain"));
        RequestBody question_112_body = RequestBody.create(question_112, MediaType.parse("text/plain"));
        RequestBody question_113_body = RequestBody.create(question_113, MediaType.parse("text/plain"));
        RequestBody question_114_body = RequestBody.create(question_114, MediaType.parse("text/plain"));
        RequestBody question_115_body = RequestBody.create(question_115, MediaType.parse("text/plain"));
        RequestBody question_116_body = RequestBody.create(question_116, MediaType.parse("text/plain"));
        RequestBody question_117_body = RequestBody.create(question_117, MediaType.parse("text/plain"));
        RequestBody question_118_body = RequestBody.create(question_118, MediaType.parse("text/plain"));
        RequestBody question_119_body = RequestBody.create(question_119, MediaType.parse("text/plain"));
        RequestBody question_120_body = RequestBody.create(question_120, MediaType.parse("text/plain"));
        RequestBody question_121_body = RequestBody.create(question_121, MediaType.parse("text/plain"));

        RequestBody question_201_body = RequestBody.create(question_201, MediaType.parse("text/plain"));
        RequestBody question_202_body = RequestBody.create(question_202, MediaType.parse("text/plain"));
        RequestBody question_203_body = RequestBody.create(question_203, MediaType.parse("text/plain"));
        RequestBody question_204_body = RequestBody.create(question_204, MediaType.parse("text/plain"));
        RequestBody question_205_body = RequestBody.create(question_205, MediaType.parse("text/plain"));
        RequestBody question_206_body = RequestBody.create(question_206, MediaType.parse("text/plain"));
        RequestBody question_207_body = RequestBody.create(question_207, MediaType.parse("text/plain"));
        RequestBody question_208_body = RequestBody.create(question_208, MediaType.parse("text/plain"));
        RequestBody question_209_body = RequestBody.create(question_209, MediaType.parse("text/plain"));
        RequestBody question_210_body = RequestBody.create(question_210, MediaType.parse("text/plain"));
        RequestBody question_211_body = RequestBody.create(question_211, MediaType.parse("text/plain"));
        RequestBody question_212_body = RequestBody.create(question_212, MediaType.parse("text/plain"));
        RequestBody question_213_body = RequestBody.create(question_213, MediaType.parse("text/plain"));
        RequestBody question_214_body = RequestBody.create(question_214, MediaType.parse("text/plain"));
        RequestBody question_215_body = RequestBody.create(question_215, MediaType.parse("text/plain"));
        RequestBody question_216_body = RequestBody.create(question_216, MediaType.parse("text/plain"));
        RequestBody question_217_body = RequestBody.create(question_217, MediaType.parse("text/plain"));
        RequestBody question_218_body = RequestBody.create(question_218, MediaType.parse("text/plain"));
        RequestBody question_219_body = RequestBody.create(question_219, MediaType.parse("text/plain"));
        RequestBody question_220_body = RequestBody.create(question_220, MediaType.parse("text/plain"));
        RequestBody question_221_body = RequestBody.create(question_221, MediaType.parse("text/plain"));
        RequestBody question_222_body = RequestBody.create(question_222, MediaType.parse("text/plain"));
        RequestBody question_223_body = RequestBody.create(question_223, MediaType.parse("text/plain"));
        RequestBody question_224_body = RequestBody.create(question_224, MediaType.parse("text/plain"));
        RequestBody question_225_body = RequestBody.create(question_225, MediaType.parse("text/plain"));

        RequestBody question_301_body = RequestBody.create(question_301, MediaType.parse("text/plain"));
        RequestBody question_302_body = RequestBody.create(question_302, MediaType.parse("text/plain"));
        RequestBody question_303_body = RequestBody.create(question_303, MediaType.parse("text/plain"));
        RequestBody question_304_body = RequestBody.create(question_304, MediaType.parse("text/plain"));
        RequestBody question_305_body = RequestBody.create(question_305, MediaType.parse("text/plain"));
        RequestBody question_306_body = RequestBody.create(question_306, MediaType.parse("text/plain"));
        RequestBody question_307_body = RequestBody.create(question_307, MediaType.parse("text/plain"));
        RequestBody question_308_body = RequestBody.create(question_308, MediaType.parse("text/plain"));
        RequestBody question_309_body = RequestBody.create(question_309, MediaType.parse("text/plain"));
        RequestBody question_310_body = RequestBody.create(question_310, MediaType.parse("text/plain"));
        RequestBody question_311_body = RequestBody.create(question_311, MediaType.parse("text/plain"));
        RequestBody question_312_body = RequestBody.create(question_312, MediaType.parse("text/plain"));
        RequestBody question_313_body = RequestBody.create(question_313, MediaType.parse("text/plain"));
        RequestBody question_314_body = RequestBody.create(question_314, MediaType.parse("text/plain"));
        RequestBody question_315_body = RequestBody.create(question_315, MediaType.parse("text/plain"));
        RequestBody question_316_body = RequestBody.create(question_316, MediaType.parse("text/plain"));
        RequestBody question_317_body = RequestBody.create(question_317, MediaType.parse("text/plain"));
        RequestBody question_318_body = RequestBody.create(question_318, MediaType.parse("text/plain"));
        RequestBody question_319_body = RequestBody.create(question_319, MediaType.parse("text/plain"));

        RequestBody question_401_body = RequestBody.create(question_401, MediaType.parse("text/plain"));
        RequestBody question_402_body = RequestBody.create(question_402, MediaType.parse("text/plain"));
        RequestBody question_403_body = RequestBody.create(question_403, MediaType.parse("text/plain"));
        RequestBody question_404_body = RequestBody.create(question_404, MediaType.parse("text/plain"));
        RequestBody question_405_body = RequestBody.create(question_405, MediaType.parse("text/plain"));

        RequestBody question_501_body = RequestBody.create(question_501, MediaType.parse("text/plain"));
        RequestBody question_502_body = RequestBody.create(question_502, MediaType.parse("text/plain"));
        RequestBody question_503_body = RequestBody.create(question_503, MediaType.parse("text/plain"));
        RequestBody question_504_body = RequestBody.create(question_504, MediaType.parse("text/plain"));
        RequestBody question_505_body = RequestBody.create(question_505, MediaType.parse("text/plain"));
        RequestBody question_506_body = RequestBody.create(question_506, MediaType.parse("text/plain"));
        RequestBody question_507_body = RequestBody.create(question_507, MediaType.parse("text/plain"));
        RequestBody question_508_body = RequestBody.create(question_508, MediaType.parse("text/plain"));
        RequestBody question_509_body = RequestBody.create(question_509, MediaType.parse("text/plain"));
        RequestBody question_510_body = RequestBody.create(question_510, MediaType.parse("text/plain"));
        RequestBody question_511_body = RequestBody.create(question_511, MediaType.parse("text/plain"));
        RequestBody question_512_body = RequestBody.create(question_512, MediaType.parse("text/plain"));
        RequestBody question_513_body = RequestBody.create(question_513, MediaType.parse("text/plain"));
        RequestBody comments_head_body = RequestBody.create(comments_head, MediaType.parse("text/plain"));
        RequestBody question_514_body = RequestBody.create(question_514, MediaType.parse("text/plain"));
        RequestBody comments_branch_body = RequestBody.create(comments_branch, MediaType.parse("text/plain"));

        RequestBody latitudeBody = RequestBody.create(latitude, MediaType.parse("text/plain"));
        RequestBody longitudeBody = RequestBody.create(longitude, MediaType.parse("text/plain"));
        RequestBody tokenBody = RequestBody.create(token, MediaType.parse("text/plain"));


        Call<CreateVisitResponse> call = RetrofitService.createService(ApiInterface.class, this).creteVisit(cspCodeBody,
                question_101_body,
                question_102_body,
                question_103_body,
                question_104_body,
                question_105_body,
                question_106_body,
                question_107_body,
                question_108_body,
                question_109_body,
                question_110_body,
                question_111_body,
                question_112_body,
                question_113_body,
                question_114_body,
                question_115_body,
                question_116_body,
                question_117_body,
                question_118_body,
                question_119_body,
                question_120_body,
                question_121_body,
                question_201_body,
                question_202_body,
                question_203_body,
                question_204_body,
                question_205_body,
                question_206_body,
                question_207_body,
                question_208_body,
                question_209_body,
                question_210_body,
                question_211_body,
                question_212_body,
                question_213_body,
                question_214_body,
                question_215_body,
                question_216_body,
                question_217_body,
                question_218_body,
                question_219_body,
                question_220_body,
                question_221_body,
                question_222_body,
                question_223_body,
                question_224_body,
                question_225_body,
                question_301_body,
                question_302_body,
                question_303_body,
                question_304_body,
                question_305_body,
                question_306_body,
                question_307_body,
                question_308_body,
                question_309_body,
                question_310_body,
                question_311_body,
                question_312_body,
                question_313_body,
                question_314_body,
                question_315_body,
                question_316_body,
                question_317_body,
                question_318_body,
                question_319_body,
                question_401_body,
                question_402_body,
                question_403_body,
                question_404_body,
                question_405_body,
                question_501_body,
                question_502_body,
                question_503_body,
                question_504_body,
                question_505_body,
                question_506_body,
                question_507_body,
                question_508_body,
                question_509_body,
                question_510_body,
                question_511_body,
                question_512_body,
                question_513_body,
                comments_head_body,
                question_514_body,
                comments_branch_body,
                body, latitudeBody, longitudeBody, tokenBody);
        call.enqueue(new Callback<CreateVisitResponse>() {
            @Override
            public void onResponse(@NonNull Call<CreateVisitResponse> call, @NonNull Response<CreateVisitResponse> response) {

                if (response.isSuccessful()) {

                    binding.progressCircular.setVisibility(View.GONE);
                    assert response.body() != null;
                    Toast.makeText(ActivitiesActivity.this, "" + response.body().getSuccess(), Toast.LENGTH_SHORT).show();

                    SharedPreferences mSharedPref1 = getSharedPreferences("VE_VISIT_INFRA", MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = mSharedPref1.edit();
                    editor1.clear().apply();

                    SharedPreferences mSharedPref2 = getSharedPreferences("VE_VISIT_DOCUMENTATION", MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = mSharedPref2.edit();
                    editor2.clear().apply();

                    SharedPreferences mSharedPref3 = getSharedPreferences("VE_VISIT_ZERO", MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = mSharedPref3.edit();
                    editor3.clear().apply();

                    SharedPreferences mSharedPref4 = getSharedPreferences("VE_VISIT_CERTIFICATION", MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = mSharedPref4.edit();
                    editor4.clear().apply();

                    editor.clear().apply();

                    Intent intent = new Intent(ActivitiesActivity.this, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);
                    ApiError errorResponse = new Gson().fromJson(response.errorBody().charStream(), ApiError.class);
                    Toast.makeText(ActivitiesActivity.this, errorResponse.getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CreateVisitResponse> call, @NonNull Throwable t) {
                binding.progressCircular.setVisibility(View.GONE);
                // Log.d("TAG", "onFailure: " + t.getMessage());
                if (t instanceof NoConnectivityException) {
                    Toast.makeText(ActivitiesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}