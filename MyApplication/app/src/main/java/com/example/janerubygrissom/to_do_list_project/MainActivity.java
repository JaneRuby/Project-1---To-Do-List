package com.example.janerubygrissom.to_do_list_project;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ArrayList<CustomObject2> items;
    private ArrayAdapter<CustomObject2> itemsAdapter;
    private RecyclerView lvItems;
    ObjectAdapter2 mAdapter;
    Singleton robertZimmerman;
    RecyclerView mRecyclerView;
    Button button;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        robertZimmerman = Singleton.getInstance();


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTextTitle("MAinlist");

        lvItems = (RecyclerView) findViewById(R.id.listview);
        items = robertZimmerman.bobDylan;
        button = (Button) findViewById(R.id.btnAddItem);
        editText = (EditText) findViewById(R.id.etNewItem);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvItems.setLayoutManager(llm);

        //For a listView adapter:
//
//        mAdapter = new ObjectAdapter2(this, android.R.layout.simple_list_item_1, items);
//        //itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
//        lvItems.setAdapter(mAdapter);
//
//
//
//        setupListViewListener();

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(items);


        lvItems.setAdapter(recyclerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listTitle = editText.getText().toString();
                items.add(new CustomObject2(listTitle, "something"));
                editText.setText("");
                recyclerViewAdapter.notifyDataSetChanged();

            }
        });
    }

//    public void onAddItem(View v) {
//        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
//        String itemText = etNewItem.getText().toString();
//
//        if (etNewItem.getText().toString().equals("")) {
//            etNewItem.setError("Please enter text!");
//        } else {
//
//            items.add(new CustomObject2(itemText, new ArrayList<CustomObject>(), "#6200EA"));
//            etNewItem.setText("");
//            mAdapter.notifyDataSetChanged();
//
//        }
//    }

//    private void setupListViewListener() {
//        lvItems.setOnItemLongClickListener(
//                new AdapterView.OnItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> adapter,
//                                                   View item, int pos, long id) {
//                        // Remove the item within array at position
//                        items.remove(pos);
//                        // Refresh the mAdapter
//                        mAdapter.notifyDataSetChanged();
//
//                        // Return true consumes the long click event (marks it handled)
//                        return true;
//                    }
//
//                });
//        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(view.getContext(), Main2Activity.class);
//                intent.putExtra("position", i);
//                startActivity(intent);
//            }
//        });
//    }
}


