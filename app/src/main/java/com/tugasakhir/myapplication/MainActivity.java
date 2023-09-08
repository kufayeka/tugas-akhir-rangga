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
    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi fragment
        fragment1 = new MonitoringViewFragment();
        fragment2 = new AutomaticViewFragment();
        fragment3 = new ManualViewFragment();

        // Tampilkan fragment pertama saat Activity pertama kali dibuat
        activeFragment = fragment1;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, activeFragment)
                .commit();

        // Inisialisasi BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);


        // Add Listener untuk item-menu yang diklik
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_monitoring:
                        selectedFragment = fragment1;
                        break;
                    case R.id.navigation_automatic:
                        selectedFragment = fragment2;
                        break;
                    case R.id.navigation_manual:
                        selectedFragment = fragment3;
                        break;
                }

                if (selectedFragment != null && selectedFragment != activeFragment) {
                    // Ganti fragment hanya jika bukan fragment yang aktif saat ini
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    activeFragment = selectedFragment;
                }

                return true;
            }
        });
    }
}
