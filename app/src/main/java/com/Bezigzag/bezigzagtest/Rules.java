package com.Bezigzag.bezigzagtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentsexample.R;

public class Rules extends AppCompatActivity {

    // Declare different UI elements

    Button btnPreparation, btnDealingCards, btnPhase1, btnPhase2, btnBackMenu;
    TextView txtRuleText;
    ScrollView scrollViewRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        // Initialize different UI elements

        btnPreparation = findViewById(R.id.btnPreparation);
        btnDealingCards = findViewById(R.id.btnDealingCards);
        btnPhase1 = findViewById(R.id.btnPhase1);
        btnPhase2 = findViewById(R.id.btnPhase2);
        btnBackMenu = findViewById(R.id.btnBackMenu);
        txtRuleText = findViewById(R.id.txtRuleText);
        scrollViewRules = findViewById(R.id.scrollViewRules);

        // Set click listeners

        btnPreparation.setOnClickListener(v -> displayRule(R.string.display_preparation));

        btnDealingCards.setOnClickListener(v -> displayRule(R.string.display_dealing));

        btnPhase1.setOnClickListener(v -> displayRule(R.string.display_phase1));

        btnPhase2.setOnClickListener(v -> displayRule(R.string.display_phase2));

        btnBackMenu.setOnClickListener(v -> backToMenu());

    }

    // Method to go back to main menu

    private void backToMenu() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }

    // Method to reset the ScrollView to the top and display the new rule

    private void displayRule(int ruleTextResourceId) {
        scrollViewRules.scrollTo(0, 0);
        txtRuleText.setText(ruleTextResourceId);
    }
}