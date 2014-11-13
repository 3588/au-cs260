package edu.ashland.cs.contentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		final CS260RosterHelper test = new CS260RosterHelper(getApplicationContext(),
				"test.db", null, 1);
		ContentValues newValues = new ContentValues();
		final SQLiteDatabase db = test.getWritableDatabase();

		 newValues.put(test.KEY_ID, 1);
		newValues.put(test.KEY_STUDEN_NAME, "Chris Yocum");
		newValues.put(test.KEY_STUDENT_PERSONALITY, "Easy Going");
		newValues.put(test.KEY_STUDENT_GPA, 1.1);
		db.insert(test.DATABASE_TABLE, null, newValues);

		newValues = new ContentValues();
		newValues.put(test.KEY_ID, 2);
		newValues.put(test.KEY_STUDEN_NAME, "Paul Cao");
		newValues.put(test.KEY_STUDENT_PERSONALITY, "Even more easy going");
		newValues.put(test.KEY_STUDENT_GPA, 0.1);
		db.insert(test.DATABASE_TABLE, null, newValues);
		
		final EditText textedit = (EditText) findViewById(R.id.editText1);
		final TextView result=(TextView)findViewById(R.id.gpa);
		
		textedit.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode==KeyEvent.KEYCODE_ENTER){
					String[] columns = { test.KEY_STUDEN_NAME,
							test.KEY_STUDENT_PERSONALITY, test.KEY_STUDENT_GPA };
					String selection = test.KEY_STUDEN_NAME + " =?";
					String searchName=textedit.getText().toString();
					String args[] = { searchName };
					String groupBy = null;
					String having = null;
					String order = null;
					Cursor cursor = db.query(test.DATABASE_TABLE, columns, selection, args,
							groupBy, having, order);
					int value = cursor.getCount();
					int ColumnNumber = cursor.getColumnIndex(test.KEY_STUDENT_GPA);
					if (ColumnNumber > -1 && value > 0) {
						cursor.moveToFirst();
						float gpa = cursor.getFloat(ColumnNumber);
						result.setText(Double.toString((double)gpa));
					} else {// no entry is found
						result.setText("Sorry the person isn't found");
					}
					return true;
				}
				// TODO Auto-generated method stub
				return false;
			}
		});



	}
	




	private class CS260RosterHelper extends SQLiteOpenHelper {
		public static final String KEY_ID = "_id";
		public static final String KEY_STUDEN_NAME = "STUDENT_NAME_COLUMN";
		public static final String KEY_STUDENT_PERSONALITY = "STUDENT_PERSONALITY_COLUMN";
		public static final String KEY_STUDENT_GPA = "STUDENT_GPA_COLUMN";

		private static final String DATABASE_NAME = "myDatabase.db";
		private static final String DATABASE_TABLE = "CS260Student";
		private static final int DATABASE_VERSION = 1;
		private static final String DATABASE_CREATE = "create table "
				+ DATABASE_TABLE + " (" + KEY_ID
				+ " integer primary key autoincrement, " + KEY_STUDEN_NAME
				+ " text not null, " + KEY_STUDENT_PERSONALITY + " text, "
				+ KEY_STUDENT_GPA + " float);";

		public CS260RosterHelper(Context context, String name,
				CursorFactory factory, int version,
				DatabaseErrorHandler errorHandler) {
			super(context, name, factory, version, errorHandler);
			// TODO Auto-generated constructor stub
		}

		public CS260RosterHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
			// TODO Auto-generated method stub

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("TaskDBAdapter", "upgrade");
			db.execSQL("drop TABLE if exists " + DATABASE_TABLE);
			onCreate(db);
			// TODO Auto-generated method stub

		}

	}
}
