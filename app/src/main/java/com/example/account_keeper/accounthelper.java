package com.example.account_keeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class accounthelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "dataku.db";
    public static final String TABLE_NAME = "table_user";
    public static final int DATABASE_VERSION = 2;
    public static final String ID = "_Id";
    public static final String ACC = "Account_Name";
    public static final String NAME = "Name";
    public static final String MYPASSWORD = "Password";

    public accounthelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" Integer PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(225),"+MYPASSWORD+" Varchar(225))";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void tambahdata(account acc){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, acc.getUser());
        values.put(MYPASSWORD, acc.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<account> getData(){
        List<account> accountlist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                account acc = new account( cursor.getString(1), cursor.getString(2));
                accountlist.add(acc);
            } while (cursor.moveToNext());
        }
        return accountlist;
    }

    public int updateaccount(String oldname, String newName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.NAME,newName);
        contentValues.put(this.MYPASSWORD,newName);
        String[] whereArgs = {oldname};
        int count = db.update(this.TABLE_NAME,contentValues,
                this.NAME+"=?",whereArgs);
        return count;
    }

//    public int updateaccount(account account) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(NAME, account.getUser());
//        values.put(MYPASSWORD, account.getPass());
//        return db.update(TABLE_NAME, values, NAME + " = ?",
//                new String[]{String.valueOf(account.getNama())});
//    }

    public int delete(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs ={user};

        int count = db.delete(this.TABLE_NAME,this.NAME+"=?",whereArgs);
        return count;
    }
}
