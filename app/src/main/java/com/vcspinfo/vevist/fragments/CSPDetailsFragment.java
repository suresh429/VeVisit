package com.vcspinfo.vevist.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentCspDetailsBinding;
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


public class CSPDetailsFragment extends Fragment {
    private static final String TAG = "CSPDetailsFragment";

    FragmentCspDetailsBinding binding;

    ArrayList<String> cspArrayList;

    UserSessionManager userSessionManager;

    String cspCode;

    public CSPDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCspDetailsBinding.inflate(getLayoutInflater());

        userSessionManager = new UserSessionManager(requireActivity());
        cspArrayList = new ArrayList<>();


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            //dob1 = getArguments().getString("dob");

            //binding.etDob.setText(dob1);
        }
        binding.etSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.spinnerCSPCode.performClick();
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob1= Objects.requireNonNull(binding.etDob.getText()).toString();


                if (Objects.requireNonNull(binding.etCspname.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etMobile.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etPan.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etAadhar.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etVillage.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etLocation.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etPin.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etTehsil.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etSsa.getText()).toString().isEmpty() ||
                        Objects.requireNonNull(binding.etDob.getText()).toString().isEmpty()) {
                    Toast.makeText(requireActivity(), "Please enter Details", Toast.LENGTH_SHORT).show();
                } else {

                    Navigation.findNavController(binding.getRoot()).navigate(R.id.infraFragment, bundle);
                }


            }
        });

        getCSPList();
        return binding.getRoot();

    }

    public void getCSPList() {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<List<CSPDetailsListResponse>> call = RetrofitService.createService(ApiInterface.class, requireActivity()).getCspDetailsList(userSessionManager.getUserDetails().get("token"));
        call.enqueue(new Callback<List<CSPDetailsListResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<CSPDetailsListResponse>> call, @NonNull Response<List<CSPDetailsListResponse>> response) {

                if (response.isSuccessful()) {
                    binding.progressCircular.setVisibility(View.GONE);

                    List<CSPDetailsListResponse> cspDetailsListResponses = response.body();

                    cspArrayList.clear();
                    cspArrayList.add("Select CSP Code");
                    assert cspDetailsListResponses != null;
                    for (CSPDetailsListResponse bn : cspDetailsListResponses) {

                        cspArrayList.add(bn.getCspCode());
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item, cspArrayList);
                    arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
                    binding.spinnerCSPCode.setAdapter(arrayAdapter);

                    binding.spinnerCSPCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            cspCode = parent.getSelectedItem().toString();
                            if (!cspCode.equalsIgnoreCase("Select CSP Code")) {
                                getCSPDetails(cspCode);
                                binding.etSpinner.setText(cspCode);
                            }else {
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
            public void onFailure(@NonNull Call<List<CSPDetailsListResponse>> call, @NonNull Throwable t) {
                if (t instanceof NoConnectivityException) {
                    // show No Connectivity message to user or do whatever you want.
                    Toast.makeText(requireActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }

    public void getCSPDetails(String cspCode) {
        binding.progressCircular.setVisibility(View.VISIBLE);
        Call<CSPDetailsResponse> call = RetrofitService.createService(ApiInterface.class, requireActivity()).getCspDetails(cspCode);
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
                    Toast.makeText(requireActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    // Whenever you want to show toast use setValue.

                }
                binding.progressCircular.setVisibility(View.GONE);

            }
        });
    }
}