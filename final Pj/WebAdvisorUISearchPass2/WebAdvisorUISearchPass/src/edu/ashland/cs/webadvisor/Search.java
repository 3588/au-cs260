package edu.ashland.cs.webadvisor;



import edu.ashland.cs.webadvisor.plug.getClaccCode;
import edu.ashland.cs.webadvisor.plug.httpClientHelper;
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
import android.widget.Toast;

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
        
        //get class code
        try {
			setSpinner();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // end
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
	
	
	
	//get class code for set setSpinner action
    public void setSpinner() throws InterruptedException  {
    	Spinner spinner = (Spinner)findViewById(R.id.spinner1);  
        //ArrayAdapter<String> adapter = null;
        final String[] keyStrings={""};
		final String[] dataStrings={""};
		final String url="http://cs260.3588.us/2015spapihtml.php?getClassC";
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				httpClientHelper server = new httpClientHelper();
				server.doPost(keyStrings, dataStrings,url,"classCode");//make the post
}});
		thread.start();
		Thread.sleep(4000);//waiting to get website request and save to local file
		thread.interrupt();// I want to stop thread, I am not sure this call right or not, but not kill the program.
		getClaccCode classCode = new getClaccCode();
        final String [] classCodes = classCode.classCode();
    	for(String classcode : classCodes){
    		System.out.println(classcode);
    		//Log.d("MyLog", classcode);
    	}
        //spinner = (Spinner)findViewById(R.id.spinner1); 
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,classCodes); 
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        spinner.setAdapter(adapter);  
        adapter.notifyDataSetChanged(); //通知spinner刷新数据
      spinner.setSelection(0);
      spinner.setVisibility(View.VISIBLE);//设置默认显示 
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
	 	Toast.makeText(getApplicationContext(), "Search for "+term+" Class Code:"+classC+" Class Number:"+classN, Toast.LENGTH_SHORT).show();
		}
}
