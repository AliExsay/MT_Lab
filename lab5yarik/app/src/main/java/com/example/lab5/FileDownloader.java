package com.example.lab5;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader extends AsyncTask<String, Void, File> {
    public static final int REQUEST_PERMISSION_CODE = 123; // Замените на нужный код разрешения
    private Context context;
    private String downloadUrl;

    public FileDownloader(Context context) {
        this.context = context;
    }

    @Override
    protected File doInBackground(String... strings) {
        downloadUrl = strings[0];
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String fileName = "journal.pdf"; // Название файла, который будет сохранен
                File folder = new File(Environment.getExternalStorageDirectory() + "/Journal");
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                File file = new File(folder, fileName);

                FileOutputStream outputStream = new FileOutputStream(file);
                InputStream inputStream = connection.getInputStream();

                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }

                outputStream.close();
                inputStream.close();

                return file;
            }
        } catch (Exception e) {
            Log.e("FileDownloader", "Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(File file) {
        if (file != null) {
            // Файл успешно загружен, активируйте кнопки "Смотреть" и "Удалить"
            Toast.makeText(context, "Файл успешно загружен", Toast.LENGTH_SHORT).show();
        } else {
            // Ошибка загрузки файла, выведите сообщение об ошибке
            Toast.makeText(context, "Ошибка загрузки файла", Toast.LENGTH_SHORT).show();
        }
    }

    // Метод для открытия PDF-файла
    public void openPdfFile() {
        File folder = new File(Environment.getExternalStorageDirectory() + "/Journal");
        File file = new File(folder, "journal.pdf");

        if (file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Файл не найден", Toast.LENGTH_SHORT).show();
        }
    }

    // Метод для удаления файла
    public void deleteFile() {
        File folder = new File(Environment.getExternalStorageDirectory() + "/Journal");
        File file = new File(folder, "journal.pdf");

        if (file.exists()) {
            if (file.delete()) {
                Toast.makeText(context, "Файл успешно удален", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Ошибка при удалении файла", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Файл не найден", Toast.LENGTH_SHORT).show();
        }
    }

    // Проверка разрешения на запись во внешнее хранилище
    public boolean checkPermission() {
        int permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permission == PackageManager.PERMISSION_GRANTED;
    }

    // Запрос разрешения на запись во внешнее хранилище
    public void requestPermission() {
        ActivityCompat.requestPermissions((MainActivity) context,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
    }
}
