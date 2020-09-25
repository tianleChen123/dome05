package com.example.dome05;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyProvider extends ContentProvider {
    private static final String TAG = "MyProvider";

    public static final int PERSON_DIR = 0;

    public static final int PERSON_ITEM = 1;

    public static final int RECENT_DIR = 2;

    public static final int RECENT_ITEM = 3;

    public static final String AUTHORITY = "com.example.dome05.provider";

    private static UriMatcher uriMatcher;

    private MyDatabaseHelper dbHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "Person", PERSON_DIR);
        uriMatcher.addURI(AUTHORITY, "Person/#", PERSON_ITEM);
        uriMatcher.addURI(AUTHORITY, "Recent", RECENT_DIR);
        uriMatcher.addURI(AUTHORITY, "Recent/#", RECENT_ITEM);
    }

    public MyProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // 删除数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int deletedRows = 0;
        switch (uriMatcher.match(uri)) {
            case PERSON_DIR:
                deletedRows = db.delete("Person", selection, selectionArgs);
                break;
            case PERSON_ITEM:
                String pid = uri.getPathSegments().get(1);
                deletedRows = db.delete("Person", "pid = ?", new String[]{pid});
                break;
            case RECENT_DIR:
                deletedRows = db.delete("Recent", selection, selectionArgs);
                break;
            case RECENT_ITEM:
                String pid1 = uri.getPathSegments().get(1);
                deletedRows = db.delete("Recent", "pid = ?", new String[]{pid1});
                break;
            default:
                break;
        }
        return deletedRows;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case PERSON_DIR:
                return "vnd.android.cursor.dir/vnd." + AUTHORITY + ".Person";
            case PERSON_ITEM:
                return "vnd.android.cursor.item/vnd." + AUTHORITY + ".Person";
            case RECENT_DIR:
                return "vnd.android.cursor.dir/vnd." + AUTHORITY + ".RECENT";
            case RECENT_ITEM:
                return "vnd.android.cursor.item/vnd." + AUTHORITY + ".RECENT";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)) {
            case PERSON_DIR:
            case PERSON_ITEM:
                long userId = db.insert("Person", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/person" + userId);
                break;

            case RECENT_DIR:
            case RECENT_ITEM:
                long recordId = db.insert("Recent", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/recent" + recordId);
                break;
            default:
        }
        return uriReturn;
    }

    @Override
    public boolean onCreate() {
        dbHelper = new MyDatabaseHelper(getContext(), "People.db", null, 1);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int updatedRows = 0;
        switch (uriMatcher.match(uri)) {
            case PERSON_DIR:
                updatedRows = db.update("Person", values, selection, selectionArgs);
                break;
            case PERSON_ITEM:
                String pid = uri.getPathSegments().get(1);
                updatedRows = db.update("Person", values, "pid = ?", new String[]{pid});
                break;
            case RECENT_DIR:
                updatedRows = db.update("Recent", values, selection, selectionArgs);
                break;
            case RECENT_ITEM:
                String pid1 = uri.getPathSegments().get(1);
                updatedRows = db.update("Recent", values, "pid = ?", new String[]{pid1});
                break;
            default:
                break;
        }
        return updatedRows;
    }


}
