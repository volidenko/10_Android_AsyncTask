package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=(TextView)findViewById(R.id.textView);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        Calendar c=Calendar.getInstance();
                        int hours=c.get(Calendar.HOUR_OF_DAY);
                        int minutes=c.get(Calendar.MINUTE);
                        int seconds=c.get(Calendar.SECOND);
                        String time=hours+":"+minutes+":"+seconds;
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(time);
                            }
                        });
                    }
                };
                Thread thread=new Thread(runnable);
                thread.start();
            }
        });
    }
}