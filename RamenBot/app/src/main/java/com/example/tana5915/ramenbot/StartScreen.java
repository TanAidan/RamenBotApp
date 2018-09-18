package com.example.tana5915.ramenbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;

public class StartScreen extends AppCompatActivity implements View.OnClickListener {
public int time;
Button one;
Button three;
Button two;
public static String id ="com.android.StartScreen.sendMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
      one.setOnClickListener(this);
      two.setOnClickListener(this);
      three.setOnClickListener(this);
    }
    public void onClick(View v){

        switch(v.getId())
        {
            case R.id.one:
            {
              time = 150000;

              break;
            }
            case R.id.two:
            {
                time = 180000;
                break;
            }
            case R.id.three:
            {
                time = 210000;
                break;
            }


        }
        Log.d("RamenBot", "StartScreen: time "+time);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, TimerScreen.class);
        intent.putExtra(id,time);
        Log.d("RamenBot", "StartScreen: time "+time);
        startActivity(intent);
    }

}
