package com.example.swipeexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.swipeexample.adapter.CardAdapter;
import com.example.swipeexample.efectos.CardStackTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    CardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        adapter = new CardAdapter(getSupportFragmentManager());
        //mPager.setPageTransformer(true, new CardStackTransformer());
        viewPager.setPageTransformer(true, new CardStackTransformer());
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(adapter);
    }
}
