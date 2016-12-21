package com.example.root.viewpager;

import android.support.annotation.DrawableRes;

/**
 * Created by root on 25/8/16.
 */
public class Item {

    private int mDrawableRes;

    private String mTitle;
    String name;

    public Item(@DrawableRes int drawable,String name) {
        this.mDrawableRes = drawable;
        this.name=name;

    }



    public int getDrawableResource() {
        return mDrawableRes;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}