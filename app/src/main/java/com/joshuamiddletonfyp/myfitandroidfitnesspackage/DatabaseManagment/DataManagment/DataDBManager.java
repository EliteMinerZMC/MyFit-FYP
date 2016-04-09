package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileContract;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileDBHelper;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.UserAccount;

/**
 * Created by joshu on 05/04/2016.
 */
public class DataDBManager {
    public void writeToDB(StepData data  , Context c){
        DataDBHelper mDbHelper = new DataDBHelper(c);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DataContract.DataEntry.COLUMN_NAME_User_Name, data.getUsername());
        values.put(DataContract.DataEntry.COLUMN_NAME_Steps, data.getSteps());
        values.put(DataContract.DataEntry.COLUMN_NAME_Year, data.getYear());
        values.put(DataContract.DataEntry.COLUMN_NAME_Month, data.getMonth());
        values.put(DataContract.DataEntry.COLUMN_NAME_Day, data.getDay());
        values.put(DataContract.DataEntry.COLUMN_NAME_Hour, data.getHour());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ProfileContract.FeedEntry.TABLE_NAME,
                null,
                values);
    }

    public void deleteFromDb(int id, Context c){


    }
}
