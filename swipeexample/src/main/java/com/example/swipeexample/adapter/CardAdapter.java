package com.example.swipeexample.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.swipeexample.fragments.CardFragment;

public class CardAdapter extends FragmentStatePagerAdapter{

    public CardAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CardFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
