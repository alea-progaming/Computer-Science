package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewAttemptsLeft;
    private EditText editTextGuessNumber;
    private Button buttonGuess;
    private Button buttonPlayAgain;
    private TextView textViewResult;

    private int randomNumber;
    private int attemptsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAttemptsLeft = findViewById(R.id.text_view_attempts_left);
        editTextGuessNumber = findViewById(R.id.edit_text_guess_number);
        buttonGuess = findViewById(R.id.button_guess);
        buttonPlayAgain = findViewById(R.id.button_play_again);
        textViewResult = findViewById(R.id.text_view_result);

        generateRandomNumber();
        generateRandomAttempts();
        updateAttemptsLeft();

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private void generateRandomAttempts() {
        Random random = new Random();
        attemptsLeft = random.nextInt(4) + 7;
    }

    private void updateAttemptsLeft() {
        textViewAttemptsLeft.setText("Attempts left: " + attemptsLeft);
    }

    private void checkGuess() {
        int guessNumber = Integer.parseInt(editTextGuessNumber.getText().toString().trim());
        if (guessNumber == randomNumber) {
            textViewResult.setText("Congratulations! You guessed the number.");
            gameOver();
        } else {
            attemptsLeft--;
            if (attemptsLeft == 0) {
                textViewResult.setText("Game over. You have no attempts left.");
                gameOver();
            } else if (guessNumber < randomNumber) {
                textViewResult.setText("Try again. The number is higher.");
                updateAttemptsLeft();
            } else if (guessNumber > randomNumber) {
                textViewResult.setText("Try again. The number is lower.");
                updateAttemptsLeft();
            }
        }
        editTextGuessNumber.setText("");
    }

    private void gameOver() {
        editTextGuessNumber.setEnabled(false);
        buttonGuess.setEnabled(false);
        buttonPlayAgain.setVisibility(View.VISIBLE);
    }

    private void resetGame() {
        generateRandomNumber();
        generateRandomAttempts();
        updateAttemptsLeft();
        editTextGuessNumber.setEnabled(true);
        buttonGuess.setEnabled(true);
        buttonPlayAgain.setVisibility(View.GONE);
        textViewResult.setText("");
    }
}