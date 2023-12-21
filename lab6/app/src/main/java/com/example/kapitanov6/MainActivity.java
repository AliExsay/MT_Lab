package com.example.kapitanov6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toVideo(View view){
        Intent intent = new Intent(this, Video.class);
        startActivity(intent);
    }

    public void toAudio(View view){
        Intent intent = new Intent(this, Audio.class);
        startActivity(intent);
    }

    public void toCamera(View view){
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }

    public void toGallery(View view){
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }
}