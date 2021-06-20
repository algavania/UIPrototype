package com.uitest.uiprototype.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uitest.uiprototype.fragment.AccountFragment;
import com.uitest.uiprototype.fragment.BookingsFragment;
import com.uitest.uiprototype.R;
import com.uitest.uiprototype.fragment.ReferFragment;
import com.uitest.uiprototype.fragment.RentFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RentFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.rent_bottomNav:
                    selectedFragment = new RentFragment();
                    break;
                case R.id.booking_bottomNav:
                    selectedFragment = new BookingsFragment();
                    break;
                case R.id.refer_bottomNav:
                    selectedFragment = new ReferFragment();
                    break;
                case R.id.account_bottomNav:
                    selectedFragment = new AccountFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}