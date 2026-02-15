package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);


        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_happy) {
                selectedFragment = new HappyFragment();
            } else if (id == R.id.nav_neutral) {
                selectedFragment = new NeutralFragment();
            } else if (id == R.id.nav_sad) {
                selectedFragment = new SadFragment();
            }

            if (selectedFragment != null) {
                String userName = name.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("userName", userName);
                selectedFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HappyFragment())
                    .commit();
        }
    }
}