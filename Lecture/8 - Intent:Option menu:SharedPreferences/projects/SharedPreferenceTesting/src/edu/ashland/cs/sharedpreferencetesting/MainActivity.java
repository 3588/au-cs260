package edu.ashland.cs.sharedpreferencetesting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private MenuInflater mi;
	private SharedPreferences sp, sp1;
	private RelativeLayout rl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		rl=(RelativeLayout)findViewById(R.id.relative);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		mi=getMenuInflater();
		mi.inflate(R.menu.originalmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		if(id==R.id.setting){
			Intent intent=new Intent(MainActivity.this,MyPreferenceActivity.class);
			intent.putExtra("Pass", true);
			startActivity(intent);
			finish();
		}
		if(id==R.id.close){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setScreen(View v){
		boolean result=sp.getBoolean("colors", false);
		if(result){
			rl.setBackgroundColor(0xffCCFF33);
			
		}
		else{
			rl.setBackgroundColor(0xffFFFFF);
		}
		
		
	}
	
	
}
