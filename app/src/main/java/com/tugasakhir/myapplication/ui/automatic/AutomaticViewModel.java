package com.tugasakhir.myapplication.ui.automatic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AutomaticViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AutomaticViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}