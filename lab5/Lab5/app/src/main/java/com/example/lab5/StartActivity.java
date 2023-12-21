package com.example.lab5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("InstructionPrefs", MODE_PRIVATE);

        boolean shouldShowInstructions = sharedPreferences.getBoolean("showInstructions", true);

        if (shouldShowInstructions) {
            showInstructionsPopup();
        } else {
            openMainActivity(); // Открываем MainActivity после закрытия Popup с инструкциями
        }
    }

    private void showInstructionsPopup() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.instruction_popup, null);
        dialogBuilder.setView(dialogView);

        TextView instructionText = dialogView.findViewById(R.id.instructionText);

        CheckBox checkBox = dialogView.findViewById(R.id.checkBox);
        Button okButton = dialogView.findViewById(R.id.okButton);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("showInstructions", false);
                    editor.apply();
                }
                alertDialog.dismiss();
                openMainActivity(); // Открываем MainActivity после закрытия Popup с инструкциями
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Закрываем текущую активность, чтобы пользователь не мог вернуться к ней из MainActivity
    }
}
