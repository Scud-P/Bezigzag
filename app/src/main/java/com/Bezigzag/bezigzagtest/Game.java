package com.Bezigzag.bezigzagtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentsexample.R;

public class Game extends AppCompatActivity {

    // Declare different UI elements and variables

    Button btnPlayer1, btnPlayer2, btnEndRound;
    int player1Score, player2Score, winnerScore;
    TextView txtScore1, txtScore2;
    String player1Name, player2Name, player1ScoreToString, player2ScoreToString, winnerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        // Initiate the default fragment

        initiateFragment(new helpFragment());

        // Get the player names based on the user's input from the TwoPlayersMenu Activity

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE");
        String message2 = intent.getStringExtra("EXTRA_MESSAGE2");

        btnPlayer1 = findViewById(R.id.btnPlayer1);
        btnPlayer1.setText(message);

        btnPlayer2 = findViewById(R.id.btnPlayer2);
        btnPlayer2.setText(message2);

        player1Name = message;
        player2Name = message2;

        Button btnEndRound = findViewById(R.id.btnEndRound);

        // OnClickListener to replace the help fragment with the fragment where the first player scores

        btnPlayer1.setOnClickListener(v -> initiateFragment(new player1Fragment()));

        // OnClickListener to replace the help fragment with the fragment where the second player scores

        btnPlayer2.setOnClickListener(v -> initiateFragment(new player2Fragment()));

        // OnClickListener to switch to end of round fragment

        btnEndRound.setOnClickListener(v -> initiateFragment(new endRoundFragment()));

    }

    // Method to replace the fragment


    private void initiateFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    // Method for Player2 Score

    public void p2ScorePts(Integer i) {
        TextView txtScore2 = findViewById(R.id.txtScore2);
        player2Score += i;
        player2ScoreToString = String.valueOf(player2Score);
        txtScore2.setText(player2ScoreToString);
    }


    // Method for Player1 Score

    public void p1ScorePts(Integer i) {
        TextView txtScore1 = findViewById(R.id.txtScore1);
        player1Score += i;
        player1ScoreToString = String.valueOf(player1Score);
        txtScore1.setText(player1ScoreToString);
    }

    // Method to switch to the end game activity when a player reaches 1500 points

    public void announceWinner() {
        if (player1Score >= 1500 || player2Score >= 1500) {
            if (player1Score > player2Score) {
                winnerScore = player1Score;
                winnerName = player1Name;
            } else {
                winnerScore = player2Score;
                winnerName = player2Name;
            }

            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra("WINNER_SCORE", winnerScore);
            intent.putExtra("WINNER_NAME", winnerName);
            startActivity(intent);
        } else {
            initiateFragment(new helpFragment());
        }
    }

// method to show/hide end round button and render it not clickable
// when awarding points in the player1Fragment and player2Fragment

    public void setBtnEndRoundVisibility(boolean isVisible) {
        Button btnEndRound = findViewById(R.id.btnEndRound);
        btnEndRound.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        btnEndRound.setClickable(isVisible);
    }

    // getter method so the names of the players are accessible from other classes

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}

