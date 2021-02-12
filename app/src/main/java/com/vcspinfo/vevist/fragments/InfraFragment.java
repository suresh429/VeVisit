package com.vcspinfo.vevist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentInfraBinding;


import java.util.Objects;


public class InfraFragment extends Fragment {




    FragmentInfraBinding binding;
    public InfraFragment() {
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
        binding= FragmentInfraBinding.inflate(getLayoutInflater());


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            //dob = getArguments().getString("dob");
            //binding.etDob.setText(dob);
        }

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.documentationFragment,bundle);


            }
        });
        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.cspDetailsFragment,bundle);


            }
        });
        return  binding.getRoot();
    }
}