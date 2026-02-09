package com.example.moodtrackerfragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HappyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_happy, container, false);
        TextView moodText = view.findViewById(R.id.mood_text);

        if (getArguments() != null) {
            String userName = getArguments().getString("user_name");
            moodText.setText(userName + " מרגיש מצוין");
        }

        return view;
    }
}