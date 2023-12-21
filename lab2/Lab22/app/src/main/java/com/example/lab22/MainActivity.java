package com.example.lab22;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.lab22.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList = {R.drawable.zz6efi, R.drawable.zz502, R.drawable.zz427, R.drawable.zz6, R.drawable.sp383, R.drawable.zz572, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383, R.drawable.sp383};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc};
        String[] nameList = {"ZZ6 EFI Deluxe", "ZZ502 Deluxe", "ZZ427", "ZZ6", "SP 388 EFI","ZZ572 Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe", "SP 383 EFI Deluxe"};
        String[] timeList = {"6.4L", "8.2L", "7.2L","6.2L", "6.2L", "8.8L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L", "6.2L"};
        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}