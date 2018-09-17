package com.example.tana5915.ramenbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StartScreen extends AppCompatActivity implements View.OnClickListener {
public long time;
Button one;
Button three;
Button two;


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
              time = 120000;
              break;
            }
            case R.id.two:
            {
                time = 150000;
                break;
            }
            case R.id.three:
            {
                time = 180000;
                break;
            }


        }
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(StartScreen.this, TimerScreen.class);
        intent.putExtra("startTime", time);
        startActivity(intent);
    }

}
