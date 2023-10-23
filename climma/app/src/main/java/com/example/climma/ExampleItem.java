package com.example.climma;

public class ExampleItem {
    private String mImageUrl, mCity, mCond, mTime, mPrecip, mTemp, mHumdt , mFeel;

    public ExampleItem( String City, String Time, String Cond, String Precip, String Temp,
                        String Humdt, String Feel, String ImageUrl) {

        mCity = City;
        mTime = Time;
        mCond = Cond;
        mPrecip = Precip;
        mTemp = Temp;
        mHumdt = Humdt;
        mFeel = Feel;
        mImageUrl = ImageUrl;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmCond() {
        return mCond;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmPrecip() {
        return mPrecip;
    }

    public String getmTemp() {
        return mTemp;
    }

    public String getmHumdt() {
        return mHumdt;
    }

    public String getmFeel() {
        return mFeel;
    }

    /* public ExampleItem(String City, Time, Precip, ) {
     *//*  mImageUrl = ImageUrl;*//*
       mCity = City;
      *//* mCond = Cond;*//*
       mTemp = Temp;
       mHumdt= Humdt;
    }*/

   /* public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmCond() {
        return mCond;
    }

    public int getmTemp() {
        return mTemp;
    }

    public int getmHumdt() {
        return mHumdt;
    }*/
}
