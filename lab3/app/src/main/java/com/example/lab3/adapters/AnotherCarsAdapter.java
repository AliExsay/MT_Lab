package com.example.lab3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.lab3.R;
import com.example.lab3.models.Car;

import java.util.ArrayList;

public class AnotherCarsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Car> arr_cars_adapter;
    private LayoutInflater layoutInflater;
    private static ArrayList<Car> arr_checked_cars_adapter = new ArrayList<Car>();

    public AnotherCarsAdapter(Context context, ArrayList<Car> arr_cars_adapter) {
        this.context = context;
        this.arr_cars_adapter = arr_cars_adapter;
        this.layoutInflater = LayoutInflater.from(context);
    }
    // количество элементов
    @Override
    public int getCount() {
        return arr_cars_adapter.size();
    }
    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return arr_cars_adapter.get(position);
    }
    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }
    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.another_item_car, null, false);
        }
        Car car_temp = arr_cars_adapter.get(position);
        TextView tv_carName = (TextView) view.findViewById(R.id.tv_carName);
        tv_carName.setText(car_temp.getName());
        return view;
    }

    public static ArrayList<Car> getCheckedCars() {
        return arr_checked_cars_adapter;
    }

}