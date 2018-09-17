package com.example.tana5915.ramenbot;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerScreen extends AppCompatActivity {
    private TextView countDownText;
    private Button startButton;

    private CountDownTimer countDownTimer;
    private long timeleft = 60000;//1 min
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_screen);

        countDownText = findViewById(R.id.countDownText);

        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
    }
    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();

        }
        else
        {
            startTimer();

        }

    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long l) {
                timeleft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        startButton.setText("STOP");
        timerRunning= true;

    }

    public void stopTimer() {
        countDownTimer.cancel();
        timerRunning=false;
        startButton.setText("START");
    }

    public void updateTimer()
    {
        int minutes = (int)timeleft/60000;
        int seconds = (int)timeleft%60000/1000;

        String timeLeftText;
        timeLeftText = "" +minutes +":";
        if(seconds<10)
        {
            timeLeftText+= "0";
        }
        timeLeftText += seconds;
        countDownText.setText(timeLeftText);
    }
}
