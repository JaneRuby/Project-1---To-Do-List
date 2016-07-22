package com.example.janerubygrissom.project1revised;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ArrayList<DetailsObject> items;
    Singleton otherSingleton;
    ArrayList<DetailsObject> customObjects;
    Button button;
    EditText editText;
    RecyclerViewAdapter2 recyclerViewAdapter2;


    //positioning the list items into the recycler view
    RecyclerView mRecyclerView;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        otherSingleton = Singleton.getInstance();

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTextTitle("Second Page");

        mRecyclerView = (RecyclerView) findViewById(R.id.lvItems);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

//sets the button and edit text
        button = (Button) findViewById(R.id.btnAddItem);
        editText = (EditText) findViewById(R.id.etNewItem);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        final RecyclerViewAdapter2 recyclerViewAdapter2 = new RecyclerViewAdapter2(otherSingleton.getmMainObjectArrayList().get(position));
        //check arraylist going in

        mRecyclerView.setAdapter(recyclerViewAdapter2);
//updates the view with the info from clicking the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String listTitle = editText.getText().toString();
                MainObject mainObject = otherSingleton.getmMainObjectArrayList().get(0);
                mainObject.getmDetailsObject().add(new DetailsObject(listTitle, "Test"));
//                items.add(new MainObject(listTitle, new ArrayList<DetailsObject>()));
                editText.setText("");
                recyclerViewAdapter2.notifyDataSetChanged();


            }
        });

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

}

