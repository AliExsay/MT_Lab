package com.example.lab1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private CardAdapter adapter;
    private TextView movesTextView;
    private TextView timerTextView;
    private Timer timer;
    private long startTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView gridView = findViewById(R.id.gridLayout);
        movesTextView = findViewById(R.id.movesTextView);
        timerTextView = findViewById(R.id.timerTextView);
        gridView.setNumColumns(4);

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cards.add(new Card("card" + (i + 1)));
            cards.add(new Card("card" + (i + 1)));
        }
        Collections.shuffle(cards);

        adapter = new CardAdapter(this, cards, this);
        gridView.setAdapter(adapter);

        // Установка начальных значений для infoTextView и timerTextView
        movesTextView.setText(getString(R.string.moves, numberOfMoves()));
        timerTextView.setText(getString(R.string.timer, "0:00"));

        startTimer();
    }

    // Метод для отображения диалога поздравления
    protected void showCongratulationsDialog(final int numberOfMoves) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("KITSYLO:Поздравляем!")
                .setMessage("Результаты\nВремя: " +
                        timerTextView.getText().toString().substring(timerTextView.getText().toString().indexOf(" ")
                        + 1) + "\nХодов: " + numberOfMoves)
                .setPositiveButton("Закрыть", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("Перезапустить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        restartGame();
                    }
                })
                .create()
                .show();
    }
    // Метод для обновления информации о времени и количестве ходов
    private void updateInfoText(long elapsedTimeMillis) {
        int seconds = (int) (elapsedTimeMillis / 1000) % 60;
        int minutes = (int) ((elapsedTimeMillis / (1000 * 60)) % 60);
        String timeFormatted = String.format("%d:%02d", minutes, seconds);

        // Обновление информации
        movesTextView.setText(getString(R.string.moves, numberOfMoves()));
        timerTextView.setText(getString(R.string.timer, timeFormatted));
    }
    private void startTimer() {
        timer = new Timer();
        startTimeMillis = SystemClock.elapsedRealtime(); // Установка начального времени
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long currentTimeMillis = SystemClock.elapsedRealtime();
                long elapsedTimeMillis = currentTimeMillis - startTimeMillis;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateInfoText(elapsedTimeMillis);
                    }
                });

                if (areAllCardsRemoved()) {
                    // Если все карты удалены, останавливаем таймер
                    timer.cancel();
                }
            }
        }, 0, 1000); // Обновляем каждую секунду
    }
    private boolean areAllCardsRemoved() {
        return adapter.areAllCardsRemoved();
    }
    private int numberOfMoves(){
        return adapter.getNumberOfMoves();
    }
    private void restartGame() {
        adapter.resetGame(); // Перезапуск игры в адаптере
        movesTextView.setText(getString(R.string.moves, 0));
        timerTextView.setText(getString(R.string.timer, "0:00"));
        startTimer(); // Запуск таймера заново
    }
}
