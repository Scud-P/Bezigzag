//package com.example.fragmentsexample;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class Game2 extends AppCompatActivity {
//
//    Button btn7, btn250, btn4J, btn4Q, btn4K, btn4A, btnWedding,
//            btnRoyalWedding, btnBezigue, btnDoubleBezigue, btnPlayer1, btnPlayer2;
//
//    TextView txtScore1, txtScore2;
//
//    int player1Score = 0;
//    int player2Score = 0;
//
//    String player1ScoreToString, player1Name, player2Name;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game2);
//
//        Intent player1Scoring = getIntent();
//
//        String player1Name = player1Scoring.getStringExtra("updatePlayer1Name");
//        String player2Name = player1Scoring.getStringExtra("updatePlayer2Name");
//
//        btnPlayer1 = findViewById(R.id.btnPlayer1);
//        btnPlayer1.setText(player1Name);
//
//        btnPlayer2 = findViewById(R.id.btnPlayer2);
//        btnPlayer2.setText(player2Name);
//
//
//        btn7 = findViewById(R.id.btn7);
//        btn7.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                score7Points();
//                returnToGame();
//            }
//        }
//        );
//    }
//
//    private void returnToGame() {
//        Intent afterPlayer1Score = new Intent(this, Game.class);
//        player1ScoreToString = String.valueOf(player1Score);
//        afterPlayer1Score.putExtra("UPDATE1", player1ScoreToString);
//        afterPlayer1Score.putExtra("UpdatePlayer1Name", player1Name);
//        afterPlayer1Score.putExtra("UpdatePlayer2Name", player2Name);
//        startActivity(afterPlayer1Score);
//    }
//
//    private void score7Points() {
//        TextView txtScore1 = findViewById(R.id.txtScore1);
//        player1Score += 7;
//        player1ScoreToString = String.valueOf(player1Score);
//        txtScore1.setText(player1ScoreToString);
//
//    }
//}
