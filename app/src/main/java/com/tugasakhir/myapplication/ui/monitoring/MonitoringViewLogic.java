package com.tugasakhir.myapplication.ui.monitoring;

import android.content.Context;

import androidx.lifecycle.ViewModel;


import com.tugasakhir.myapplication.handler.AntaresAPI;
import com.tugasakhir.myapplication.variables.GlobalVariable;

import org.json.JSONObject;

import java.net.ContentHandler;
import java.net.HttpURLConnection;

public class MonitoringViewLogic extends ViewModel {

    private AntaresAPI api;
    private GlobalVariable var;

    public MonitoringViewLogic(){
        api = new AntaresAPI();
        var = new GlobalVariable();
    }

    //////////////////////////////////////////////////////////

    public String getData(){
//        api.getLatestDataOfDevice(var.accessKey, var.applicationName, var.deviceName);

        String hasilReturn = "ini data return";

        return hasilReturn;
    }

}
