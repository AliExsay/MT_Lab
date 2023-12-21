package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    int f = 0;
    int g = 0;
    int h = 0;
    int i = 0;
    int j= 0;
    int k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    int x = 0;
    int y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonRestart);
        btn.setVisibility(View.GONE);

    }



    //смена картинки при нажатии кнопки
    public void buttonAclick(View view){
        a = 1;
        y ++ ;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonA);
        btn.setImageResource(R.drawable.photo1);
        a = 1;

    }

    public void buttonBclick(View view){
        b = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonB);
        btn.setImageResource(R.drawable.photo2);
        b = 1;

    }

    public void buttonCclick(View view){
        c = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonC);
        btn.setImageResource(R.drawable.photo2);
        c = 1;

    }

    public void buttonDclick(View view){
        d = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonD);
        btn.setImageResource(R.drawable.photo1);
        d = 1;


    }
    public void buttonEclick(View view){
        e = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonE);
        btn.setImageResource(R.drawable.photo3);
        e = 1;


    }
    public void buttonFclick(View view){
        f = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonF);
        btn.setImageResource(R.drawable.photo3);
        f = 1;


    }
    public void buttonGclick(View view){
        g = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonG);
        btn.setImageResource(R.drawable.photo4);
        g = 1;


    }
    public void buttonHclick(View view){
        h = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonH);
        btn.setImageResource(R.drawable.photo4);
        h = 1;


    }
    public void buttonIclick(View view){
        i = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonI);
        btn.setImageResource(R.drawable.photo5);
        i = 1;


    }
    public void buttonJclick(View view){
        j = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonJ);
        btn.setImageResource(R.drawable.photo5);
        j = 1;


    }
    public void buttonKclick(View view){
        k = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonK);
        btn.setImageResource(R.drawable.photo6);
        k = 1;


    }
    public void buttonLclick(View view){
        l = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonL);
        btn.setImageResource(R.drawable.photo6);
        l = 1;


    }
    public void buttonMclick(View view){
        m = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonM);
        btn.setImageResource(R.drawable.photo7);
        m = 1;


    }
    public void buttonNclick(View view){
        n = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonN);
        btn.setImageResource(R.drawable.photo7);
        n = 1;


    }
    public void buttonOclick(View view){
        o = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonO);
        btn.setImageResource(R.drawable.photo8);
        o = 1;


    }
    public void buttonPclick(View view){
        p = 1;
        y ++;
        check();
        ImageButton btn = (ImageButton)findViewById(R.id.imageButtonP);
        btn.setImageResource(R.drawable.photo8);
        p = 1;


    }
    public void restart(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void check() {

        if (a + d == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonA);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonD);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            a = 0;
            d = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        } else if (b + c == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonB);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonC);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            b = 0;
            c = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }

        } else if (e + f == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonE);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonF);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            e = 0;
            f = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        }
        else if (g + h == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonG);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonH);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            g = 0;
            h = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        }
        else if (i + j == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonI);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonJ);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            i = 0;
            j = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        }
        else if (k + l == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonK);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonL);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            k = 0;
            l = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        }
        else if (m + n == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonM);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonN);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            m = 0;
            n = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }
        }
        else if (o + p == 2) {
            ImageButton btn = (ImageButton) findViewById(R.id.imageButtonO);
            ImageButton btn1 = (ImageButton) findViewById(R.id.imageButtonP);
            btn.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            o = 0;
            p = 0;
            y = 0;
            x += 1;
            if (x >= 8) {
                ImageButton btn2 = (ImageButton) findViewById(R.id.imageButtonRestart);
                btn2.setVisibility(View.VISIBLE);
            }

        } else if (y > 1) {
            ImageButton btnA = (ImageButton) findViewById(R.id.imageButtonA);
            ImageButton btnB = (ImageButton) findViewById(R.id.imageButtonB);
            ImageButton btnC = (ImageButton) findViewById(R.id.imageButtonC);
            ImageButton btnD = (ImageButton) findViewById(R.id.imageButtonD);
            ImageButton btnE = (ImageButton) findViewById(R.id.imageButtonE);
            ImageButton btnF = (ImageButton) findViewById(R.id.imageButtonF);
            ImageButton btnG = (ImageButton) findViewById(R.id.imageButtonG);
            ImageButton btnH = (ImageButton) findViewById(R.id.imageButtonH);
            ImageButton btnI = (ImageButton) findViewById(R.id.imageButtonI);
            ImageButton btnJ = (ImageButton) findViewById(R.id.imageButtonJ);
            ImageButton btnK = (ImageButton) findViewById(R.id.imageButtonK);
            ImageButton btnL = (ImageButton) findViewById(R.id.imageButtonL);
            ImageButton btnM = (ImageButton) findViewById(R.id.imageButtonM);
            ImageButton btnN = (ImageButton) findViewById(R.id.imageButtonN);
            ImageButton btnO = (ImageButton) findViewById(R.id.imageButtonO);
            ImageButton btnP = (ImageButton) findViewById(R.id.imageButtonP);
            btnA.setImageResource(R.drawable.tile);
            btnB.setImageResource(R.drawable.tile);
            btnC.setImageResource(R.drawable.tile);
            btnD.setImageResource(R.drawable.tile);
            btnE.setImageResource(R.drawable.tile);
            btnF.setImageResource(R.drawable.tile);
            btnG.setImageResource(R.drawable.tile);
            btnH.setImageResource(R.drawable.tile);
            btnI.setImageResource(R.drawable.tile);
            btnJ.setImageResource(R.drawable.tile);
            btnK.setImageResource(R.drawable.tile);
            btnL.setImageResource(R.drawable.tile);
            btnM.setImageResource(R.drawable.tile);
            btnN.setImageResource(R.drawable.tile);
            btnO.setImageResource(R.drawable.tile);
            btnP.setImageResource(R.drawable.tile);
            if(y >= 2) {
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                e = 0;
                f = 0;
                g = 0;
                h = 0;
                i = 0;
                j = 0;
                k = 0;
                l = 0;
                m = 0;
                n = 0;
                o = 0;
                p = 0;
                y -- ;

            }
        }
    }
}