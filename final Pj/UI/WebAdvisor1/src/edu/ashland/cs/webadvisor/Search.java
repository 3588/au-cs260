package edu.ashland.cs.webadvisor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Search extends Activity {
	Button btnSearch;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
          	
            public void onClick(View view) {
            		// Launch Class Screen
	                Intent search = new Intent(Search.this, Result.class);
	                startActivity(search);
	                // Close Screen
	                finish();
            	
            	
            }
        });
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent intent=new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
}
