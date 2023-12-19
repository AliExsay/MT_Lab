package com.example.mt4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadLogDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log=new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            TextView tv = (TextView)findViewById(R.id.textView1);
            tv.setText(log.toString());
        } catch (IOException e) {
        }
    }
}
