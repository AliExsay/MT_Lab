package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Находим кнопки по их идентификаторам
        Button notesButton = findViewById(R.id.notesButton);
        Button helpButton = findViewById(R.id.helpButton);

        // Устанавливаем слушатели событий для кнопок
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Переходим к MainActivity при нажатии на кнопку "Заметки"
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Открываем большое окно с информацией при нажатии на кнопку "Справка"
                // Здесь вы можете использовать AlertDialog или создать новую активность для справки
                // В примере использован AlertDialog
                showHelpDialog();
            }
        });
    }

    private void showHelpDialog() {
        // Создаем AlertDialog с информацией о разработчике
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setTitle("Справка");
        builder.setMessage("Разработчик: студентка Валерия Юрьевна");
        builder.setPositiveButton("OK", null); // Кнопка OK

        // Показываем AlertDialog
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
