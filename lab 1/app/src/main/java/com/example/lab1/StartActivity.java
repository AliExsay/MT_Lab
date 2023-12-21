package com.example.lab1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    private TextView titleView;
    private Button startButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        titleView = findViewById(R.id.title_view);
        startButton = findViewById(R.id.start_button);
        exitButton = findViewById(R.id.exit_button);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        titleView.setTypeface(typeface);
        startButton.setTypeface(typeface);
        exitButton.setTypeface(typeface);



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void startGame() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
