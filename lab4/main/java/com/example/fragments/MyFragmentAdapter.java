package com.example.fragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    MainActivity ctx;
    static final int PAGE_COUNT = 4;

    public MyFragmentAdapter(@NonNull FragmentManager fm, MainActivity context) {
        super(fm);
        ctx = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0: return ctx.frShow;
            case 1: return ctx.frAdd;
            case 2: return ctx.frDel;
            case 3: return ctx.frUpdate;
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // при необходимости добавляем верхнее меню вкладок с заголовками
    @Override
    public CharSequence getPageTitle(int i) {
        switch (i) {
            case 0:
                return "Fields";
            case 1:
                return "Create";
            case 2:
                return "Delete";
            case 3:
                return "Replace";
            default:
                return null;
        }
    }
}
