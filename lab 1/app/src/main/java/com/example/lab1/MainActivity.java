package com.example.lab1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import android.os.SystemClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private GridAdapter gridAdapter;
    private TextView stepsView;
    private Chronometer timeView;

    private Integer steps;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.field);
        gridView.setNumColumns(4);
        gridView.setEnabled(true);

        stepsView = findViewById(R.id.steps_view);
        timeView = findViewById(R.id.time_view);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        stepsView.setTypeface(typeface);
        timeView.setTypeface(typeface);

        steps = 0;
        stepsView.setText(steps.toString());

        timeView.start();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gridAdapter.checkOpenCells();
                if (gridAdapter.openCell(i)) {
                    steps++;
                    stepsView.setText(steps.toString());
                }

                if (gridAdapter.checkGameOver()) {
                    timeView.stop();
                    ShowGameOver();
                }
            }
        });

        gridAdapter = new GridAdapter(this, 5, 4);
        gridView.setAdapter(gridAdapter);
    }
    private String formatTime(long elapsedMillis) {
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis % 3600000) / 60000;
        int seconds = (int) (elapsedMillis % 60000) / 1000;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private void ShowGameOver() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Congratulations!");
        long elapsedMillis = SystemClock.elapsedRealtime() - timeView.getBase();
        String dialogMessage = "Game over!\nSteps: " + steps + "\nTime: " + formatTime(elapsedMillis);
        dialog.setMessage(dialogMessage);

        dialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.show();
    }
}