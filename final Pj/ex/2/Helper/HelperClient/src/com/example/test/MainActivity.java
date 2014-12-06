package com.example.test;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button landBtn;
	private EditText idEdit;
	private EditText pwdEdit;
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		super.setContentView(R.layout.activity_main);
		inInt();
	}
	private void inInt(){

		this.landBtn = (Button)super.findViewById(R.id.user_land);
		this.idEdit = (EditText)super.findViewById(R.id.user_id);
		this.pwdEdit = (EditText)super.findViewById(R.id.user_pwd);
		this.landBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		login();

	}
	public void login()  
	{    
		//取得用户输入的账号和密码  
		String name=idEdit.getText().toString();  
		String pass=pwdEdit.getText().toString();  

		final Handler handler = new Handler(){
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				String str = (String)msg.obj;
				System.out.println(str);
				if("true".equals(str)){
					Toast.makeText(getApplicationContext(), "登陆成功", 8000).show();
				}else{
					Toast.makeText(getApplicationContext(), "登陆失败", 8000).show();
				}				
		}
	};
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			LandServer server = new LandServer();
			String result = server.doPost(idEdit.getText().toString(), pwdEdit.getText().toString());
			Message msg = new Message();
			msg.obj = result;
			handler.sendMessage(msg);
			
		}
	}).start();
}  
}
