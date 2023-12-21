package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends FragmentActivity {
    ViewPager pager;
    public FragmentShow frShow;
    public FragmentDel frDel;
    public FragmentUpdate frUpdate;
    public FragmentAdd frAdd;
    EditText editText;
    ListView listView;
    MyListAdapter listAdapter;
    DatabaseHelper DBHelper;
    MyFragmentAdapter pagerAdapter;
    Button IncButton;
    Button DecButton;
    TextView IDtextview;
    Button Inc2Button;
    Button Dec2Button;
    EditText editText2;
    Button buttonUpdate;
    TextView ID2textview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        pager.setBackgroundColor(Color.rgb(31,26,179));

        PagerTabStrip pagerTabStrip = findViewById(R.id.pagerTabStrip);
        pagerTabStrip.setTextColor(Color.rgb(255,255,255));

        CreateList();
    }

    public void CreateList()
    {
        DBHelper = new DatabaseHelper(getApplicationContext());
        DBHelper.create_db();

        frShow = new FragmentShow(this);
        frAdd = new FragmentAdd(this);
        frDel = new FragmentDel(this);
        frUpdate = new FragmentUpdate(this);

        pagerAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(pagerAdapter);
    }

    public void AddButtonClick(View view) {
        String NewNote = editText.getText().toString();
        if (NewNote != "") {
            SQLiteDatabase db = DBHelper.open();

            ContentValues newValue = new ContentValues();
            newValue.put("note", NewNote);

            db.insert("notes", null, newValue);

            listAdapter = new MyListAdapter(this, getAllId(), getData());
            listView.setAdapter(listAdapter);

            if (getAllId().size() == 1) {
                IDtextview.setText(String.valueOf(getAllId().get(0)));
                ID2textview.setText(String.valueOf(getAllId().get(0)));
            }

            db.close();

            Toast toast = Toast.makeText(this, "Элемент добавлен!", Toast.LENGTH_SHORT);
            toast.show();
            editText.setText("");
        }
        else{
            Toast toast = Toast.makeText(this, "Пустой текст!\nЭлемент не добавлен!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> idList = new ArrayList<>();
        SQLiteDatabase db = DBHelper.open();
        Cursor cursor = db.rawQuery("SELECT * FROM notes", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int data = cursor.getInt(cursor.getColumnIndex("id"));
                idList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return idList;
    }

    public ArrayList<String> getData() {
        ArrayList<String> dataList = new ArrayList<>();

        SQLiteDatabase db = DBHelper.open();
        Cursor cursor = db.rawQuery("SELECT * FROM notes", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex("note"));
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dataList;
    }

    public void IncButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
            int id = Integer.parseInt(IDtextview.getText().toString());
            if (id < Collections.max(ids)) {
                id = ids.get(ids.indexOf(id) + 1);
                IDtextview.setText(String.valueOf(id));
            }
        }
    }

    public void DecButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
            int id = Integer.parseInt(IDtextview.getText().toString());
            if (id > Collections.min(getAllId())) {
                id = ids.get(ids.indexOf(id) - 1);
                IDtextview.setText(String.valueOf(id));
            }
        }
    }

    public void DelButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
        int DelNote = Integer.parseInt(IDtextview.getText().toString());
            SQLiteDatabase db = DBHelper.open();

            if (DelNote == ids.get(0))
            {
                IDtextview.setText(String.valueOf(ids.get(1)));
                ID2textview.setText(String.valueOf(ids.get(1)));
            }
            else if (DelNote == ids.get(ids.size() - 1))
            {
                IDtextview.setText(String.valueOf(ids.get(0)));
                ID2textview.setText(String.valueOf(ids.get(0)));
            }

            db.delete("notes", "id = " + DelNote, null);
            ids = getAllId();

            if (ids.size() > 0) IDtextview.setText(String.valueOf(ids.get(0)));
            else {
                IDtextview.setText("...");
                ID2textview.setText("...");
            }
            Toast toast = Toast.makeText(this, "Элемент удалён!", Toast.LENGTH_SHORT);
            toast.show();


            listAdapter = new MyListAdapter(this, getAllId(), getData());
            listView.setAdapter(listAdapter);

            db.close();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Список пуст, больше удалять нечего!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void Inc2ButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
            int id = Integer.parseInt(ID2textview.getText().toString());
            if (id < Collections.max(ids)) {
                id = ids.get(ids.indexOf(id) + 1);
                ID2textview.setText(String.valueOf(id));
            }
        }
    }

    public void Dec2ButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
            int id = Integer.parseInt(ID2textview.getText().toString());
            if (id > Collections.min(getAllId())) {
                id = ids.get(ids.indexOf(id) - 1);
                ID2textview.setText(String.valueOf(id));
            }
        }
    }

    public void UpdateButtonClick(View view)
    {
        ArrayList<Integer> ids = getAllId();
        if (ids.size() > 0) {
            String NewNote = editText2.getText().toString();
            int UpdateNoteId = Integer.parseInt(ID2textview.getText().toString());
            SQLiteDatabase db = DBHelper.open();

            ContentValues newValue = new ContentValues();
            newValue.put("note", NewNote);

            db.update("notes",newValue,"id = " + UpdateNoteId, null);
            editText2.setText("");
            Toast toast = Toast.makeText(this, "Элемент обновлён!", Toast.LENGTH_SHORT);
            toast.show();


            listAdapter = new MyListAdapter(this, getAllId(), getData());
            listView.setAdapter(listAdapter);

            db.close();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Список пуст, обновлять нечего!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}