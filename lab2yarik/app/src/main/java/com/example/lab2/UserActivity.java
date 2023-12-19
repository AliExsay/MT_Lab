package com.example.lab2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserActivity extends AppCompatActivity {
    private TextView userId;
    private TextView userName;
    private TextView userEmail;
    private TextView userGender;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userId = findViewById(R.id.user_id_tv);
        userName = findViewById(R.id.user_name_tv);
        userEmail = findViewById(R.id.user_email_tv);
        userGender = findViewById(R.id.user_gender_tv);

        String userString = getIntent().getStringExtra("user");
        try {
            JSONObject user = new JSONObject(userString);
            userId.setText("ID: " + user.getString("id"));
            userName.setText("Name: " + user.getString("name"));
            userEmail.setText("Email: " + user.getString("email"));
            userGender.setText("Gender: " + user.getString("gender"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
