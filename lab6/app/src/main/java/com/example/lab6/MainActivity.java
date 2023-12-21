package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (view.getId()) {
                    case R.id.camera_btn:
                        intent = new Intent(MainActivity.this, CameraActivity.class);
                        break;
                    case R.id.gallery_btn:
                        intent = new Intent(MainActivity.this, GalleryActivity.class);
                        break;
                    case R.id.media_btn:
                        intent = new Intent(MainActivity.this, MediaActivity.class);
                    default:
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        };

        findViewById(R.id.camera_btn).setOnClickListener(onClickListener);
        findViewById(R.id.gallery_btn).setOnClickListener(onClickListener);
        findViewById(R.id.media_btn).setOnClickListener(onClickListener);
    }
}