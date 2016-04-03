package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void deleteFromDb(int id, Context c){


    }

    public boolean userLoginCheck(Context context, String username, String password){
        ProfileDBHelper pdb = new ProfileDBHelper(context);
        SQLiteDatabase db = pdb.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FeedEntry.COLUMN_NAME_User_Name,
                FeedEntry.COLUMN_NAME_Password,

        };
        String[] args = {
          username
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_User_Name + " DESC";
        Cursor c = db.query(
                FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                FeedEntry.COLUMN_NAME_User_Name,          // The columns for the WHERE clause
                args,                                 // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        long itemId = c.getLong(
                c.getColumnIndexOrThrow(FeedEntry._ID)
        );
        int id = ((int) itemId);

        String dbpassword = c.getString(c.getColumnIndex(FeedEntry.COLUMN_NAME_Password));
        if (dbpassword.equals(password)){
            return true;
        }else{
            return false;
        }
    }

}
