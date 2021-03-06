package edu.ashland.cs.webadvisor;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btnLogin;
	Button btnSearch;
	TextView errorMsg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        errorMsg = (TextView) findViewById(R.id.error);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
       	 
            public void onClick(View view) {
            	// Launch Dashboard Screen
                Intent dashboard = new Intent(MainActivity.this, Dashboard.class);
                startActivity(dashboard);
                // Close Login Screen
                finish();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
       	 
            public void onClick(View view) {
            	// Launch Search Screen
                Intent search = new Intent(MainActivity.this, Search.class);
                startActivity(search);
                // Close Login Screen
                finish();
            }
        });
    }
}
