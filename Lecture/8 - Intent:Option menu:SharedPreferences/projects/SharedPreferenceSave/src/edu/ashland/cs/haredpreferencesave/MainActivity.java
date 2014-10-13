package edu.ashland.cs.haredpreferencesave;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

public class MainActivity extends Activity {

	private SharedPreferences sp;
	private Editor edit;
	private final String SPNAME="260";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp=getSharedPreferences(SPNAME,0);
		edit=sp.edit();
		EditText email=(EditText)findViewById(R.id.email);
		String old= sp.getString("OldAddress", "");
		email.setText(old);
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_ENTER){//if the user press enter
			edit.putString("OldAddress", ((EditText)findViewById(R.id.email)).getText().toString());
			edit.commit();
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
		edit.putString("OldAddress", ((EditText)findViewById(R.id.email)).getText().toString());
		edit.commit();
		super.onStop();
	}
	
	
	
}
