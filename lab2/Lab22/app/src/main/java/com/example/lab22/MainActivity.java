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
        int[] imageList = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six, R.drawable.six};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc, R.string.friesDesc};
        String[] nameList = {"Chuck 70 High Top", "Converse x DRKSHDW TURBOWPN High Top", "Chuck Taylor All Star All Terrain Waterproof High Top", "Run Star Legacy Chelsea CX Mono High Top", "Converse x ADER ERROR Chuck 70 High Top","Run Star Motion CX Platform SGA High Top", "All Star BB Prototype CX Thunder & Lightning Mid Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top", "Run Star Motion CX Platform SGA High Top"};
        String[] timeList = {"CA$100.00", "CA$250.00", "CA$180.00","CA$140.00", "CA$170.00", "CA$129.99", "CA$125.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99", "CA$129.99"};
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