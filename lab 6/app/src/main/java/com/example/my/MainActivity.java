package com.example.my; // Замените на ваш пакет

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button checkoutButton;

    private List<Product> productList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        checkoutButton = findViewById(R.id.checkoutButton);

        productList = new ArrayList<>();
        productList.add(new Product("Товар 1", 10.0));
        productList.add(new Product("Товар 2", 20.0));

        // Добавьте логи для проверки, что товары были добавлены
        for (Product product : productList) {
            Log.d("Product Debug", "Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }

        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
