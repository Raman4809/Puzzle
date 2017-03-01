package com.example.android.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView instruction;
    Button play;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instruction = (TextView)findViewById(R.id.instruction_text);
        String str="You have to find the distance of left and right numbers from the base";
        instruction.setText(str);
        play=(Button)findViewById(R.id.play_button);
        // Set a click listener on play_button
        play.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play_button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PuzzleActivity}
                Intent puzzleIntent = new Intent(MainActivity.this, PuzzleActivity.class);

                // Start the new activity
                startActivity(puzzleIntent);
            }
        });

    }
}
