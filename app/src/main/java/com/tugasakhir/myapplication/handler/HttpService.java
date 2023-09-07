package com.tugasakhir.myapplication.handler;

import com.tugasakhir.myapplication.variables.GlobalVariable;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HttpService {

    private GlobalVariable globalVariable;

    public HttpService(){
        this.globalVariable = new GlobalVariable();
    }

    public interface HttpCallback {
        void onResponse(String response);
        void onError(String error);
    }

    private final Executor executor = Executors.newSingleThreadExecutor();

    public void get(final String url, final HttpCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                InputStream inputStream = null;
                try {
                    URL urlConnection = new URL(url);
                    connection = (HttpURLConnection) urlConnection.openConnection();
                    connection.setRequestProperty("accept", "application/json");
                    connection.setRequestProperty("Content-Type", "application/json;ty=4");
                    connection.setRequestProperty("X-M2M-Origin", globalVariable.accessKey);
                    connection.setRequestProperty("Accept", "application/json");

                    inputStream = new BufferedInputStream(connection.getInputStream());

                    StringBuilder response = new StringBuilder();
                    int bytesRead;
                    byte[] buffer = new byte[1024];
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        response.append(new String(buffer, 0, bytesRead));
                    }

                    final String result = response.toString();
                    callback.onResponse(result);
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onError("Error in network request.");
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }
}
