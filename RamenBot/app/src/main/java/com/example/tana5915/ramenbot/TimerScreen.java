package com.example.tana5915.ramenbot;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerScreen extends AppCompatActivity {
    private TextView countDownText;
    private Button startButton;

    private CountDownTimer countDownTimer;
    private long timeleft;
    private boolean timerRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_screen);
        countDownText = findViewById(R.id.countDownText);
        Log.d("RamenBot","IntentTime: "+ getIntent().getIntExtra("startTime",0));
        timeleft = (long)getIntent().getIntExtra(StartScreen.id,0);
        timeleft = 10050;
        startButton = findViewById(R.id.startButton);
        startTimer();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
        Log.d("RamenBot", "TimerScreen: time "+timeleft);

    }
    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();

        }
        else
        {
            updateTimer();
            startTimer();

        }

    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long l) {
                timeleft = (long)Math.ceil(l);
                Log.d("RamenBot","TimerScreen:"+timeleft);
                updateTimer();
            }

            @Override
            public void onFinish() {
                timeleft-=1000;
                Log.d("RamenBot","TimerScreen:"+timeleft);

                updateTimer();

              //  countDownText.setText("0:00");
                /*Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();*/
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
        int minutes = (int)(timeleft/60000.0);
        int seconds = (int)(timeleft%60000.0/1000.0);

        String timeLeftText;
        timeLeftText = "" +minutes +":";

        if(seconds<10)
        {
            timeLeftText+= "0";
        }
        timeLeftText += seconds;
        countDownText.setText(timeLeftText);
        if(minutes<=0&&seconds<=0) {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        }
    }
}
