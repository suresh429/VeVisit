package com.vcspinfo.vevist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vcspinfo.vevist.R;
import com.vcspinfo.vevist.databinding.FragmentAcitivitiesBinding;


public class AcitivitiesFragment extends Fragment {

    FragmentAcitivitiesBinding binding;
    public AcitivitiesFragment() {
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
        binding=FragmentAcitivitiesBinding.inflate(getLayoutInflater());

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Toast.makeText(requireActivity(), "Save", Toast.LENGTH_SHORT).show();


            }
        });
        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dob= Objects.requireNonNull(binding.etDob.getText()).toString();
                Bundle bundle = new Bundle();
                //bundle.putString("dob",dob);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.certificationFragment,bundle);


            }
        });

        return binding.getRoot();

    }
}