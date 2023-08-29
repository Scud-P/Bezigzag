package com.Bezigzag.bezigzagtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentsexample.R;

public class player2Fragment extends Fragment {

    View view;
    Button btn7, btn250, btn4J, btn4Q, btn4K, btn4A, btnWedding, btnRoyalWedding, btnBezigue, btnDoubleBezigue, btnBack2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_player2, container, false);

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
        btnBack2 = view.findViewById(R.id.btnBack);
        boolean hideAndDisableButton = true;

        if (getActivity() instanceof Game) {
            Game activity = (Game) getActivity();
            if (activity != null) {
                activity.setBtnEndRoundVisibility(!hideAndDisableButton);
            }
        }

        btnBack2.setOnClickListener(v -> p2ReturnToGame());

        btn7.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(10);
            p2ReturnToGame();
        });

        btn250.setOnClickListener(v -> {

            Game game2 = (Game) getActivity();
            game2.p2ScorePts(250);
            p2ReturnToGame();

        });

        btn4J.setOnClickListener(v -> {

            Game game2 = (Game) getActivity();
            game2.p2ScorePts(40);
            p2ReturnToGame();

        });
        btn4Q.setOnClickListener(v -> {

            Game game2 = (Game) getActivity();
            game2.p2ScorePts(60);
            p2ReturnToGame();
        });

        btn4K.setOnClickListener(v -> {

            Game game2 = (Game) getActivity();
            game2.p2ScorePts(80);
            p2ReturnToGame();
        });

        btn4A.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(100);
            p2ReturnToGame();
        });

        btnWedding.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(20);
            p2ReturnToGame();
        });

        btnRoyalWedding.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(40);
            p2ReturnToGame();
        });

        btnBezigue.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(40);
            p2ReturnToGame();
        });

        btnDoubleBezigue.setOnClickListener(v -> {
            Game game2 = (Game) getActivity();
            game2.p2ScorePts(500);
            p2ReturnToGame();
        });

        return view;
    }

    private void p2ReturnToGame() {
        FragmentTransaction fr2 = getParentFragmentManager().beginTransaction();
        fr2.replace(R.id.frameLayout, new helpFragment());
        fr2.commit();

    }
}