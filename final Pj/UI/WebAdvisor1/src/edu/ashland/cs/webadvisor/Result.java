package edu.ashland.cs.webadvisor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class Result extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent intent=new Intent(this, Search.class);
			startActivity(intent);
			finish();
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
}
