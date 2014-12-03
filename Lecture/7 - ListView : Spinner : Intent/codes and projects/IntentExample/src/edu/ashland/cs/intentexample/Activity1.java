package edu.ashland.cs.intentexample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity1);

	}

	public void onClick(View v) {
		Intent intent=new Intent(this, Activity2.class);
		startActivity(intent);


	}

}
