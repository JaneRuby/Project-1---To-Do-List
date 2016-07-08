package com.example.janerubygrissom.to_do_list_project;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private List<CustomObject> items;
    private ArrayAdapter<CustomObject> itemsAdapter;
    private ListView lvItems;
    ObjectAdapter mAdapter;
    Singleton robertZimmerman;
    List<CustomObject> customObjects;

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        robertZimmerman = Singleton.getInstance();
        customObjects = robertZimmerman.getBobDylan(getIntent().getIntExtra("position", 0));
        items = customObjects;

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTextTitle("MAinlist");

        lvItems = (ListView) findViewById(R.id.lvItems);
        mAdapter = new ObjectAdapter(this, android.R.layout.simple_list_item_1, items);
       //itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
       lvItems.setAdapter(mAdapter);


        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                onCreateDialog();
            }
        });

       setupListViewListener();
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();

        //get edittext, check if it's empty, null, just.  If it's empty, don't do anything, else, do the stuff right above.

        if (etNewItem.getText().toString().equals("")) {
            etNewItem.setError("Please enter text!");

        }else{
        items.add(new CustomObject(itemText, "description", "#6200EA"));
        etNewItem.setText("");
        mAdapter.notifyDataSetChanged();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etNewItem.getWindowToken(), 0);
    }
    }


        private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the mAdapter
                        mAdapter.notifyDataSetChanged();

                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }

}

