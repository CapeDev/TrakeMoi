package com.thoughtworks.trakemoi.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TrakeMoiDatabase extends SQLiteOpenHelper {

    private static TrakeMoiDatabase trakeMoiDatabase;
    private static final String CLASS_TAG = "TrakeMoiDatabase";
    private static final String DATABASE_NAME = "TrakeMoiDatabase";
    private static final int DATABASE_VERSION = 1;

    public static final String ROWID = "_ID";

    public static final String PUNCH_TABLE = "punch";
    public static final String STATUS = "status";
    public static final String DATE = "date";
    public static final String TIME = "time";

    private static final String PUNCH_TABLE_CREATE_STMT =
            "create table " + PUNCH_TABLE
                    + " ("
                    + ROWID + " integer primary key autoincrement, "
                    + STATUS + " text not null, "
                    + DATE + " text not null, "
                    + TIME + " text not null"
                    + ");";

    public static final String ZONE_TABLE = "zone";
    public static final String NAME = "name";
    public static final String DESC = "desc";
    public static final String RADIUS = "radius";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    private static final String ZONE_TABLE_CREATE_STMT =
            "create table " + ZONE_TABLE
                    + " ("
                    + ROWID + " integer primary key autoincrement, "
                    + NAME + " text not null, "
                    + DESC + " text not null, "
                    + RADIUS + " integer not null, "
                    + LATITUDE + " double not null, "
                    + LONGITUDE + " double not null"
                    + ");";

    private TrakeMoiDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static TrakeMoiDatabase getInstance(Context context) {
        if (null == trakeMoiDatabase) {
            trakeMoiDatabase = new TrakeMoiDatabase(context);
        }
        return trakeMoiDatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PUNCH_TABLE_CREATE_STMT);
        sqLiteDatabase.execSQL(ZONE_TABLE_CREATE_STMT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(CLASS_TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + " which will destroy all old data.");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PUNCH_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ZONE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public synchronized void close() {
        super.close();
    }

}