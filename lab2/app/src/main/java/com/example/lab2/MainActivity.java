package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView usersList;
    private UsersAdapter usersAdapter;
    private EditText URLInput;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList = findViewById(R.id.users_rv);
        URLInput = findViewById(R.id.url_et);
        downloadButton = findViewById(R.id.download_btn);

        usersList.setLayoutManager(new LinearLayoutManager(this));

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJSONFromURL(URLInput.getText().toString());
            }
        });
    }

    private void loadJSONFromURL(String URL) {
        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        StringRequest request = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("users");

                            usersAdapter = new UsersAdapter(getArrayListFromJSONArray(jsonArray), MainActivity.this);
                            usersList.setAdapter(usersAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray) {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(jsonArray.getJSONObject(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}