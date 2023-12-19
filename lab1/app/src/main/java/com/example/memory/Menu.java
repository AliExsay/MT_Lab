package com.example.memory;

import static com.example.memory.R.id.start;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {
    Button mStart;
    Button mExit;


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        mStart = (Button)findViewById(R.id.start);
        mExit = (Button)findViewById(R.id.exit);

        mStart.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        mExit.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
}

