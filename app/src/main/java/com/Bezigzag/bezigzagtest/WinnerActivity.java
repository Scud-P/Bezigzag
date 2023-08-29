package com.Bezigzag.bezigzagtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentsexample.R;

public class WinnerActivity extends AppCompatActivity {

    // Declare the button

    Button btnBackToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        // initialize the TextViews

        TextView txtWinnerName = findViewById(R.id.txtWinnerName);
        TextView txtWinnerScore = findViewById(R.id.txtWinnerScore);

        // get the Winner name and score from the end round fragment

        Intent winner = getIntent();
        String winnerName = winner.getStringExtra("WINNER_NAME");
        int winnerScore = winner.getIntExtra("WINNER_SCORE", 0);
        txtWinnerName.setText(winnerName);
        txtWinnerScore.setText(String.valueOf(winnerScore));

        // initialize and set the click listener of the button

        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        btnBackToMenu.setOnClickListener(v -> backToMenu());
    }

    // Method to go back to the main menu when the game is over

    private void backToMenu() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }
}