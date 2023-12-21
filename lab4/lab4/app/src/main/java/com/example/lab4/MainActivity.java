package com.example.lab4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear, btnDeleteLast, btnUpdate, btnDel;
    EditText etName, etEmail;


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter); // устанавливаем адаптер
        viewPager.setCurrentItem(1); // выводим второй экран



        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        //btnDeleteLast = (Button) findViewById(R.id.btnDeleteLast);
        //btnDeleteLast.setOnClickListener(this);


        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        dbHelper = new DBHelper(this);
    }

    public static class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;    //количество страниц
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new Fragment4();

                default:
                    return new Fragment1();
            }
        }
    }
    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        int id = v.getId();
        if (id == R.id.btnAdd) {
            contentValues.put(DBHelper.KEY_NAME, name);
            contentValues.put(DBHelper.KEY_MAIL, email);

           database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);

                   } else if (id == R.id.btnRead) {
            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
            TextView myAwesomeTextView = (TextView)findViewById(R.id.textView1);



            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
               myAwesomeTextView.setText("");
                do {
                    myAwesomeTextView.append("\nID = " + cursor.getInt(idIndex) +
                            "\n name = " + cursor.getString(nameIndex) +
                            "\n email = " + cursor.getString(emailIndex));
                    Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                            ", name = " + cursor.getString(nameIndex) +
                            ", email = " + cursor.getString(emailIndex));
                } while (cursor.moveToNext());
            } else
                Log.d("mLog", "0 rows");

            cursor.close();
        } else if (id == R.id.btnClear) {
            database.delete(DBHelper.TABLE_CONTACTS, null, null);
        }
          /*else if (id == R.id.btnDeleteLast) {

            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
            cursor.moveToLast();
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_ID + "=" + cursor.getInt(idIndex), null);
            cursor.close();
        }*/
        else if (id == R.id.btnUpdate) {
            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);

                do {
                    if(name.equals(cursor.getString(nameIndex)))
                    {
                        contentValues.put(DBHelper.KEY_MAIL, email);
                        contentValues.put(DBHelper.KEY_NAME, name);
                        database.update(DBHelper.TABLE_CONTACTS, contentValues, DBHelper.KEY_ID + "=" + cursor.getInt(idIndex), null);
                    }

                } while (cursor.moveToNext());

            }
            cursor.close();
        }
        else if (id == R.id.btnDel) {

            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);

                do {
                    if(name.equals(cursor.getString(nameIndex)))
                    {
                        database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_ID + "=" + cursor.getInt(idIndex), null);
                    }

                } while (cursor.moveToNext());

            }
            cursor.close();;
        }
        dbHelper.close();
    }
}