package com.tugasakhir.myapplication.ui.automatic;


import androidx.lifecycle.ViewModel;
import com.tugasakhir.myapplication.handler.HttpService;
import com.tugasakhir.myapplication.variables.GlobalVariable;

import org.json.JSONException;
import org.json.JSONObject;

public class AutomaticViewLogic extends ViewModel {

    private GlobalVariable globalVariable;
    private HttpService httpService;

    public AutomaticViewLogic(){
        this.globalVariable = new GlobalVariable();
        this.httpService = new HttpService();
    }

    public interface DataCallback {
        void onDataReceived(String x);
    }

    public void getData(final DataCallback callback){
        String antaresURL = globalVariable.url+"/la";

        httpService.get(antaresURL, new HttpService.HttpCallback() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String conValue = jsonResponse.getJSONObject("m2m:cin").getString("con");

                    JSONObject conJSON = new JSONObject(conValue);
                    String dataValue = conJSON.getString("type");

                    // kirim balik data responsenya ke class AutomaticViewController
                    callback.onDataReceived(conValue);

                    System.out.println("RESPONSE:" + dataValue);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("ERROR:" + error);
            }
        });
    }
}