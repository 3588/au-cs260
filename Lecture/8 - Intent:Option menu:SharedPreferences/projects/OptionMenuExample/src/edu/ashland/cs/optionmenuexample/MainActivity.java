package edu.ashland.cs.optionmenuexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {
	private final int CALL=1;
	private final int EMAIL=2;
	private final int SMS=3;
	private EditText address;
	private EditText body;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(Menu.NONE, CALL, Menu.NONE, "Make a call!");
		menu.add(Menu.NONE, EMAIL, Menu.NONE, "EMail this!");
		menu.add(Menu.NONE, SMS, Menu.NONE, "SMS");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		address=(EditText)findViewById(R.id.address);
		body=(EditText)findViewById(R.id.body);
		if(item.getItemId()==CALL){
			
			Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+address.getText().toString()));
			startActivity(intent);
		}
		else if(item.getItemId()==EMAIL){
			
			Intent intent=new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_EMAIL, new String[]{address.getText().toString()});
			intent.putExtra(Intent.EXTRA_SUBJECT, "hello from cs260");
			intent.putExtra(Intent.EXTRA_TEXT,body.getText().toString());
			startActivity(intent);
		}
		else if(item.getItemId()==SMS){
			Uri uri=Uri.parse("tel:"+address.getText().toString());
			Intent intent=new Intent(Intent.ACTION_VIEW, uri);
			intent.putExtra("sms_body", body.getText().toString());
			intent.setType("vnd.android-dir/mms-sms");
			startActivity(intent);
		}
		
		return true;
	}
	
}
