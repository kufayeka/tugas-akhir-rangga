package com.tugasakhir.myapplication.ui.monitoring;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tugasakhir.myapplication.R;
import com.tugasakhir.myapplication.ui.manual.ManualViewModel;
import com.tugasakhir.myapplication.ui.monitoring.MonitoringViewModel;

public class MonitoringViewFragment extends Fragment {

    private MonitoringViewModel viewModel;

    public MonitoringViewFragment() {
        // constructor kosong
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MonitoringViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monitoring, container, false);
    }
}
