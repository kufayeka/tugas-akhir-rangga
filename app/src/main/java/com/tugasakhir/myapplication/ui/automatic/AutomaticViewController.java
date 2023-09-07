package com.tugasakhir.myapplication.ui.automatic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tugasakhir.myapplication.R;
import com.tugasakhir.myapplication.handler.AntaresAPI;
import com.tugasakhir.myapplication.handler.AntaresOnResponseCallback;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkom.iot.AntaresResponse;

public class AutomaticViewController {

    private AutomaticViewLogic logic;

    private TextView textView;
    private Button btnStart;
    private Button btnStop;

    public AutomaticViewController(View view) {
        this.logic = new AutomaticViewLogic();

        this.textView = view.findViewById(R.id.text_response_data);
        this.btnStart = view.findViewById(R.id.button_start);
        this.btnStop = view.findViewById(R.id.button_stop);

        // handle logic tombol start
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logic.getData();
            }
        });

        // handle logic tombol stop
        this.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ganti jadi tulisan lain
                updateTextResponseData("ini tombol stop");
            }
        });
    }

    public void updateTextResponseData(String content){
        textView.setText(content);
    }
}
