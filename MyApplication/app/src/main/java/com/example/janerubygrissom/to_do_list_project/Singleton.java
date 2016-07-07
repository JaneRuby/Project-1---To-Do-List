package com.example.janerubygrissom.to_do_list_project;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by janerubygrissom on 7/7/16.
 */
public class Singleton {

    List <CustomObject2> bobDylan;

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

        bobDylan = new LinkedList<>();


    }

    public List <CustomObject> getBobDylan(int i){
        return bobDylan.get(i).getListOfCustom();
    }
}
