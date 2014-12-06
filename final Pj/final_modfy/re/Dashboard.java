package edu.ashland.cs.webadvisor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Activity {
	 Button btnLogout;
	 Button btnSearch;
	 Button btnFavoriteClass;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.dashboard);
            btnLogout = (Button) findViewById(R.id.btnLogout);
            btnSearch = (Button) findViewById(R.id.btnSearch);
            btnFavoriteClass = (Button) findViewById(R.id.btnFavoriteClass);
            btnLogout.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View arg0) {
                    Intent login = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(login);
                    // Closing dashboard screen
                    finish();
                }
            });
            btnSearch.setOnClickListener(new View.OnClickListener() {
             	 
                public void onClick(View view) {
                	// Launch Search Screen
                    Intent search = new Intent(Dashboard.this, Search.class);
                    startActivity(search);
                    // Close Login Screen
                    finish();
                }
            });
            btnFavoriteClass.setOnClickListener(new View.OnClickListener() {
             	 
                public void onClick(View view) {
                	// Launch Screen
                    Intent intent = new Intent(Dashboard.this, FavoriteClass.class);
                    startActivity(intent);
                    // Close Screen
                    finish();
                }
            });
	    }
}
