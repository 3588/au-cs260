package edu.ashland.cs.webadvisor;

import edu.ashland.cs.webadvisor.plug.getClassResult;
import edu.ashland.cs.webadvisor.plug.httpClientHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    	ListView lv = (ListView) findViewById(R.id.listclass);//得到ListView对象的引用
    	getClassResult classResult = new getClassResult();
    	Log.d("MyLog", classResult.className()[0]);
    lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, classResult.className()));
 
    }
    
}
