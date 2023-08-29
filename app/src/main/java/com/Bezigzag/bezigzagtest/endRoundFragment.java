package com.Bezigzag.bezigzagtest;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.fragmentsexample.R;


public class endRoundFragment extends Fragment {

    // declare UI elements and variables

    final int dixDeDer = 10;
    View view;
    Button btnNextRound;
    RadioGroup radioGrp;
    RadioButton radioPlayer1, radioPlayer2;
    EditText edtPlayer1AcesTens, edtPlayer2AcesTens;
    int p2BonusPoints = 0, p1BonusPoints = 0;
    String p1BonusPtsToString, p2BonusPtsToString;
    boolean hideAndDisableButton = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_end_round, container, false);

        // Initialize UI elements

        radioGrp = view.findViewById(R.id.radioGrp);
        edtPlayer1AcesTens = view.findViewById(R.id.edtPlayer1AcesTens);
        edtPlayer2AcesTens = view.findViewById(R.id.edtPlayer2AcesTens);
        btnNextRound = view.findViewById(R.id.btnNextRound);
        radioPlayer1 = view.findViewById(R.id.radioPlayer1);
        radioPlayer2 = view.findViewById(R.id.radioPlayer2);

        // Call the hideKeyboard() method to hide the keyboard by default when the view is created

        view.setOnClickListener(v -> hideKeyboard());


        if (getActivity() instanceof Game) {
            Game activity = (Game) getActivity();
            if (activity != null) {

                // Disable the end round button visibility when switched to this fragment

                activity.setBtnEndRoundVisibility(!hideAndDisableButton);

                // Retrieve the player names from the Game Activity, pass them to the radioPlayer

                String player1Name = activity.getPlayer1Name();
                String player2Name = activity.getPlayer2Name();

                radioPlayer1 = view.findViewById(R.id.radioPlayer1);
                radioPlayer2 = view.findViewById(R.id.radioPlayer2);

                radioPlayer1.setText(player1Name);
                radioPlayer2.setText(player2Name);
            }
        }

        // Click listener for the btnNextRound that checks conditions to attribute points to players
        // or create warning toasts to prevent human error

        btnNextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkDixDeDerAttribution() && checkBonusPointsAttribution()) {

                    // Methods to attribute points

                    p1ScoreBonusPts();
                    p2ScoreBonusPts();
                    p1ScoreDixDeDer();
                    p2ScoreDixDeDer();

                    // Method to check if one player would pass the 1500 points mark
                    // the method is located in the Game activity

                    checkForWinner();

                    // Display warning toasts based on unmet conditions

                } else if (!checkBonusPointsAttribution() && !checkDixDeDerAttribution()) {
                    String combinedWarning = getString(R.string.both_warnings_toast);
                    Toast bothWarnings = Toast.makeText(getContext(), combinedWarning, Toast.LENGTH_LONG);
                    bothWarnings.setGravity(Gravity.CENTER, 0, 375);
                    bothWarnings.show();

                } else if (checkBonusPointsAttribution() && !checkDixDeDerAttribution()) {
                    String dixDeDer = getString(R.string.last_trick_warning_toast);
                    Toast dixDeDerWarning = Toast.makeText(getContext(), dixDeDer, Toast.LENGTH_LONG);
                    dixDeDerWarning.setGravity(Gravity.CENTER, 0, 375);
                    dixDeDerWarning.show();
                } else {
                    String bonusPoints = getString(R.string.bonus_points_warning_toast);
                    Toast dixDeDerWarning = Toast.makeText(getContext(), bonusPoints, Toast.LENGTH_LONG);
                    dixDeDerWarning.setGravity(Gravity.CENTER, 0, 375);
                    dixDeDerWarning.show();
                }
            }

            // Call the announceWinner() method from the Game activity when a player

            private void checkForWinner() {
                Game checkWinner = (Game) getActivity();
                checkWinner.announceWinner();

            }
        });

        return view;
    }

    // Method to hide the keyboard when it could alter visibility

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = requireActivity().getCurrentFocus();
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }

    }

    // method to check that the correct amount of bonus points is awarded to the players
    // there are 8 Aces and 8 Tens in the deck so the total must amount to 16

    private boolean checkBonusPointsAttribution() {

        p2BonusPtsToString = edtPlayer2AcesTens.getText().toString();
        p2BonusPoints = tryParse(p2BonusPtsToString);
        p1BonusPtsToString = edtPlayer1AcesTens.getText().toString();
        p1BonusPoints = tryParse(p1BonusPtsToString);

        return p2BonusPoints + p1BonusPoints == 16;
    }

    // method to make sure the last trick bonus has been assigned to one of the players
    // by checking on of the two radio buttons

    private boolean checkDixDeDerAttribution() {
        return radioPlayer2.isChecked() || radioPlayer1.isChecked();
    }

// methods to award bonus points

    private void p2ScoreDixDeDer() {
        if (radioPlayer2.isChecked()) {
            Game p2ScoreDDD = (Game) getActivity();
            p2ScoreDDD.p2ScorePts(dixDeDer);
        }
    }

    private void p1ScoreDixDeDer() {
        if (radioPlayer1.isChecked()) {
            Game p1ScoreDDD = (Game) getActivity();
            p1ScoreDDD.p1ScorePts(dixDeDer);
        }
    }

    private void p2ScoreBonusPts() {
            Game p2ScoreBonusPoints = (Game) getActivity();
            p2ScoreBonusPoints.p2ScorePts(p2BonusPoints * 10);
        }


    private void p1ScoreBonusPts() {
            Game p1ScoreBonusPoints = (Game) getActivity();
            p1ScoreBonusPoints.p1ScorePts(p1BonusPoints * 10);
    }

    // Method to avoid getting a NumberFormatException while parsing a null object if one of the
    // players didn't collect any aces or tens at the end of the round. If the EditText is left
    // blank, it is considered as a 0.

    Integer tryParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            return 0;
        }

    }

}




