package com.example.kapitanov6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    private ArrayList<File> pictures;
    private int curIndex = 0;
    private ImageView iv;
    private FloatingActionButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        iv = findViewById(R.id.imageView1);
        pictures = getCapturedImages();
        btnBack = findViewById(R.id.btn_back);

        showImage();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void showImage() {
        if (!pictures.isEmpty()) {
            File imageFile = pictures.get(curIndex);
            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            int rotation = getRotationFromImageFile(imageFile);

            if (rotation != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(rotation);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }

            iv.setImageBitmap(bitmap);
        }
    }

    // Метод для получения угла поворота из метаданных изображения
    private int getRotationFromImageFile(File imageFile) {
        try {
            ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return 90;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return 180;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void previous() {
        if (!pictures.isEmpty()) {
            if (curIndex == 0) {
                curIndex = pictures.size() - 1;
            } else {
                curIndex--;
            }
            showImage();
        }
    }

    public void next() {
        if (!pictures.isEmpty()) {
            if (curIndex == pictures.size() - 1) {
                curIndex = 0;
            } else {
                curIndex++;
            }
            showImage();
        }
    }

    private ArrayList<File> getCapturedImages() {
        ArrayList<File> imageFiles = new ArrayList<>();
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (storageDir != null) {
            File[] files = storageDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".jpg")) {
                        imageFiles.add(file);
                    }
                }
            }
        }
        return imageFiles;
    }
}