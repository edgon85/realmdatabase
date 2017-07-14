package com.example.swipeexample.efectos;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by root on 14/07/17.
 */

public class CardStackTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {

        if (position >= 0) {
            page.setScaleX(0.8f - 0.02f * position);

            page.setScaleY(0.8f);

            page.setTranslationX(-page.getWidth() * position);

            page.setTranslationY(30 * position);
        }
    }
}
