package com.lastdesk.count.lastcount;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lastcount.db";
    private static final int VERSION = 1;
    private static DatabaseHelper databaseHelperInstance = null;

    synchronized static DatabaseHelper getDatabaseHelperInstance(Context context) {
        if (databaseHelperInstance == null) {
            databaseHelperInstance = new DatabaseHelper(context);
        }
        return databaseHelperInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE events(timestamp INTEGER PRIMARY KEY, event_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new RuntimeException("Upgrade not yet supported, not enough hamsters to employ");
    }
}
