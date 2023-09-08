package com.tugasakhir.myapplication.ui.automatic;

import com.tugasakhir.myapplication.handler.AntaresAPI;
import com.tugasakhir.myapplication.variables.GlobalVariable;

import java.util.concurrent.CompletableFuture;


public class AutomaticViewLogic {

    private GlobalVariable globalVariable;
    private AntaresAPI antaresAPI;

    public AutomaticViewLogic(){
        this.globalVariable = new GlobalVariable();
        this.antaresAPI = new AntaresAPI();
    }

    public CompletableFuture<String> getData() {
        return antaresAPI.getLatestDataOfDevice(
                globalVariable.accessKey,
                globalVariable.applicationName,
                globalVariable.deviceName
        );
    }

}
