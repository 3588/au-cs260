package edu.ashland.cs.dialer;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.KeyEvent;

public class MyPreferenceActivity extends PreferenceActivity{
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this is required
		addPreferencesFromResource(R.xml.preference);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
				Intent intent=new Intent(this, MainActivity.class);
				startActivity(intent);
				finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
