package com.example.android.puzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        TextView resultDisplayText=(TextView)findViewById(R.id.result_text);
        Bundle b1=getIntent().getExtras();
        String resultStr=b1.getString("result");
        resultDisplayText.setText(resultStr);

        Button playAgain=(Button)findViewById(R.id.play_again_button);
        // Set a click listener on play_button
        playAgain.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the play_button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PuzzleActivity}
                Intent playAgainIntent = new Intent(DisplayResultActivity.this, PuzzleActivity.class);

                // Start the new activity
                startActivity(playAgainIntent);
            }
        });
    }
}
