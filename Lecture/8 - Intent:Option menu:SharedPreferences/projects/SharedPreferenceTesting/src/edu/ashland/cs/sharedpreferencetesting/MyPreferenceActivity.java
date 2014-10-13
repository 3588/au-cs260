package edu.ashland.cs.sharedpreferencetesting;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.KeyEvent;
import android.widget.Toast;

public class MyPreferenceActivity extends PreferenceActivity {

	private boolean called;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//this is required
		addPreferencesFromResource(R.xml.preference);
		Intent intent=getIntent();
		called=intent.getExtras().getBoolean("Pass", false);
		if(called){
			Toast.makeText(this,"It passed to this preference activity" , Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			if(called){
				Intent intent=new Intent(this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
	
	
	
	
	
	

}
