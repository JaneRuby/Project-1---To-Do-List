package com.example.janerubygrissom.to_do_list_project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janerubygrissom on 7/7/16.
 */
public class CustomObject2 {
    private String mTitle;
    private String mColor;

    List<CustomObject> listOfCustom;

    public CustomObject2() {
        this.mTitle = "Title Text";
        this.listOfCustom = new ArrayList<>();

        this.mColor = "#6200EA";

    }

    public CustomObject2(String mTitle, ArrayList <CustomObject> listOfCustom, String mColor) {

        this.mTitle = mTitle;
        this.mColor = mColor;
        this.listOfCustom = listOfCustom;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String mColor) {
        this.mColor = mColor;
    }

    public List<CustomObject> getListOfCustom() {
        return listOfCustom;
    }

    public void setListOfCustom(List<CustomObject> listOfCustom) {
        this.listOfCustom = listOfCustom;

    }
}
