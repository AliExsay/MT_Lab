package com.example.lab3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ImageView;


import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    private ArrayList<Good> arr_goods_adapter;
    private LayoutInflater layoutInflater;
    private OnChangeListener onChangeListener;
    private double totalCost;

    public GoodsAdapter(Context context, ArrayList<Good> arr_goods_adapter, OnChangeListener onChangeListener) {
        this.context = context;
        this.arr_goods_adapter = arr_goods_adapter;
        this.layoutInflater = LayoutInflater.from(context);
        this.onChangeListener = onChangeListener;
        this.totalCost = 0.0;
    }

    @Override
    public int getCount() {
        return arr_goods_adapter.size();
    }

    @Override
    public Object getItem(int position) {
        return arr_goods_adapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_good, null, false);
        }
        // Обновляем информацию о товаре, включая стоимость и изображение
        Good good_temp = arr_goods_adapter.get(position);
        TextView tv_goodId = view.findViewById(R.id.tv_goodId);
        tv_goodId.setText(Integer.toString(good_temp.getId()));

        TextView tv_goodName = view.findViewById(R.id.tv_product_name);
        tv_goodName.setText(good_temp.getName());

        TextView tv_goodPrice = view.findViewById(R.id.tv_product_price);
        tv_goodPrice.setText("Price: $" + good_temp.getPrice());

        CheckBox cb_good = view.findViewById(R.id.cb_product);
        cb_good.setChecked(good_temp.isCheck());
        cb_good.setTag(position);
        cb_good.setOnCheckedChangeListener(this);

        ImageView iv_product_image = view.findViewById(R.id.iv_product_image);
        iv_product_image.setImageResource(good_temp.getImageResource());

        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.isShown()) {
            int i = (int) compoundButton.getTag();
            Good good = arr_goods_adapter.get(i);
            good.setCheck(isChecked);

            if (isChecked) {
                totalCost += good.getPrice();
            } else {
                totalCost -= good.getPrice();
            }

            notifyDataSetChanged();
            onChangeListener.onDataChanged(totalCost); // Передаем общую стоимость в MainActivity
        }
    }

    public ArrayList<Good> getCheckedGoods() {
        ArrayList<Good> checkedGoods = new ArrayList<>();
        for (Good good : arr_goods_adapter) {
            if (good.isCheck()) {
                checkedGoods.add(good);
            }
        }
        return checkedGoods;
    }
}

