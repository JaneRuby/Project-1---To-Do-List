package com.example.janerubygrissom.to_do_list_project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by janerubygrissom on 7/7/16.
 */
public class Singleton {

    ArrayList<CustomObject2> bobDylan = new ArrayList<>();

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

        bobDylan = new ArrayList<>();


    }

    public ArrayList<CustomObject2> getBobDylan() {
        return bobDylan;
    }

    public void setBobDylan(ArrayList<CustomObject2> bobDylan) {
        this.bobDylan = bobDylan;
    }


    public List <CustomObject> getBobDylan2(int i){
        return bobDylan.get(i).getListOfCustom();
    }
}
