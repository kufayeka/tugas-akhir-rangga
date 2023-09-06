package com.tugasakhir.myapplication.ui.automatic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tugasakhir.myapplication.databinding.FragmentAutomaticBinding;

public class AutomaticFragment extends Fragment {

    private FragmentAutomaticBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AutomaticViewModel automaticViewModel =
                new ViewModelProvider(this).get(AutomaticViewModel.class);

        binding = FragmentAutomaticBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        automaticViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}