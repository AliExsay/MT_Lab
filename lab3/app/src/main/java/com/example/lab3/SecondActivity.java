package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab3.adapters.AnotherCarsAdapter;
import com.example.lab3.adapters.CarsAdapter;
import com.example.lab3.models.Car;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity{

    private ListView listView2;
    private ArrayList<Car> carsArray = new ArrayList<Car>();
    private AnotherCarsAdapter carsAdapter;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initView();
        createMyListView();
    }

    private void initView() {
        listView2 = (ListView) findViewById(R.id.listView2);
    }

    public void createMyListView(){
        getData();
        carsAdapter = new AnotherCarsAdapter(this, carsArray);
        layoutInflater = LayoutInflater.from(this);
        listView2.setAdapter(carsAdapter);
    }

    public void getData(){
        carsArray = getIntent().getParcelableArrayListExtra("MyList");
    }
}
