package com.example.lab3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChangeListener, View.OnClickListener {
    private ListView listView;
    private ArrayList<Good> arr_goods = new ArrayList<>();
    private GoodsAdapter goodsAdapter;
    private Button btnShow;
    private TextView tv_count;
    private TextView tv_total_cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createMyListView();
    }

    private void initView() {
        listView = findViewById(R.id.listView);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        tv_count = findViewById(R.id.tv_count);
        tv_total_cost = findViewById(R.id.tv_total_cost);
    }

    private void createMyListView() {
        fillData();
        goodsAdapter = new GoodsAdapter(this, arr_goods, this);
        listView.setAdapter(goodsAdapter);
    }

    private void fillData() {
        arr_goods.add(new Good(1, "Product A", 10.0, R.drawable.a, false));
        arr_goods.add(new Good(2, "Product B", 15.0, R.drawable.b, false));
        arr_goods.add(new Good(3, "Product C", 20.0, R.drawable.c, false));
        arr_goods.add(new Good(4, "Product D", 12.0, R.drawable.d, false));
    }


    @Override
    public void onDataChanged(double totalCost) {
        int size = goodsAdapter.getCheckedGoods().size();
        tv_count.setText("Count of goods = " + size);
        tv_total_cost.setText("Total cost: $" + totalCost);
    }

    @Override
    public void onClick(View view) {
        if (view == btnShow) {
            ArrayList<Good> arr_checked_goods = goodsAdapter.getCheckedGoods();
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putParcelableArrayListExtra("MyList", arr_checked_goods);
            startActivity(intent);
        }
    }
}
