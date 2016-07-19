package com.example.janerubygrissom.project1revised;

/**
 * Created by janerubygrissom on 7/18/16.
 */
public class DetailsObject {


//string detail, description, getters setters
    //command n helps out with this

    String mDescription;
    String mDetail;

    public DetailsObject(String mDescription, String mDetail) {
        this.mDescription = mDescription;
        this.mDetail = mDetail;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }
}
