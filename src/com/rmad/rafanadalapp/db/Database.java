package com.rmad.rafanadalapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "RafaNadalAppDB";

	public Database(Context context) {
		super(context, DATABASE_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE trivia (_id INTEGER PRIMARY KEY AUTOINCREMENT, trivia_string TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void addTrivia(String trivia) {
		ContentValues values = new ContentValues(1);
		values.put("trivia_string", trivia);
		getWritableDatabase().insert("trivia", "_id", values);

	}

	public Cursor getTrivia() {
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM trivia ORDER BY RANDOM() LIMIT 1", null); 
		return cursor;
	}

}
