package com.example.janerubygrissom.project1revised;

import java.util.ArrayList;

/**
 * Created by janerubygrissom on 7/18/16.
 */
public class Singleton {


//not bobdylan, make an arraylist of main objects, make instance, getters and setters
    // command n does this


    ArrayList<MainObject> mMainObjectArrayList = new ArrayList<>();

    public Singleton(ArrayList<MainObject> mMainObjectArrayList) {
        this.mMainObjectArrayList = mMainObjectArrayList;
    }

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public ArrayList<MainObject> getmMainObjectArrayList() {
        return mMainObjectArrayList;
    }

    public void setmMainObjectArrayList(ArrayList<MainObject> mMainObjectArrayList) {
        this.mMainObjectArrayList = mMainObjectArrayList;
    }
}