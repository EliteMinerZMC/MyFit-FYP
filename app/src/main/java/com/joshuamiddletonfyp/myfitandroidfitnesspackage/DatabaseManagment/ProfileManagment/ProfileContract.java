package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.ProfileManagment;

import android.provider.BaseColumns;

/**
 * Created by joshu on 02/04/2016.
 */
public final class ProfileContract {
        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        public ProfileContract() {}

        /* Inner class that defines the table contents */
        public static abstract class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "ProfilesTable";
            public static final String COLUMN_NAME_ENTRY_ID = "entryid";
            public static final String COLUMN_NAME_First_Name = "firstname";
            public static final String COLUMN_NAME_Last_Name = "lastname";
            public static final String COLUMN_NAME_Age = "age";
            public static final String COLUMN_NAME_Email = "email";
            public static final String COLUMN_NAME_User_Name = "username";
            public static final String COLUMN_NAME_Password = "password";
        }
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_First_Name + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_Last_Name + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_Age + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_Email + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_User_Name + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_Password + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    public static String getSqlCreateEntries() {
        return SQL_CREATE_ENTRIES;
    }

    public static String getSqlDeleteEntries() {
        return SQL_DELETE_ENTRIES;
    }
    }



