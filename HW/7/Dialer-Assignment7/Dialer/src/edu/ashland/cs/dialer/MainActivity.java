package edu.ashland.cs.dialer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
	private MenuInflater mi;
	private TextView phone;
	private SharedPreferences sp;
	private Editor edit;
	Button one, two, three, four, five, six, seven, eight, nine, zero,call,star,pound,delete;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preference, false);
        sp=getSharedPreferences("phone",0);
		edit=sp.edit();
		phone=(TextView)findViewById(R.id.display);
		String old= sp.getString("phone", "");
		phone.setText(old);
		
        call=(Button)findViewById(R.id.call);
        delete=(Button)findViewById(R.id.delete);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        star = (Button) findViewById(R.id.star);
        pound = (Button) findViewById(R.id.pound);

        call.setOnClickListener(this); 
        delete.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        star.setOnClickListener(this);
        pound.setOnClickListener(this);
   }
    public void onClick(View v) {
    	String str = phone.getText().toString();
    	switch(v.getId()){
    		case R.id.call: 
    			if(str.length() == 0){
    				SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    		        String pho = sharedPreferences.getString("number", "");
    		        Intent callIntent = new Intent(Intent.ACTION_DIAL);
            		callIntent.setData(Uri.parse("tel:" + Uri.encode(pho)));
            		startActivity(callIntent);
    			}else{
        		String number="tel:"+phone.getText().toString();
        		Intent callIntent = new Intent(Intent.ACTION_DIAL);
        		callIntent.setData(Uri.parse("tel:" + Uri.encode(number)));
        		startActivity(callIntent);
    			}
    		break;
    		case R.id.one:
    			phone.setText(str+ "1");
    		break;
    		case R.id.two:
    			phone.setText(str+ "2");
    		break;
    		case R.id.three:
    			phone.setText(str+ "3");
    		break;
    		case R.id.four:
    			phone.setText(str+ "4");
    		break;
    		case R.id.five:
    			phone.setText(str+ "5");
    		break;
    		case R.id.six:
    			phone.setText(str+ "6");
    		break;
    		case R.id.seven:
    			phone.setText(str+ "7");
    		break;
    		case R.id.eight:
    			phone.setText(str+ "8");
    		break;
    		case R.id.nine:
    			phone.setText(str+ "9");
    		break;
    		case R.id.zero:
    			phone.setText(str+ "0");
    		break;
    		case R.id.star:
    			phone.setText(str+ "*");
    		break;
    		case R.id.pound:
    			phone.setText(str+ "#");
    		break;
    		case R.id.delete:
    			if(str.length()>0){
    				phone.setText(str.substring(0,str.length()-1));
    			}
    		break;
    	}
        	   }
    public boolean onCreateOptionsMenu(Menu menu) {
		mi=getMenuInflater();
		mi.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
    public boolean onOptionsItemSelected(MenuItem item) {
		int id=item.getItemId();
		if(id==R.id.setting){
			Intent intent=new Intent(MainActivity.this,MyPreferenceActivity.class);
			startActivity(intent);
			finish();
		}
		if(id==R.id.close){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_ENTER){//if the user press enter
			edit.putString("phone", ((TextView)findViewById(R.id.display)).getText().toString());
			edit.commit();
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onStop() {
		edit.putString("phone", ((TextView)findViewById(R.id.display)).getText().toString());
		edit.commit();
		super.onStop();
	}
}
