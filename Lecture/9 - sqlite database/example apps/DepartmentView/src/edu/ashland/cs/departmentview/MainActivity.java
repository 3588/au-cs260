package edu.ashland.cs.departmentview;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AUDeptDB audeptdb = new AUDeptDB(getApplicationContext(), "formal.db",
				null, 1);

		SQLiteDatabase db = audeptdb.getWritableDatabase();

		// insert some data
		ContentValues v = new ContentValues();
		v.put(audeptdb.KEY_CODE, "mathcs");
		v.put(audeptdb.KEY_NAME, "math and computer science");
		v.put(audeptdb.KEY_FACULTYNUMBER, 9);
		v.put(audeptdb.KEY_IMPORTANCE, "Super important!");
		db.insert(audeptdb.TABLE_NAME, null, v);
		
		v = new ContentValues();
		v.put(audeptdb.KEY_CODE, "chem");
		v.put(audeptdb.KEY_NAME, "Chemistry");
		v.put(audeptdb.KEY_FACULTYNUMBER, 12);
		v.put(audeptdb.KEY_IMPORTANCE, "important!");
		db.insert(audeptdb.TABLE_NAME, null, v);
		
		v = new ContentValues();
		v.put(audeptdb.KEY_CODE, "com");
		v.put(audeptdb.KEY_NAME, "Communications");
		v.put(audeptdb.KEY_FACULTYNUMBER, 7);
		v.put(audeptdb.KEY_IMPORTANCE, "kind of");
		db.insert(audeptdb.TABLE_NAME, null, v);
		
		//begin to put all data into a cursor (must have the _id column selected)
		String [] columns = {audeptdb.KEY_ID, audeptdb.KEY_CODE, audeptdb.KEY_NAME, audeptdb.KEY_FACULTYNUMBER, audeptdb.KEY_IMPORTANCE};
		
		Cursor cursor=db.query(audeptdb.TABLE_NAME, columns, null, null, null, null, null);
		if(cursor!=null){
			cursor.moveToFirst();
		}
		
		//link to a listview
		ListView alldata=(ListView)findViewById(R.id.alldata);
		int[] to={
				R.id.code,
				R.id.fullname,
				R.id.facultynumber,
				R.id.importance
		};
		//no _id column is selected when do the mapping
		columns = new String[] {audeptdb.KEY_CODE, audeptdb.KEY_NAME, audeptdb.KEY_FACULTYNUMBER, audeptdb.KEY_IMPORTANCE};

		SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(), R.layout.department_layout, cursor, columns, to, 0);
		alldata.setAdapter(adapter);
		
		

	}

	private class AUDeptDB extends SQLiteOpenHelper {
		private static final String DATABASE_NAME = "AUDept";
		private static final String TABLE_NAME = "dept";
		private static final int DATABASE_VERSION = 1;

		public static final String KEY_ID = "_id";// very important or else
													// adapter won't work
		public static final String KEY_CODE = "code";
		public static final String KEY_NAME = "name";
		public static final String KEY_FACULTYNUMBER = "number";
		public static final String KEY_IMPORTANCE = "importance";

		private static final String DB_CREATE = " create table " + TABLE_NAME
				+ " ( " + KEY_ID + " integer primary key autoincrement, "
				+ KEY_CODE + " text, " + KEY_NAME + " text not null, "
				+ KEY_FACULTYNUMBER + " integer, " + KEY_IMPORTANCE
				+ " text not null" + " );";

		public AUDeptDB(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(DB_CREATE);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w("TaskDBAdapter", "upgrade");
			db.execSQL("drop table if exists " + TABLE_NAME);
			onCreate(db);

		}

	}
}
