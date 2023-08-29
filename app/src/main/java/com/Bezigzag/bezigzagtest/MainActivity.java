package com.Bezigzag.bezigzagtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentsexample.R;

public class MainActivity extends AppCompatActivity {

    // Declare buttons

    Button btn2PlayersGame, btnEnglish, btnFrench, btnRules;

    // Set the view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons

        btn2PlayersGame = findViewById(R.id.btn2PlayersGame);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnFrench = findViewById(R.id.btnFrench);
        btnRules = findViewById(R.id.btnRules);

        // Set Click Listeners

        btn2PlayersGame.setOnClickListener(
                v -> create2PlayersGame()
        );

        btnRules.setOnClickListener(
                v -> displayRules()
        );

        btnEnglish.setOnClickListener(
                v -> {
                    LanguageHelper.changeLanguage(MainActivity.this, "en");
                    recreate();
                }
        );

        btnFrench.setOnClickListener(
                v -> {
                    LanguageHelper.changeLanguage(MainActivity.this, "fr");
                    recreate();
                }
        );

        btnRules.setOnClickListener(v -> displayRules());

    }

    // Method to start the game by switching to the Game Activity

    private void create2PlayersGame() {
        Intent switchActivityIntent = new Intent(this, TwoPlayersMenu.class);
        startActivity(switchActivityIntent);
    }

    // Method to switch to the Rules activity

    private void displayRules() {
        Intent switchActivityIntent = new Intent(this, Rules.class);
        startActivity(switchActivityIntent);
    }

}


