package com.tugasakhir.myapplication.ui.automatic;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tugasakhir.myapplication.R;

import java.util.concurrent.CompletableFuture;

public class AutomaticViewController {

    private AutomaticViewLogic logic;

    private TextView textView;
    private Button btnStart;
    private Button btnStop;
    private Handler handler;

    public AutomaticViewController(View view) {
        this.logic = new AutomaticViewLogic();

        this.textView = view.findViewById(R.id.text_response_data);
        this.btnStart = view.findViewById(R.id.button_start);
        this.btnStop = view.findViewById(R.id.button_stop);

        SetupButtonListener();

        handler = new Handler(Looper.getMainLooper());
    }

    private void SetupButtonListener() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(updateDataRunnable, 1000);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(updateDataRunnable);
                updateTextResponseData("ini tombol stop");
            }
        });
    }

    private Runnable updateDataRunnable = new Runnable() {
        @Override
        public void run() {
            UpdateData();
            handler.postDelayed(this, 1000);
        }
    };

    private void UpdateData() {
        CompletableFuture<String> result = logic.getData();

        result.thenAccept(res -> {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Data yang diterima: " + res);
                    updateTextResponseData(res);
                }
            });
        }).exceptionally(ex -> {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    System.err.println("Terjadi kesalahan: " + ex.getMessage());
                }
            });
            return null;
        });
    }

    private void updateTextResponseData(String content) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(content);
            }
        });
    }
}
