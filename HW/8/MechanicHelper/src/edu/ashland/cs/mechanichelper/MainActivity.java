package edu.ashland.cs.mechanichelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        AUMechDB aumechtdb = new AUMechDB(getApplicationContext());
        
        SQLiteDatabase db = aumechtdb.getWritableDatabase();
        
     // insert some data
     		ContentValues v = new ContentValues();
     		v.put(aumechtdb.KEY_ID, 1);
     		v.put(aumechtdb.KEY_NAME, "Honda");
     		v.put(aumechtdb.KEY_part, "engine");
     		v.put(aumechtdb.KEY_price, 1000.23);
     		db.insert(aumechtdb.TABLE_NAME, null, v);
     		
     		v = new ContentValues();
     		v.put(aumechtdb.KEY_ID, 2);
     		v.put(aumechtdb.KEY_NAME, "Ford");
     		v.put(aumechtdb.KEY_part, "brake");
     		v.put(aumechtdb.KEY_price, 90.99);
     		db.insert(aumechtdb.TABLE_NAME, null, v);
     		
     		v = new ContentValues();
     		v.put(aumechtdb.KEY_ID, 3);
     		v.put(aumechtdb.KEY_NAME, "BMW");
     		v.put(aumechtdb.KEY_part, "tires");
     		v.put(aumechtdb.KEY_price, 4000.23);
     		db.insert(aumechtdb.TABLE_NAME, null, v);
     		
     		v = new ContentValues();
     		v.put(aumechtdb.KEY_ID, 4);
     		v.put(aumechtdb.KEY_NAME, "GMC");
     		v.put(aumechtdb.KEY_part, "belt");
     		v.put(aumechtdb.KEY_price, 40.95);
     		db.insert(aumechtdb.TABLE_NAME, null, v);
     		
     		String [] columns = {aumechtdb.KEY_ID, aumechtdb.KEY_NAME, aumechtdb.KEY_part, aumechtdb.KEY_price};
    		
    		Cursor cursor=db.query(aumechtdb.TABLE_NAME, columns, null, null, null, null, null);
    		if(cursor!=null){
    			cursor.moveToFirst();
    		}
    		
    		//link to a listview
    		ListView alldata=(ListView)findViewById(R.id.alldata);
    		int[] to={
    				R.id.manufacturer,
    				R.id.part,
    				R.id.price
    		};
    		
    		columns = new String[] {aumechtdb.KEY_NAME, aumechtdb.KEY_part, aumechtdb.KEY_price};

    		SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(), R.layout.mechanic_helper_layout, cursor, columns, to, 0);
    		alldata.setAdapter(adapter);
    		
    }
    private class AUMechDB extends SQLiteOpenHelper {
		private static final String DATABASE_NAME = "AUMechDB";
		private static final String TABLE_NAME = "Mechanic_helper";
		private static final int DATABASE_VERSION = 1;

		public static final String KEY_ID = "_id";
		public static final String KEY_NAME = "manufactur";
		public static final String KEY_part = "part";
		public static final String KEY_price = "price";

		private static final String DB_CREATE = " create table " + TABLE_NAME
				+ " ( " + KEY_ID + " integer primary key autoincrement, "
				+ KEY_NAME + " text not null, "
				+ KEY_part + " text not null, " 
				+ KEY_price+ " integer" + " );";

		public AUMechDB(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
