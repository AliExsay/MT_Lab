package com.example.lab2mt;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button loadButton;
    private RecyclerView recyclerView;
    private EditText jsonUrlEditText;
    private List<PostModel> postData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadButton = findViewById(R.id.loadButton);
        recyclerView = findViewById(R.id.recyclerView);
        jsonUrlEditText = findViewById((R.id.jsonUrlEditText));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PostAdapter adapter = new PostAdapter(postData, this::showPostBody);
        recyclerView.setAdapter(adapter);

        loadButton.setOnClickListener(v -> {
            String jsonUrl = jsonUrlEditText.getText().toString();
            jsonUrlEditText.setEnabled(false);
            loadButton.setEnabled(false);

            if (!jsonUrl.isEmpty()) {
                // Создайте Retrofit-сервис для выполнения запроса
                ApiService apiService = RetrofitClient.getRetrofit(jsonUrl).create(ApiService.class);

                Call<List<PostModel>> call = apiService.getPosts();

                call.enqueue(new Callback<List<PostModel>>() {
                    @Override
                    public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                        if (response.isSuccessful()) {
                            // Успешно получены данные JSON
                            List<PostModel> posts = response.body();
                            if(response.body().isEmpty()){
                                jsonUrlEditText.setEnabled(true);
                                loadButton.setEnabled(true);
                            }

                            // Очистите текущие данные и добавьте полученные данные
                            postData.clear();
                            postData.addAll(posts);

                            // Обновите адаптер
                            adapter.notifyDataSetChanged();
                        } else {
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PostModel>> call, Throwable t) {
                        jsonUrlEditText.setEnabled(true);
                        loadButton.setEnabled(true);
                    }
                });
            } else {
                // Введите URL JSON-файла
                Toast.makeText(this, "Введите URL JSON-файла", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showPostBody(PostModel post) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Описание");
        builder.setMessage(post.getBody());
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


