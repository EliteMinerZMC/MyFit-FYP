package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.joshuamiddletonfyp.myfitandroidfitnesspackage.UserAccount;
import com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment.ProfileContract.FeedEntry;

/**
 * Created by joshu on 02/04/2016.
 */
public class ProfileDBManager {
    public void writeToDB(UserAccount user, Context c){
        ProfileDBHelper mDbHelper = new ProfileDBHelper(c);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(FeedEntry.COLUMN_NAME_First_Name, user.getFirstName());
        values.put(FeedEntry.COLUMN_NAME_Last_Name, user.getLastName());
        values.put(FeedEntry.COLUMN_NAME_Age, user.getAge());
        values.put(FeedEntry.COLUMN_NAME_Email, user.getEmail());
        values.put(FeedEntry.COLUMN_NAME_User_Name, user.getUserName());
        values.put(FeedEntry.COLUMN_NAME_Password, user.getPassword());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FeedEntry.TABLE_NAME,
                null,
                values);
    }

}
