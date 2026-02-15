package com.example.moodtrackerfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SadFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sad, container, false);
        TextView moodText = view.findViewById(R.id.mood_text);

        if (getArguments() != null) {
            String userName = getArguments().getString("userName");
            if(userName != null && !userName.isEmpty()){
                moodText.setText(userName + " מרגיש עצוב");
            } else {
                moodText.setText("אתה מרגיש עצוב");
            }
        }

        return view;
    }
}
