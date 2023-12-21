package com.example.lab3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_selectedGoods;
    private TextView tv_totalCost;
    private Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_selectedGoods = findViewById(R.id.tv_selectedGoods);
        tv_totalCost = findViewById(R.id.tv_total_cost);
        btnPay = findViewById(R.id.btnPay);

        Intent intent = getIntent();
        ArrayList<Good> selectedGoods = intent.getParcelableArrayListExtra("MyList");


        if (selectedGoods != null) {
            StringBuilder selectedGoodsText = new StringBuilder();
            double totalCost = 0.0;

            for (Good good : selectedGoods) {
                selectedGoodsText.append("ID: ").append(good.getId()).append(", Name: ").append(good.getName()).append(", $: ").append(good.getPrice()).append("\n");
                totalCost += good.getPrice();
            }

            tv_selectedGoods.setText(selectedGoodsText.toString());
            tv_totalCost.setText("Total Cost: $" + totalCost);
            final double payedCost = totalCost;


            btnPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Здесь можно использовать totalCost для вычисления суммы к оплате
                    Toast.makeText(SecondActivity.this, "Оплачено $" + payedCost, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

