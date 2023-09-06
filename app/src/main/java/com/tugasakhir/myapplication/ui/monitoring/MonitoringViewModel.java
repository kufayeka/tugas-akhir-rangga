package com.tugasakhir.myapplication.ui.monitoring;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MonitoringViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MonitoringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ini Halaman Monitoring...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}