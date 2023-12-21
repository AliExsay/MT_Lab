package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    MediaPlayer mediaPlayer;

    SurfaceView surfaceView;
    RadioButton radioAudio, radioVideo;
    ImageButton playBtn, pauseBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        surfaceView = findViewById(R.id.surface_view);

        radioAudio = findViewById(R.id.radio_audio);
        radioVideo = findViewById(R.id.radio_video);

        playBtn = findViewById(R.id.play_btn);
        pauseBtn = findViewById(R.id.pause_btn);
        stopBtn = findViewById(R.id.stop_btn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseMP();
                mediaPlayer = null;
                try {
                    if (radioAudio.isChecked()) {
                        mediaPlayer = MediaPlayer.create(MediaActivity.this, R.raw.audio);
                        mediaPlayer.setOnPreparedListener(MediaActivity.this);
                        mediaPlayer.prepareAsync();
                    } else if (radioVideo.isChecked()) {
                        mediaPlayer = MediaPlayer.create(MediaActivity.this, R.raw.video);
                        mediaPlayer.setDisplay(surfaceView.getHolder());
                        mediaPlayer.setOnPreparedListener(MediaActivity.this);
                        mediaPlayer.prepareAsync();
                    }
                } catch (Exception e) {
                    //Toast.makeText(MediaActivity.this, "Playback error!", Toast.LENGTH_SHORT).show();
                }
                if (mediaPlayer != null) {
                    mediaPlayer.setOnCompletionListener(MediaActivity.this);
                }
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) { }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }

    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}