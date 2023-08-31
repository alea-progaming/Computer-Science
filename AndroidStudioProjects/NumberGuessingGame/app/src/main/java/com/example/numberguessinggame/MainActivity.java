package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int result, guessCount = 0, min = 0, max = 100;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random() * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }
    public void clickFunction(View view)
    {
        guessCount++;

        int userGuessing;
        EditText variable = (EditText)findViewById(R.id.editId);
        userGuessing = Integer.parseInt(variable.getText().toString());

        if (userGuessing < result) {

            makeToast("Wrong! Pick a higher number.");
        }
        else if (userGuessing > result) {
            makeToast("Wrong! Pick a lower number.");
        }
        else {
            makeToast("Congratulations! You got the number in " + guessCount + " attempts");
        }
        TextView guessCountTextView = findViewById(R.id.guessCountTextView);
        guessCountTextView.setText("Number of Guesses: " + guessCount);

        // reset button
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editId = findViewById(R.id.editId);
                editId.setText("");
                guessCount = 0;
                TextView guessCountTextView = findViewById(R.id.guessCountTextView);
                guessCountTextView.setText("Number of Guesses: ");
                result = getRandomNumber(min, max);
            }
        });

    }



    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = getRandomNumber(min, max);
    }
}
