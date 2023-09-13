package com.tugasakhir.myapplication.ui.automatic;

import com.tugasakhir.myapplication.handler.AntaresAPI;
import com.tugasakhir.myapplication.variables.GlobalVariable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;


public class AutomaticViewLogic {

    private GlobalVariable a;
    private AntaresAPI b;

    public AutomaticViewLogic(){
        a = new GlobalVariable();
        b = new AntaresAPI();
    }

    ////////////////////////////////////////////////////
    public CompletableFuture<String> getData() {
        return b.getLatestDataOfDevice(
                a.accessKey,
                a.applicationName,
                a.deviceName
        );
    }


    public void postDataStart(){

        String nested = "{\\\"a\\\": \\\"3\\\",\\\"b\\\":\\\"5\\\"}";

        String jsonString = "{\\\"status\\\": \\\"3\\\",\\\"status\\\": \\\"5\\\",\\\"nested\\\":"+nested+"}";

        b.storeDataofDevice(a.accessKey, a.applicationName, a.deviceName, jsonString);
    }

    public void postDataStop(){}

}
