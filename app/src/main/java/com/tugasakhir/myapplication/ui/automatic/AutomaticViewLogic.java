package com.tugasakhir.myapplication.ui.automatic;


import androidx.lifecycle.ViewModel;

import com.tugasakhir.myapplication.handler.AntaresAPI;
import com.tugasakhir.myapplication.handler.AntaresOnResponseCallback;
import com.tugasakhir.myapplication.handler.HttpService;
import com.tugasakhir.myapplication.variables.GlobalVariable;

import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticViewLogic {

    private GlobalVariable globalVariable;
    private AntaresAPI antaresAPI;

    public AutomaticViewLogic(){
        this.globalVariable = new GlobalVariable();
        this.antaresAPI = new AntaresAPI();
    }

    public void getData(){
        antaresAPI.getLatestDataOfDevice(
                globalVariable.accessKey,
                globalVariable.applicationName,
                globalVariable.deviceName);
    }

}