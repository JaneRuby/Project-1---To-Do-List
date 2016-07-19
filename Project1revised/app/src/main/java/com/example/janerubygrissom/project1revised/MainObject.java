package com.example.janerubygrissom.project1revised;

import java.util.ArrayList;

/**
 * Created by janerubygrissom on 7/18/16.
 */
public class MainObject {
    private String mTitle;
    ArrayList<DetailsObject> mDetailsObject;

    //create array list of detail objects

    public MainObject(String mTitle, ArrayList<DetailsObject> mDetailsObject) {
        this.mTitle = mTitle;
        this.mDetailsObject = mDetailsObject;
    }

    //instantiate the detail objects
    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public ArrayList<DetailsObject> getmDetailsObject() {
        return mDetailsObject;
    }

    public void setmDetailsObject(ArrayList<DetailsObject> mDetailsObject) {
        this.mDetailsObject = mDetailsObject;
    }
}



// create a string title, arraylist of detailobjects, make getters and setters