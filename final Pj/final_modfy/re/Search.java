package edu.ashland.cs.webadvisor;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Search extends Activity {
	Button btnSearch;
	//init php api key, term 4 url, classC and classN 4 GET
	private String term=null,classC=null,classN=null;	
	
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent intent=new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    	Spinner spinner = (Spinner)findViewById(R.id.spinner1);  
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    	        R.array.Code_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);        spinner.setAdapter(adapter);  
        spinner.setSelection(0);
        
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
          	
            public void onClick(View view) {
            	
            	
            	setPostData();

            		// Launch Class Screen
	                Intent search = new Intent(Search.this, Result.class);
	                search.putExtra("from", 0); // 0 = not login 
	                search.putExtra("term", term);
	                search.putExtra("classC", classC);
	                search.putExtra("classN", classN);
	                startActivity(search);
	                // Close Screen
	                finish();  	
            }
        });
	}
	
    
    //set term, classCode, class number
    public void setPostData() {
		Spinner spinner = (Spinner)findViewById(R.id.spinner1);
	    EditText classnumber =(EditText)findViewById(R.id.classnumber1);
		classC=  spinner.getSelectedItem().toString();
	 	classN= classnumber.getText().toString();
	 	RadioGroup radioGroup = (RadioGroup)findViewById(R.id.Gr);
	 	RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
	 	String term = radioButton.getText().toString();
	 	if(term.equalsIgnoreCase("Spring Semester 2015"))
	 		this.term="2015sp";
	 	if(term.equalsIgnoreCase("Fall Semester 2014"))
	 		this.term="2014fa";
	 	if(term.equalsIgnoreCase("Summer Semester 2014"))
	 		this.term="2014su";
		}
}
