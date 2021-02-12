package com.vcspinfo.vevist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentDocumentationBinding;


public class DocumentationFragment extends Fragment {



    FragmentDocumentationBinding binding;
    public DocumentationFragment() {
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
        binding=FragmentDocumentationBinding.inflate(getLayoutInflater());

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.zeroToleranceFragment,bundle);


            }
        });
        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.infraFragment,bundle);


            }
        });
        return binding.getRoot();

    }
}