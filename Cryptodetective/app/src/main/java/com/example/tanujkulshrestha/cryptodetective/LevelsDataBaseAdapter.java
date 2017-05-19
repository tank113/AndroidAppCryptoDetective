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

public class LevelsDataBaseAdapter {
    static final String DATABASE_NAME_LEVEL = "LevelDatabase";
    static final int DATABASE_VERSION_LEVEL = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE_LEVEL = "create table " + "Answershints" + "( "
            + "ID text,ANSWERS text,HINTS text); ";
    public SQLiteDatabase dbl;
    private final Context context;
    private LevelsDataBaseHelper ldbHelper;

    public LevelsDataBaseAdapter(Context _context) {
        context = _context;
        ldbHelper = new LevelsDataBaseHelper(context, DATABASE_NAME_LEVEL, null,
                DATABASE_VERSION_LEVEL);
    }

    public LevelsDataBaseAdapter open(){
        dbl = ldbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbl.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return dbl;
    }

    public void insertEntry(String id, String ans, String hints) {
        ContentValues newValues = new ContentValues();
        newValues.put("ID", id);
        newValues.put("ANSWERS", ans);
        newValues.put("HINTS", hints);
        dbl.insert("Answershints", null, newValues);

    }


    public String getAnswer(String id) {
        System.out.println(id);
        Cursor check = dbl.rawQuery("select * from Answershints",null);
        check.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(check));
        String[] whereArgs = new String[] {
                id
        };
        Cursor cursor = dbl.query("Answershints",null, "ID=?",
                whereArgs, null, null, null);
        System.out.println(cursor.getCount());
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(cursor));
        String answers = cursor.getString(cursor.getColumnIndex("ANSWERS"));
        cursor.close();
        return answers;
    }

    public String getHint(String id) {
        System.out.println(id);
        Cursor check = dbl.rawQuery("select * from Answershints",null);
        check.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(check));
        String[] whereArgs = new String[] {
                id
        };
        Cursor cursor = dbl.query("Answershints",null, "ID=?",
                whereArgs, null, null, null);
        System.out.println(cursor.getCount());
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(cursor));
        String answers = cursor.getString(cursor.getColumnIndex("HINTS"));
        cursor.close();
        return answers;
    }
}

