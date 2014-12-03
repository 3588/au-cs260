package edu.ashland.cs.webadvisor;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import edu.ashland.cs.webadvisor.plug.getClassResult;
import edu.ashland.cs.webadvisor.plug.httpClientHelper;

public class Result extends Activity {
	
	private int from ;
	private String term;
	private String classC;
	private String classN;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setPostData();
        try {
			postData();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setList();
      //Log.d("MyLog", from+term+classC+classN);
	}
	public void onBackPressed() {
	    this.getParent().onBackPressed();   
	  }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent intent=new Intent(this, Search.class);
			startActivity(intent);
			finish();
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}
	public void setPostData() {
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		from=(Integer) bundle.get("from") ;
		term=(String)bundle.get("term");
		classC=(String)bundle.get("classC");
		classN=(String)bundle.get("classN");
		Log.d("MyLog", from+term+classC+classN);
	}
	public void postData() throws InterruptedException {
 		  
		// TODO Auto-generated method stub
		 final String[] keyStrings={""};
			final String[] dataStrings={""};
			final String url;
			if(!classN.isEmpty())
			url="http://cs260.3588.us/"+this.term+"apihtml.php?classC="+this.classC+"&classN="+this.classN;
			else
			url="http://cs260.3588.us/"+this.term+"apihtml.php?classC="+this.classC;
			Log.d("MyLog", url);
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					httpClientHelper server = new httpClientHelper();
					server.doPost(keyStrings, dataStrings,url,"sreachResults");//make the post
	}});
			thread.start();
			Thread.sleep(5000);//waiting to get website request and save to local file
			thread.interrupt();// I want to stop thread, I am not sure this call right or not, but not kill the program.
	}
	//set class data
    public void setList() {
    	ArrayList<String> content=new ArrayList<String>();
    	 	final ListView lv = (ListView) findViewById(R.id.listclass);//得到ListView对象的引用
    	final getClassResult classResult = new getClassResult();
    	Log.d("MyLog", Integer.toString(classResult.getSizeLevels()));
    	if(classResult.getSizeLevels()==0){
    		content.add("No Class");
    }else{
    content = new ArrayList<String>(Arrays.asList(classResult.className()));
    lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, content));
    			lv.setOnItemClickListener(new OnItemClickListener() {
    	@Override
    	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
    	AlertDialog.Builder adb=new AlertDialog.Builder(Result.this);
    	LayoutInflater inflater = Result.this.getLayoutInflater();
    	View view = inflater.inflate(R.layout.class_details, null);
    	adb.setView(view);
    	adb.setTitle("Class Details");
    	
    	TextView textView1 = (TextView) view.findViewById(R.id.textView1);
    	TextView textView2 = (TextView) view.findViewById(R.id.textView2);
    	TextView textView3 = (TextView) view.findViewById(R.id.textView3);
    	TextView textView4 = (TextView) view.findViewById(R.id.textView4);
    	TextView textView5 = (TextView) view.findViewById(R.id.textView5);
    	TextView textView6 = (TextView) view.findViewById(R.id.textView6);
    	
    	
    	textView1.setText(lv.getItemAtPosition(position).toString());
    	textView2.setText(classResult.classLcation()[position]);
    	textView3.setText(classResult.classMeeting()[position]);
    	textView4.setText(classResult.classFaculty()[position]);
    	textView5.setText(classResult.classCred()[position]);
    	textView6.setText(classResult.classLevel()[position]);
    	
    	adb.setPositiveButton("Cancel", null);
    	adb.setNegativeButton("Add to favorite class", null);
    	adb.show();
    	}
    	});
    }
 
    }
    
}
