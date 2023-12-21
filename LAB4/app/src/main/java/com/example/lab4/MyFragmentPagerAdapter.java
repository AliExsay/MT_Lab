package com.example.lab4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    static final int PAGE_COUNT = 4;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FragmentShow();
            case 1:
                return new FragmentAdd();
            case 2:
                return new FragmentDel();
            case 3:
                return new FragmentUpdate();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        switch (i) {
            case 0:
                return "Show";
            case 1:
                return "Add";
            case 2:
                return "Del";
            case 3:
                return "Update";
            default:
                return null;
        }
    }
}
