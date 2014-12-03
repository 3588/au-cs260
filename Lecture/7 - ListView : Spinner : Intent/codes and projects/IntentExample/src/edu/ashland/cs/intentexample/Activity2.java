package edu.ashland.cs.intentexample;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity2);
	}

	public void onClick2(View v) {
		Intent intent = new Intent(this, Activity1.class);
	
		startActivity(intent);
	}
	
	

}
