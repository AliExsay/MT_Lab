package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //переход на другую активу по нажатию
    public void buttonPlayClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
    public void exit(View view) {
       // getActivity().finish();
        System.exit(0);
    }
}