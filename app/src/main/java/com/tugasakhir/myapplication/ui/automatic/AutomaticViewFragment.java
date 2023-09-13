package com.tugasakhir.myapplication.ui.automatic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tugasakhir.myapplication.R;

public class AutomaticViewFragment extends Fragment {

    private AutomaticViewLogic viewModel;

    public AutomaticViewFragment(){
        this.viewModel = new AutomaticViewLogic();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_automatic, container, false);
    }


    // onViewCreated == kondisi dimana UI itu sudah tampil di layar pengguna.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Atur class AutomaticViewController sbg controller UI.
        AutomaticViewController automaticViewController = new AutomaticViewController(view);
    }
}
