package com.example.mt4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;

    DBHelper dbHelper;
    public Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        TextView textView = view.findViewById(R.id.textView1);
        textView.setText("Проверка");
        return view;


    }
    public void onClick(View v,@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        int id = v.getId();
        if (id == R.id.btnAdd) {
            contentValues.put(DBHelper.KEY_NAME, name);
            contentValues.put(DBHelper.KEY_MAIL, email);

            database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
        } else if (id == R.id.btnRead) {
            Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
            TextView myAwesomeTextView = view.findViewById(R.id.textView1);



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
        dbHelper.close();
    }

    public void add(String name, String email)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_MAIL, email);

        database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
        dbHelper.close();
    }

}
