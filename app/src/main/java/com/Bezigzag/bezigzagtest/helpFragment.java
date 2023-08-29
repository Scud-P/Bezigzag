package com.Bezigzag.bezigzagtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fragmentsexample.R;

public class helpFragment extends Fragment {

    View view;
    boolean hideAndDisableButton = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_help, container, false);

        // Conditional statement to show the End Round button when this fragment is active
        // the button is disabled when the player1 and player2 fragments are active

        if (getActivity() instanceof Game) {
            Game activity = (Game) getActivity();
            if (activity != null) {
                activity.setBtnEndRoundVisibility(!hideAndDisableButton);
            }
        }

        return view;

    }

}