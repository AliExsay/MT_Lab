package com.example.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentUpdate extends Fragment {

    MainActivity ctx;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fupdate, null);
        ArrayList<Integer> ids = ctx.getAllId();
        ctx.Inc2Button = view.findViewById(R.id.Inc2Button);
        ctx.Dec2Button = view.findViewById(R.id.Dec2Button);
        ctx.editText2 = view.findViewById(R.id.editTextUpdate);
        ctx.buttonUpdate = view.findViewById(R.id.UpdateButton);
        ctx.ID2textview = view.findViewById(R.id.ID2textview);
        if (ids.size() == 0) ctx.ID2textview.setText("...");
        else ctx.ID2textview.setText(String.valueOf(ids.get(0)));
        ctx.editText2.setBackgroundColor(Color.rgb(46+10,54+10,56+10));
        return view;
    }

    public FragmentUpdate(MainActivity context)
    {
        ctx = context;
    }

}
