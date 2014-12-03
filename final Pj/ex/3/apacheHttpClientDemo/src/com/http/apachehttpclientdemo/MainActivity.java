package com.http.apachehttpclientdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import com.bgxt.httpUtils.AndroidHttpClientUtils;
import com.bgxt.httpUtils.httpClientUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

	private Button btnLogin,btnAndroidHttpClient;
	 
	private EditText username,password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogin=(Button)findViewById(R.id.btnLogin);
//		public static TextView tvMsg=(TextView)findViewById(R.id.tvMsg);
		username=(EditText)findViewById(R.id.editText1);
		password=(EditText)findViewById(R.id.editText2);
		
		
		 btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String un=username.getText().toString();
				String pw=password.getText().toString();
				
				
				new Thread(new httpClientUtils(un,pw)).start();
			}
		});
		 
		 btnAndroidHttpClient=(Button)findViewById(R.id.btnAndrodHttpClient);
		 btnAndroidHttpClient.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String un=username.getText().toString();
				String pw=password.getText().toString();
				
				
				new Thread(new AndroidHttpClientUtils(un,pw)).start();
			}
		});
		 
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
