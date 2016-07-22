package com.example.janerubygrissom.project1revised;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by janerubygrissom on 7/21/16.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "List_DB";
    public static final String LIST_TABLE = "List_Table";
    public static final String COL_LIST_NAME = "List_Name";
    public static final String COL_LIST_ID = "_id";

    public static final String ITEM_TABLE = "Item_Table";
    public static final String COL_ITEM_NAME = "Item_Name";
    public static final String COL_DESC_NAME = "Description_Name";
    public static final String COL_ITEM_ID = "_id";
    public static final String COL_FOREIGN_KEY = "foreign_key";

    private static DBHelper sInstance;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static DBHelper getInstance(Context context){
        if(sInstance == null){
            sInstance = new DBHelper(context);
        }
       return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createString = "CREATE TABLE " + LIST_TABLE + "(" +
                COL_LIST_ID + " INTEGER PRIMARY KEY, " +
                COL_LIST_NAME + " TEXT)";
        sqLiteDatabase.execSQL(createString);

        createString = "CREATE TABLE " + ITEM_TABLE + "(" +
                COL_ITEM_ID + " INTEGER PRIMARY KEY , " +
                COL_ITEM_NAME + " TEXT, " +
                COL_DESC_NAME + " TEXT, " +
                COL_FOREIGN_KEY + " INTEGER, " +
                "FOREIGN KEY(" + COL_FOREIGN_KEY + ") REFERENCES " + LIST_TABLE + "(" + COL_LIST_ID + ") )";
        sqLiteDatabase.execSQL(createString);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String deleteTable = "DROP TABLE IF EXISTS " + LIST_TABLE;
        sqLiteDatabase.execSQL(deleteTable);

        deleteTable = "DROP TABLE IF EXISTS " + ITEM_TABLE;
        sqLiteDatabase.execSQL(deleteTable);

        onCreate(sqLiteDatabase);
    }

    public void insertListName(MainObject mainObject){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_LIST_NAME, mainObject.getmTitle());
        db.insertOrThrow(LIST_TABLE, null, values);
    }

    public void insertItemName(DetailsObject detailsObject, long listId){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_FOREIGN_KEY, listId);
        values.put(COL_ITEM_NAME, detailsObject.getmDetail());
        values.put(COL_DESC_NAME, detailsObject.getmDescription());
        db.insertOrThrow(ITEM_TABLE, null, values);
    }
}
