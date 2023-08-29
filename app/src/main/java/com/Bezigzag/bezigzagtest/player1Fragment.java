package com.Bezigzag.bezigzagtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentsexample.R;

public class player1Fragment extends Fragment {

    View view;
    Button btn7, btn250, btn4J, btn4Q, btn4K, btn4A, btnWedding, btnRoyalWedding, btnBezigue, btnDoubleBezigue, btnBack;
    boolean hideAndDisableButton = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for the fragment
        view = inflater.inflate(R.layout.fragment_player1, container, false);

        // Declare score buttons

        btn7 = view.findViewById(R.id.btn7);
        btn250 = view.findViewById(R.id.btn250);
        btn4J = view.findViewById(R.id.btn4J);
        btn4Q = view.findViewById(R.id.btn4Q);
        btn4K = view.findViewById(R.id.btn4K);
        btn4A = view.findViewById(R.id.btn4A);
        btnWedding = view.findViewById(R.id.btnWedding);
        btnRoyalWedding = view.findViewById(R.id.btnRoyalWedding);
        btnBezigue = view.findViewById(R.id.btnBezigue);
        btnDoubleBezigue = view.findViewById(R.id.btnDoubleBezigue);
        btnBack = view.findViewById(R.id.btnBack);

        // Method to hide the end round button

        if (getActivity() instanceof Game) {
            Game activity = (Game) getActivity();
            if (activity != null) {
                activity.setBtnEndRoundVisibility(!hideAndDisableButton);
            }
        }


        // Set OnClickListeners for score buttons and back button

        btnBack.setOnClickListener(v -> returnToGame());

        btn7.setOnClickListener(v -> {

            // Get the parent activity (Game) from this fragment

            Game game = (Game) getActivity();

            // Call the p1ScorePts() method of the parent activity to add 10 points to player 1's score

            game.p1ScorePts(10);

            // Exit the current fragment and display the default

            returnToGame();
        });

        btn250.setOnClickListener(v -> {

            Game game = (Game) getActivity();
            game.p1ScorePts(250);
            returnToGame();

        });

        btn4J.setOnClickListener(v -> {

            Game game = (Game) getActivity();
            game.p1ScorePts(40);
            returnToGame();

        });
        btn4Q.setOnClickListener(v -> {

            Game game = (Game) getActivity();
            game.p1ScorePts(60);
            returnToGame();
        });

        btn4K.setOnClickListener(v -> {

            Game game = (Game) getActivity();
            game.p1ScorePts(80);
            returnToGame();
        });

        btn4A.setOnClickListener(v -> {
            Game game = (Game) getActivity();
            game.p1ScorePts(100);
            returnToGame();
        });

        btnWedding.setOnClickListener(v -> {
            Game game = (Game) getActivity();
            game.p1ScorePts(20);
            returnToGame();
        });

        btnRoyalWedding.setOnClickListener(v -> {
            Game game = (Game) getActivity();
            game.p1ScorePts(40);
            returnToGame();
        });

        btnBezigue.setOnClickListener(v -> {
            Game game = (Game) getActivity();
            game.p1ScorePts(40);
            returnToGame();
        });

        btnDoubleBezigue.setOnClickListener(v -> {
            Game game = (Game) getActivity();
            game.p1ScorePts(500);
            returnToGame();
        });

        return view;

    }

    // Method to go back to the help fragment

    private void returnToGame() {

        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.replace(R.id.frameLayout, new helpFragment());
        fr.commit();

    }


}



