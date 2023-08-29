package com.Bezigzag.bezigzagtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentsexample.R;

public class TwoPlayersMenu extends AppCompatActivity {

    // Declare different UI elements

    EditText edtPlayer1Name, edtPlayer2Name;
    TextView txtPlayer1Name, txtPlayer2Name, txtVersus;
    Button btnStart2PlayersGame, btnSavePlayersNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_players_menu);

        // Initialize different UI elements

        btnStart2PlayersGame = findViewById(R.id.btnStart2PlayersGame);
        btnSavePlayersNames = findViewById(R.id.btnSavePlayersNames);

        edtPlayer1Name = findViewById(R.id.edtPlayer1Name);
        edtPlayer2Name = findViewById(R.id.edtPlayer2Name);

        txtPlayer1Name = findViewById(R.id.txtPlayer1Name);
        txtPlayer2Name = findViewById(R.id.txtPlayer2Name);
        txtVersus = findViewById(R.id.txtVersus);

        // Set onClickListener for the SavePlayerNames button
        // when the button is clicked, the player names are saved and displayed in the
        // corresponding two TextViews, the Versus TextView is made visible


        btnSavePlayersNames.setOnClickListener(view -> {
            String Player1NameStored = edtPlayer1Name.getText().toString();
            String Player2NameStored = edtPlayer2Name.getText().toString();
            txtPlayer1Name.setText(Player1NameStored);
            txtPlayer2Name.setText(Player2NameStored);
            txtVersus.setVisibility(View.VISIBLE);
            hideKeyboard();
        });

        // Set onClickListener to start the game

        btnStart2PlayersGame.setOnClickListener(v -> start2PlayersGame()
        );
    }

    // method to start the Game.Activity and pass over the player names

    private void start2PlayersGame() {
        Intent intent = new Intent(this, Game.class);
        String message = txtPlayer1Name.getText().toString();
        String message2 = txtPlayer2Name.getText().toString();
        intent.putExtra("EXTRA_MESSAGE", message);
        intent.putExtra("EXTRA_MESSAGE2", message2);
        startActivity(intent);
    }

    // method to automatically hide the keyboard. It is called when the button to save player
    // names is pressed so the button to start the game is not hidden by the keyboard

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}

