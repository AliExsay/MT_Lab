package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class CameraActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private Camera camera;
    private SurfaceHolder surfaceHolder;
    private SurfaceView preview;
    private ImageButton shotBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{ android.Manifest.permission.CAMERA }, MY_CAMERA_REQUEST_CODE);
        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_camera);

        preview = findViewById(R.id.surface_view);
        surfaceHolder = preview.getHolder();
        surfaceHolder.addCallback(new MyCallback(this));
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        shotBtn = findViewById(R.id.shot_btn);
        shotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean b, Camera camera) {
                        if (b) {
                            camera.takePicture(null, null, null, new MyPictureCallback());
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        camera = Camera.open();
    }

    @Override
    public void onPause() {
        super.onPause();
        camera.release();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera permission granted!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Camera permission denied!", Toast.LENGTH_LONG).show();
            }
        }
    }

    class MyCallback implements SurfaceHolder.Callback {
        Activity activity;

        MyCallback(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            try {
                camera.setPreviewDisplay(surfaceHolder);
            } catch (IOException e) {
                Log.d("CameraActivity", "Camera error!");
                e.printStackTrace();
            }

//            Camera.Size previewSize = camera.getParameters().getPreviewSize();
//            float aspect = (float) previewSize.width / previewSize.height;
//            int previewSurfaceWidth = preview.getWidth();
//            int previewSurfaceHeight = preview.getHeight();
//            ViewGroup.LayoutParams layoutParams = preview.getLayoutParams();
//            if (activity.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
//                camera.setDisplayOrientation(90);
//                layoutParams.width = (int) (previewSurfaceHeight / aspect);
//                layoutParams.height = previewSurfaceHeight;
//            } else {
//                camera.setDisplayOrientation(0);
//                layoutParams.width = previewSurfaceWidth;
//                layoutParams.height = (int) (previewSurfaceWidth / aspect);
//            }
//            preview.setLayoutParams(layoutParams);
            Camera.Parameters params = camera.getParameters();
            camera.setDisplayOrientation(90);
            params.setRotation(90);
            camera.setParameters(params);

            camera.startPreview();
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) { }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) { }
    }

    class MyPictureCallback implements Camera.PictureCallback {

        @Override
        public void onPictureTaken(byte[] bytes, Camera camera) {
            try {
                File pictureFile = getOutputMediaFile();
                if (pictureFile == null) {
                    Log.d("CameraActivity", "Error creating media file, check storage permissions!");
                    return;
                }

                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(bytes);
                fos.close();

                String text = "Picture saved to " + pictureFile.getAbsolutePath() + "...";
                Toast.makeText(CameraActivity.this, text, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            camera.startPreview();
        }

        private File getOutputMediaFile() {
            File mediaStorageDir = new File(getFilesDir(), "Gallery");
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    Log.d("CameraActivity", "Failed to create directory!");
                    return null;
                }
            }

            @SuppressLint("SimpleDateFormat")
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            return new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        }
    }
}