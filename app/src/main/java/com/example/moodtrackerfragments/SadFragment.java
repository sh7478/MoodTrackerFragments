package com.example.moodtrackerfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SadFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sad, container, false);
        TextView moodText = view.findViewById(R.id.mood_text);

        if (getArguments() != null) {
            String userName = getArguments().getString("user_name");
            moodText.setText(userName + " מרגיש מצוין");
        }

        return view;
    }
}