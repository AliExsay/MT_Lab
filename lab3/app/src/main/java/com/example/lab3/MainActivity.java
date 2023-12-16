package com.example.lab3;


import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lab3.adapters.CarsAdapter;
import com.example.lab3.interfaces.OnChangeListener;
import com.example.lab3.models.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChangeListener, View.OnClickListener {

    private ListView listView;
    private ArrayList<Car> arr_Cars = new ArrayList<Car>();
    private ArrayList<Car> arr_checked_cars = new ArrayList<Car>();
    private final int SIZE_OF_ARR = 25;
    private CarsAdapter carsAdapter;
    private LayoutInflater layoutInflater;
    private View view_header, view_footer;
    private Button btnShow;
    private TextView tv_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createMyListView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void createMyListView() {
        fillData();
        carsAdapter = new CarsAdapter(this, arr_Cars,this);
        layoutInflater = LayoutInflater.from(this);
        view_header = layoutInflater.inflate(R.layout.header_mycars, null);
        view_footer = layoutInflater.inflate(R.layout.footer_mycars, null);
        btnShow = (Button) view_footer.findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        tv_count = (TextView) view_footer.findViewById(R.id.tv_count);
        listView.addHeaderView(view_header);
        listView.addFooterView(view_footer);
        listView.setAdapter(carsAdapter);
    }

    private void fillData(){
        int i=0;
        while (i<SIZE_OF_ARR) {
            i++;
            arr_Cars.add(new Car(i," " + "My Car №" + i, false));
        }
    }

    @Override
    public void onDataChanged() {
        int size = CarsAdapter.getCheckedCars().size();
        tv_count.setText("Count of cars = " + size + "");
    }

    @Override
    public void onClick(View view) {
        arr_checked_cars = CarsAdapter.getCheckedCars();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putParcelableArrayListExtra("MyList", arr_checked_cars);
        startActivity(intent);
    }
}

