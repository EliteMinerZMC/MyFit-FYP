package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileContract;

/**
 * Created by joshu on 05/04/2016.
 */
public class DataDBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DataDatabase.db";
    DataContract pc = new DataContract();

    public DataDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String entries = pc.getSqlCreateEntries();
        db.execSQL(entries);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(pc.getSqlDeleteEntries());
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
