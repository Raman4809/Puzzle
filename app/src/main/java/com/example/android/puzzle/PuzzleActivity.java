package com.example.android.puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PuzzleActivity extends AppCompatActivity {
    int baseValue=0;
    int firstValue=0;
    int thirdValue=0;
    int systemResult=0;
    int userResult=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        //create a random object
        Random rand = new Random();
        baseValue = rand.nextInt(10) + 50;
        firstValue = rand.nextInt(10) + baseValue-10;
        thirdValue = rand.nextInt(10) + baseValue;

        display(firstValue, baseValue, thirdValue);
        findResult(firstValue, baseValue, thirdValue);

    }

    private void display(int first, int base, int third){
        TextView firstTextView = (TextView) findViewById(R.id.element_first);
        firstTextView.setText("" + first);
        TextView secondTextView = (TextView) findViewById(R.id.element_second);
        secondTextView.setText("" + base);
        TextView thirdTextView = (TextView) findViewById(R.id.element_third);
        thirdTextView.setText("" + third);
    }
    public void findResult(int first, int base, int third){
        int diff1=base-first;
        int diff2=third-base;

        if(diff1<diff2){
            systemResult=diff2;

        }
        else{
            systemResult=diff1;
        }
    }

    public void firstResultStored(View view) {
        userResult=baseValue-firstValue;
        //new PuzzleActivity().checkResult(systemResult, userResult);

    }
    public void thirdResultStored(View view) {
        userResult=thirdValue-baseValue;
        //new PuzzleActivity().checkResult(systemResult, userResult);
    }

    public void checkResult(View view) {

        if(systemResult==userResult){
            Intent displayResultIntent = new Intent(PuzzleActivity.this, DisplayResultActivity.class);
            displayResultIntent.putExtra("result", "You are right!!");
            startActivity(displayResultIntent);
        }
        else{
            Intent displayResultIntent = new Intent(PuzzleActivity.this, DisplayResultActivity.class);
            displayResultIntent.putExtra("result", "Wrong ans");
            startActivity(displayResultIntent);
        }


    }
}
