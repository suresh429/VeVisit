package com.vcspinfo.vevist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentCertificationBinding;


public class CertificationFragment extends Fragment {


    FragmentCertificationBinding binding;
    public CertificationFragment() {
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
        binding=FragmentCertificationBinding.inflate(getLayoutInflater());


        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.acitivitiesFragment,bundle);


            }
        });
        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.zeroToleranceFragment,bundle);


            }
        });

        return binding.getRoot();
    }
}