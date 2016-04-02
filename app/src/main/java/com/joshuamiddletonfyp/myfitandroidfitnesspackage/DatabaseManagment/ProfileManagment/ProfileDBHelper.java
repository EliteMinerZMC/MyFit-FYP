package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileContract;
/**
 * Created by joshu on 02/04/2016.
 */
public class ProfileDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ProfilesDatabase.db";
    ProfileContract pc = new ProfileContract();

    public ProfileDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(pc.getSqlCreateEntries());
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(pc.getSqlDeleteEntries());
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
