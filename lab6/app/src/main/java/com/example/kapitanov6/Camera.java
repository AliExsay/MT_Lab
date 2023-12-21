package com.example.kapitanov6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Size;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.*;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Camera extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private FloatingActionButton btnTakePhoto;
    private FloatingActionButton btnBack;
    private PreviewView camera_pv;
    private ImageCapture imageCapture;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btnTakePhoto = findViewById(R.id.btn_photo);
        camera_pv = findViewById(R.id.viewFinder);
        btnBack = findViewById(R.id.btn_back);

        if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        startCamera();
    }

    private void startCamera() {
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {

            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        // Создание предпросмотра
        Preview preview = new Preview.Builder().build();

        // Выбор камеры (задняя)
        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        // вывод картинки в предпросмотр
        preview.setSurfaceProvider(camera_pv.getSurfaceProvider());

        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
                .setTargetResolution(new Size(1080, 2340))
                .build();

        imageCapture = new ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setTargetRotation(getWindowManager().getDefaultDisplay().getRotation())
                .build();

        // Обработка каждого кадра с камеры
        imageAnalysis.setAnalyzer(executor, new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(ImageProxy image) {
                btnTakePhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        File photoFile = createPhotoFile();
                        ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(photoFile).build();

                        imageCapture.takePicture(outputFileOptions, executor, new ImageCapture.OnImageSavedCallback() {
                            @Override
                            public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                                // Обработка сохраненного изображения
                                String savedUri = photoFile.getAbsolutePath();
                                Bitmap bitmap = BitmapFactory.decodeFile(savedUri);


                            }

                            @Override
                            public void onError(@NonNull ImageCaptureException exception) {

                            }
                        });
                    }
                });
            }
        });
        // Связывание компонентов камеры. Компоненты будут работать пока жива ScanActivity
        cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis, imageCapture);
    }

    private File createPhotoFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            File image = File.createTempFile(imageFileName, ".jpg", storageDir);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}