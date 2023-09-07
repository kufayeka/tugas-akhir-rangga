package com.tugasakhir.myapplication.handler;

import com.tugasakhir.myapplication.variables.GlobalVariable;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class AntaresAPI implements AntaresHTTPAPI.OnResponseListener {

    private AntaresHTTPAPI antaresHTTPAPI;
    private String response;


    public AntaresAPI(){
        this.antaresHTTPAPI = new AntaresHTTPAPI();
        this.antaresHTTPAPI.addListener(this);
    }

    public void getLatestDataOfDevice(String accessKey, String appName, String deviceName) {
        antaresHTTPAPI.getLatestDataofDevice(accessKey, appName, deviceName);
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        String responseBody = antaresResponse.getBody();
        try {
            JSONObject body = new JSONObject(antaresResponse.getBody());
            String res = body.getJSONObject("m2m:cin").getString("con");

            System.out.println(res);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
