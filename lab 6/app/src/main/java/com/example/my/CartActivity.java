package com.example.my; // Замените на ваш пакет

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast; // Импорт для отображения всплывающих уведомлений
import android.view.View;
import java.util.List;
import java.util.ArrayList;
public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private Button placeOrderButton;
    private List<Product> cartProducts; // Список товаров в корзине
    private ProductAdapter cartAdapter; // Адаптер для RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        // Инициализация списка товаров в корзине и адаптера
        cartProducts = new ArrayList<>();
        cartAdapter = new ProductAdapter(cartProducts);

        // Привязка адаптера к RecyclerView
        cartRecyclerView.setAdapter(cartAdapter);

        // Пример добавления товаров в корзину (ваш список товаров может быть разным)
        cartProducts.add(new Product("Товар 1", 10.0));
        cartProducts.add(new Product("Товар 2", 20.0));

        // Обработка нажатия на кнопку "Оформить заказ"
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь можно добавить код для обработки заказа, например, отправки заказа на сервер.
                // Пока просто отобразим всплывающее уведомление.
                Toast.makeText(CartActivity.this, "Заказ оформлен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}