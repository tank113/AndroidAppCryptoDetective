package com.example.tanujkulshrestha.cryptodetective;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by tanujkulshrestha on 18/03/17.
 */

//DataBaseAdapter to perform operation with SQL Database
public class DataBaseAdapter {
    static final String DATABASE_NAME = "UsersData";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "logindata" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "USERNAME  text,PASSWORD text); ";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;

    public DataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public DataBaseAdapter open(){
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String userName, String password) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        db.insert("logindata", null, newValues);

    }

    public int deleteEntry(String UserName) {

        String where = "USERNAME=?";
        int numberOFEntriesDeleted = db.delete("logindata", where,
                new String[] { UserName });
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String userName) {
        System.out.println(userName);
        /*String[] tableColumns = new String[] {
                "USERNAME"
        };*/
        String[] whereArgs = new String[] {
                userName
        };
        Cursor cursor = db.query("logindata",null , " USERNAME=?",
                whereArgs, null, null, null);
        System.out.println(cursor.getCount());
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(cursor));
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME =?";
        db.update("logindata", updatedValues, where, new String[] { userName });
    }
}

