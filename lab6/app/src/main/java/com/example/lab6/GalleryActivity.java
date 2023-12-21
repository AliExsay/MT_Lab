package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class GalleryActivity extends AppCompatActivity {
    int currentImage;
    ArrayList<String> images;

    TextView galleryInfo;
    ImageView imageView;
    ImageButton previousBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galleryInfo = findViewById(R.id.gallery_info);
        imageView = findViewById(R.id.image_view);
        previousBtn = findViewById(R.id.previous_btn);
        nextBtn = findViewById(R.id.next_btn);
    }

    @Override
    public void onResume() {
        super.onResume();

        currentImage = 0;
        images = new ArrayList<>();

        try {
            File mediaStorageDir = new File(getFilesDir(), "Gallery");
            images = searchImages(mediaStorageDir);
            updateImage(Uri.parse(images.get(currentImage)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (images.size() > 0 && currentImage > 0) {
                    currentImage--;
                    updateImage(Uri.parse(images.get(currentImage)));
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (images.size() > 0 && currentImage + 1 < images.size()) {
                    currentImage++;
                    updateImage(Uri.parse(images.get(currentImage)));
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        images.clear();
    }

    private ArrayList<String> searchImages(File dir) {
        ArrayList<String> foundImages = new ArrayList<>();
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (!file.isDirectory()) {
                String fileExt = getFileExt(file.getAbsolutePath());
                if (fileExt.equals("png") || fileExt.equals("jpg") || fileExt.equals("jpeg")) {
                    foundImages.add(file.getAbsolutePath());
                }
            }
        }
        return foundImages;
    }

    private String getFileExt(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    @SuppressLint("SetTextI18n")
    private void updateImage(Uri uri) {
        try {
            galleryInfo.setText((currentImage + 1) + " / " + images.size());
            imageView.setImageURI(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}