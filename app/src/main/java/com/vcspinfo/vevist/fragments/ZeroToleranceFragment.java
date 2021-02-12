package com.vcspinfo.vevist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentZeroToleranceBinding;

import org.jetbrains.annotations.NotNull;


public class ZeroToleranceFragment extends Fragment {


    FragmentZeroToleranceBinding binding;

    public ZeroToleranceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this

        binding=FragmentZeroToleranceBinding.inflate(getLayoutInflater());

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.certificationFragment,bundle);


            }
        });
        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.documentationFragment,bundle);


            }
        });

        return binding.getRoot();
    }
}