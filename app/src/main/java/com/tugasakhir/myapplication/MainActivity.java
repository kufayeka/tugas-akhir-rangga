package com.tugasakhir.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tugasakhir.myapplication.ui.automatic.AutomaticViewFragment;
import com.tugasakhir.myapplication.ui.manual.ManualViewFragment;
import com.tugasakhir.myapplication.ui.monitoring.MonitoringViewFragment;


public class MainActivity extends AppCompatActivity {

    private Fragment fragment1, fragment2, fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi fragment
        fragment1 = new MonitoringViewFragment();
        fragment2 = new AutomaticViewFragment();
        fragment3 = new ManualViewFragment();

        // Tampilkan fragment pertama saat Activity pertama kali dibuat
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment1)
                .commit();

        // Inisialisasi BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        // Add Listener untuk item-menu yang diklik
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_monitoring: // Tampilkan Fragment1
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment1)
                                .commit();
                        return true;
                    case R.id.navigation_automatic: // Tampilkan Fragment2
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment2)
                                .commit();
                        return true;
                    case R.id.navigation_manual: // Tampilkan Fragment3
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, fragment3)
                                .commit();
                        return true;
                }
                return false;
            }
        });

    }
}
