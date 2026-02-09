package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout nameInputLayout = findViewById(R.id.name_input_layout);
        EditText nameEditText = findViewById(R.id.name_edit_text);
        Button submitNameButton = findViewById(R.id.submit_name_button);
        View fragmentContainer = findViewById(R.id.fragment_container);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        submitNameButton.setOnClickListener(v -> {
            userName = nameEditText.getText().toString();
            if (!userName.isEmpty()) {
                nameInputLayout.setVisibility(View.GONE);
                fragmentContainer.setVisibility(View.VISIBLE);
                bottomNav.setVisibility(View.VISIBLE);

                // Load default fragment
                HappyFragment initialFragment = new HappyFragment();
                Bundle bundle = new Bundle();
                bundle.putString("user_name", userName);
                initialFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.fragment_container, initialFragment)
                        .commit();
            }
        });

        Bundle bundle = new Bundle();
        bundle.putString("user_name", userName);
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

                selectedFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.fragment_container, selectedFragment)
                        .addToBackStack(null)
                        .commit();
            }
            return true;
        });
    }
}