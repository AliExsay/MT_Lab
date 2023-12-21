package com.example.memory_game;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.R.*;


public class Records extends TabActivity {
    /** Called when the activity is first created. */
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);

        TabHost tabHost = getTabHost();

        // Вкладка Время
        TabHost.TabSpec timetab = tabHost.newTabSpec("Time");
        // устанавливаем заголовок и иконку
        timetab.setIndicator("по времени", getResources().getDrawable(R.drawable.time));
        // устанавливаем окно, которая будет показываться во вкладке
        Intent timeIntent = new Intent(this, RecordTime.class);
        timetab.setContent(timeIntent);

        // Вкладка Очки
        TabHost.TabSpec pointtab = tabHost.newTabSpec("Point");
        pointtab.setIndicator("по очкам", getResources().getDrawable(R.drawable.point));
        Intent pointIntent = new Intent(this, RecordPoint.class);
        pointtab.setContent(pointIntent);

        // Добавляем вкладки в TabHost
        tabHost.addTab(timetab);
        tabHost.addTab(pointtab);
    }
}
