package com.joshuamiddletonfyp.myfitandroidfitnesspackage.DatabaseManagment.DataManagment;

import android.provider.BaseColumns;

/**
 * Created by joshu on 05/04/2016.
 */
public class DataContract {
    public DataContract() {}

    /* Inner class that defines the table contents */
    public static abstract class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "DataTable";
        public static final String COLUMN_NAME_ID = "_Id";
        public static final String COLUMN_NAME_Steps = "Steps";
        public static final String COLUMN_NAME_Year = "year";
        public static final String COLUMN_NAME_Month = "month";
        public static final String COLUMN_NAME_Day = "day";
        public static final String COLUMN_NAME_Hour = "hour";
        public static final String COLUMN_NAME_User_Name = "username";
    }
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataEntry.TABLE_NAME + " (" +
                    DataEntry._ID + " INTEGER PRIMARY KEY," +
                    //FeedEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_Steps + INT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_Year + INT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_Month + INT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_Day + INT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_Hour + INT_TYPE + COMMA_SEP +
                    DataEntry.COLUMN_NAME_User_Name + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;


    public static String getSqlCreateEntries() {
        return SQL_CREATE_ENTRIES;
    }

    public static String getSqlDeleteEntries() {
        return SQL_DELETE_ENTRIES;
    }
}



