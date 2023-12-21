package com.example.memory_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View.OnClickListener;
public class Start extends Activity   {

    Button mStart;
    Button mExit;
    Button mRecords;
    Button mSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        mStart = (Button)findViewById(R.id.butStart);
        mExit = (Button)findViewById(R.id.butExit);
        mRecords = (Button) findViewById(R.id.butScore);
        mSettings = (Button) findViewById(R.id.butSettings);

        mStart.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        mExit.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecords.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startRecords();
            }
        });
        mSettings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startSettings();
            }
        });
    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
    private void startRecords () {
        Intent i = new Intent(this, Records.class);
        startActivity(i);
    }
    private void startSettings () {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }
}