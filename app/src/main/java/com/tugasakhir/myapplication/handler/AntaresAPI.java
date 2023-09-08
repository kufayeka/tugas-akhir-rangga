package com.tugasakhir.myapplication.handler;

import com.tugasakhir.myapplication.ui.automatic.AutomaticViewController;
import com.tugasakhir.myapplication.ui.automatic.AutomaticViewLogic;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.CompletableFuture;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;


public class AntaresAPI {

    private AntaresHTTPAPI antaresHTTPAPI;
    private AntaresAPI self;
    String result = "";

    public AntaresAPI(){
        this.antaresHTTPAPI = new AntaresHTTPAPI();
        this.self = this;
    }


    public CompletableFuture<String> getLatestDataOfDevice(
            String accessKey,
            String appName,
            String deviceName) {
        CompletableFuture<String> future = new CompletableFuture<>();

        try {
            antaresHTTPAPI.getLatestDataofDevice(accessKey, appName, deviceName);

            antaresHTTPAPI.addListener(new AntaresHTTPAPI.OnResponseListener() {
                @Override
                public void onResponse(AntaresResponse antaresResponse) {
                    try {
                        JSONObject body = new JSONObject(antaresResponse.getBody());
                        String res = body.getJSONObject("m2m:cin").getString("con");
                        future.complete(res);
                    } catch (JSONException e) {
                        future.completeExceptionally(e);
                    }
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    public void storeDataofDevice(
            String accessKey,
            String appName,
            String deviceName,
            String data){
        antaresHTTPAPI.storeDataofDevice(accessKey, appName, deviceName, "");
    }
}
