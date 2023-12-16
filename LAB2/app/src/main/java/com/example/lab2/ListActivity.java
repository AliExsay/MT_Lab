package com.example.lab2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONArray jsonArray = new JSONArray(JsonDataFromAsset("posts.json"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userData = jsonArray.getJSONObject(i);
                String avatarUrl = userData.getString("avatar_url");
                String userName = userData.getString("username");
                String postTitle = userData.getString("post_title");
                String postText = userData.getString("post_text");
                boolean isLiked = userData.getBoolean("is_liked");

                Post post = new Post(avatarUrl, userName, postTitle, postText, isLiked);
                posts.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Adapter adapter = new Adapter(posts, ListActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private String JsonDataFromAsset(String fileName) {
        String json = null;
        try {
            InputStream inputStream = getAssets().open(fileName);
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
