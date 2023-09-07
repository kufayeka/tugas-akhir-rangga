package com.tugasakhir.myapplication.ui.automatic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tugasakhir.myapplication.R;

public class AutomaticViewController {

    private AutomaticViewLogic logic;

    private TextView textView;
    private Button btnStart;
    private Button btnStop;

    public AutomaticViewController(View view){
        final AutomaticViewController self = this;
        this.logic = new AutomaticViewLogic();

        this.textView = view.findViewById(R.id.text_response_data);
        this.btnStart = view.findViewById(R.id.button_start);
        this.btnStop = view.findViewById(R.id.button_stop);

        // handle logic tombol start
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // panggil logic getData di class AutomaticViewLogic
                // hasilnya di tampilin ke layar lewat method updateTextResponseData (harus diawali self dulu!)
                logic.getData(new AutomaticViewLogic.DataCallback() {
                    @Override
                    public void onDataReceived(String x) {
                        self.updateTextResponseData(x);
                    }
                });
            }
        });

        // handle logic tombol stop
        this.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ganti jadi tulisan lain
                self.updateTextResponseData("ini tombol stop");
            }
        });
    }

    public void updateTextResponseData(String content){
        textView.setText(content);
    }


}
