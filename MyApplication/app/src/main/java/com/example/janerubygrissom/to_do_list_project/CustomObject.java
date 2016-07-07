package com.example.janerubygrissom.to_do_list_project;

/**
 * Created by janerubygrissom on 7/5/16.
 */

public class CustomObject {
    private String mTitle;
    private String mDescription;
    private String mColor;

    public CustomObject() {
        this.mTitle = "Title Text";
        this.mDescription = "Description Text";
        this.mColor = "#6200EA";

    }

    public CustomObject(String mTitle, String mDescription, String mColor) {

        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mColor = mColor;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String mColor) {
        this.mColor = mColor;
    }
}
