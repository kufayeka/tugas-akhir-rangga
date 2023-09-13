package com.tugasakhir.myapplication.ui.automatic;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tugasakhir.myapplication.R;

import java.util.concurrent.CompletableFuture;

public class AutomaticViewController {

    private AutomaticViewLogic x;

    private TextView textView;
    private Button btnStart;
    private Button btnStop;

    // constructor = otomatis dijalankan saat class pertama kali di inisialisasi.
    public AutomaticViewController(View view) {
        x = new AutomaticViewLogic();

        textView = view.findViewById(R.id.text_response_data);
        btnStart = view.findViewById(R.id.button_start);
        btnStop = view.findViewById(R.id.button_stop);

        setupListenerButton();
    }

    ////////////////////////////////INI METHOD CUSTOM//////////////////////////////////////////////
    private void setupListenerButton(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x.postDataStart();
            }
        });
    }

}
