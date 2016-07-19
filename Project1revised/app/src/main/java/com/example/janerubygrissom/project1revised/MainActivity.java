package com.example.janerubygrissom.project1revised;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainObject> items;
    private RecyclerView lvItems;
    Singleton mSingleton;
    RecyclerView mRecyclerView;
    Button button;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//set singleton
        mSingleton = Singleton.getInstance();
//set edits, singleton, listview items
        lvItems = (RecyclerView) findViewById(R.id.listview);
        items = mSingleton.getmMainObjectArrayList();
        button = (Button) findViewById(R.id.btnAddItem);
        editText = (EditText) findViewById(R.id.etNewItem);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvItems.setLayoutManager(llm);

//set recycler view adapter
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items);


        lvItems.setAdapter(recyclerViewAdapter);

        //adds the text when the button is clicked, the info is updated
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listTitle = editText.getText().toString();
                items.add(new MainObject(listTitle, new ArrayList<DetailsObject>()));
                editText.setText("");
                recyclerViewAdapter.notifyDataSetChanged();

            }
        });
    }
}


//reference recycler view, make adapter, linear layout manager
