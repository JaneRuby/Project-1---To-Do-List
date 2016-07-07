package com.example.janerubygrissom.to_do_list_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by janerubygrissom on 7/7/16.
 */
public class ObjectAdapter extends ArrayAdapter<CustomObject> {

    public ObjectAdapter(Context context, int resource, List<CustomObject> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int positon, View convertView, ViewGroup parent ){
        CustomObject object = getItem(positon);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView txt = (TextView) convertView.findViewById(android.R.id.text1);
        txt.setText(object.getTitle());

        return convertView;
    }
}
