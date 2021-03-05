package com.vcspinfo.vevist.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.Navigation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.vcspinfo.vevist.BuildConfig;
import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.ActivityCSPDetailsBinding;
import com.vcspinfo.vevist.helper.UserSessionManager;
import com.vcspinfo.vevist.models.CSPDetailsListResponse;
import com.vcspinfo.vevist.models.CSPDetailsResponse;
import com.vcspinfo.vevist.network.ApiInterface;
import com.vcspinfo.vevist.network.NoConnectivityException;
import com.vcspinfo.vevist.network.RetrofitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CSPDetailsActivity extends AppCompatActivity {

    private static final String TAG = "CSPDetailsActivity";
    ActivityCSPDetailsBinding binding;
    List<String> cspArrayList;

    UserSessionManager userSessionManager;

    String cspCode = "Select CSP Code";
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;


    /**
     * Provides access to the Fused Location Provider API.
     */
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCSPDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cspArrayList = new ArrayList<>();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CSP Details");
        userSessionManager = new UserSessionManager(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);



        if (getIntent() != null){
            cspCode = getIntent().getStringExtra("cspCode");

            if (cspCode==null){
                getCSPList();
            }else {
                binding.etSpinner.setText(cspCode);
                getCSPDetails(cspCode);
            }
        }




        Log.d(TAG, "onCreate: "+cspCode);

        binding.etSpinner.setOnClickListener(v -> binding.spinnerCSPCode.performClick());

        binding.btnNext.setOnClickListener(v -> {


            if (!cspCode.equalsIgnoreCase("Select CSP Code")) {
                Intent intent = new Intent(CSPDetailsActivity.this, InfraActivity.class);
                intent.putExtra("csp_code", cspCode);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Please Select CSP Code", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void getCSPList() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<CSPDetailsListResponse> call = RetrofitService.createService(ApiInterface.class, CSPDetailsActivity.this).getCspDetailsList(userSessionManager.getUserDetails().get("token"));
        call.enqueue(new Callback<CSPDetailsListResponse>() {
            @Override
            public void onResponse(@NonNull Call<CSPDetailsListResponse> call, @NonNull Response<CSPDetailsListResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    assert response.body() != null;
                    List<CSPDetailsListResponse.DataBean.PartnersBean> cspDetailsListResponses = response.body().getData().getPartners();

                    cspArrayList.clear();
                    cspArrayList.add("Select CSP Code");
                    assert cspDetailsListResponses != null;
                    for (CSPDetailsListResponse.DataBean.PartnersBean bn : cspDetailsListResponses) {

                        cspArrayList.add(bn.getCspCode());

                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CSPDetailsActivity.this, android.R.layout.simple_spinner_dropdown_item, cspArrayList);
                    arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
                    binding.spinnerCSPCode.setAdapter(arrayAdapter);
                    binding.spinnerCSPCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            cspCode = parent.getSelectedItem().toString();
                            if (!cspCode.equalsIgnoreCase("Select CSP Code")) {

                                getCSPDetails(cspCode);



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

                                SharedPreferences mSharedPref5 = getSharedPreferences("VE_VISIT_ACTIVITIES", MODE_PRIVATE);
                                SharedPreferences.Editor editor5 = mSharedPref5.edit();
                                editor5.clear().apply();

                                binding.etSpinner.setText(cspCode);
                            } else {

                                binding.etSpinner.setText("");
                                binding.etCspname.setText("");
                                binding.etMobile.setText("");
                                binding.etPan.setText("");
                                binding.etAadhar.setText("");
                                binding.etLocation.setText("");
                                binding.etVillage.setText("");
                                binding.etPin.setText("");
                                binding.etTehsil.setText("");
                                binding.etSsa.setText("");
                                binding.etDob.setText("");

                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<CSPDetailsListResponse> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(CSPDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }

    public void getCSPDetails(String cspCode) {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<CSPDetailsResponse> call = RetrofitService.createService(ApiInterface.class, CSPDetailsActivity.this).getCspDetails(cspCode);
        call.enqueue(new Callback<CSPDetailsResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<CSPDetailsResponse> call, @NonNull Response<CSPDetailsResponse> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);
                    assert response.body() != null;
                    List<CSPDetailsResponse.CspDetailsBean> cspDetailsResponseList = response.body().getCspDetails();

                    if (cspDetailsResponseList.get(0).getName() == null) {
                        binding.etCspname.setText("");
                    } else {
                        binding.etCspname.setText(cspDetailsResponseList.get(0).getName());
                    }
                    if (cspDetailsResponseList.get(0).getMobile() == null) {
                        binding.etMobile.setText("");
                    } else {
                        binding.etMobile.setText("" + cspDetailsResponseList.get(0).getMobile());
                    }

                    if (cspDetailsResponseList.get(0).getPan() == null) {
                        binding.etPan.setText("");
                    } else {
                        binding.etPan.setText("" + cspDetailsResponseList.get(0).getPan());
                    }

                    if (cspDetailsResponseList.get(0).getAadhaar() == null) {
                        binding.etAadhar.setText("");
                    } else {
                        binding.etAadhar.setText("" + cspDetailsResponseList.get(0).getAadhaar());
                    }

                    if (cspDetailsResponseList.get(0).getVillage() == null) {
                        binding.etVillage.setText("");
                    } else {
                        binding.etVillage.setText("" + cspDetailsResponseList.get(0).getVillage());
                    }
                    if (cspDetailsResponseList.get(0).getCspLocation() == null) {
                        binding.etLocation.setText("");
                    } else {
                        binding.etLocation.setText("" + cspDetailsResponseList.get(0).getCspLocation());
                    }
                    if (cspDetailsResponseList.get(0).getPin() == null) {
                        binding.etPin.setText("");
                    } else {
                        binding.etPin.setText("" + cspDetailsResponseList.get(0).getPin());
                    }
                    if (cspDetailsResponseList.get(0).getTehsil() == null) {
                        binding.etTehsil.setText("");
                    } else {
                        binding.etTehsil.setText("" + cspDetailsResponseList.get(0).getTehsil());
                    }
                    if (cspDetailsResponseList.get(0).getSsa() == null) {
                        binding.etSsa.setText("");
                    } else {
                        binding.etSsa.setText("" + cspDetailsResponseList.get(0).getSsa());
                    }

                    if (cspDetailsResponseList.get(0).getDob() == null) {
                        binding.etDob.setText("");
                    } else {
                        binding.etDob.setText(cspDetailsResponseList.get(0).getDob());
                    }


                } else if (response.errorBody() != null) {
                    binding.progressCircular.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(@NonNull Call<CSPDetailsResponse> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(CSPDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
    }*/


    @Override
    public void onStart() {
        super.onStart();

        if (!checkPermissions()) {
            requestPermissions();
        } else {
            getAddress();
        }
    }

    /**
     * Gets the address for the last known location.
     */
    @SuppressWarnings("MissingPermission")
    private void getAddress() {
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location == null) {
                            Log.w(TAG, "onSuccess:null");

                        } else {
                            Log.d(TAG, "onSuccess: " + location.getLatitude());
                            Log.d(TAG, "onSuccess: " + location.getLongitude());
                            userSessionManager.createLocation(""+location.getLongitude(),""+location.getLatitude());
                        }


                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "getLastLocation:onFailure", e);
                    }
                });
    }


    /**
     * Shows a {@link Snackbar}.
     *
     * @param mainTextStringId The id for the string resource for the Snackbar text.
     * @param actionStringId   The text of the action item.
     * @param listener         The listener associated with the Snackbar action.
     */
    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener) {
        Snackbar.make(findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }

    /**
     * Return the current state of the permissions needed.
     */
    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {


            showSnackbar(R.string.permission_rationale, android.R.string.ok,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Request permission
                            ActivityCompat.requestPermissions(CSPDetailsActivity.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    REQUEST_PERMISSIONS_REQUEST_CODE);
                        }
                    });

        } else {
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            ActivityCompat.requestPermissions(CSPDetailsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                Log.i(TAG, "User interaction was cancelled.");
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
                getAddress();
            } else {
                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.
                showSnackbar(R.string.permission_denied_explanation, R.string.settings,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Build intent that displays the App settings screen.
                                Intent intent = new Intent();
                                intent.setAction(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",
                                        BuildConfig.APPLICATION_ID, null);
                                intent.setData(uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        });
            }
        }
    }
}