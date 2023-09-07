package com.tugasakhir.myapplication.ui.monitoring;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tugasakhir.myapplication.R;

public class MonitoringViewFragment extends Fragment {

    private MonitoringViewLogic viewModel;

    public MonitoringViewFragment() {
        // constructor kosong
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MonitoringViewLogic.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitoring, container, false);
    }
}
