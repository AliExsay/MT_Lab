package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startNewActivity(View v){
        // Запуск анимации увеличения
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        v.startAnimation(scaleUp);

        // Запуск анимации уменьшения через Handler с задержкой (чтобы анимация уменьшения проигралась после анимации увеличения)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation scaleDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down);
                v.startAnimation(scaleDown);
            }
        }, 100); // 100 миллисекунд задержки
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}