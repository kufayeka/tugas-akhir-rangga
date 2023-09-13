package com.tugasakhir.myapplication.ui.monitoring;

public class MonitoringViewController {

    private MonitoringViewLogic logic;

    public MonitoringViewController() {
        // get data dari antares -> response -> UI ** diulang tiap 0.5 detik (realtime)
        logic = new MonitoringViewLogic();

        getDataRealtime();
    }

    ////////////////////////////////////////
    public void getDataRealtime(){
        String x = logic.getData();
    }
}
