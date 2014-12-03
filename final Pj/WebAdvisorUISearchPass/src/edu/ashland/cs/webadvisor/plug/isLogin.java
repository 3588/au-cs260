package edu.ashland.cs.webadvisor.plug;
/* check user's information use jsoup(1.8.1) to parser html - test pass api19&21
 * this class will do 2 thing
 * 1. check user can they login webadvisor
 * 2. add or update user information to database
 * jhuang@ashland.edu
 * 11/28/2014
 * ==ex==
 *isLogin checkLogin = new isLogin();
 *if(checkLogin.RunCode())
 *Toast.makeText(getApplicationContext(), checkLogin.Welcome(), Toast.LENGTH_SHORT).show();		
 * 
 * */


import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;
import android.widget.Toast;

public class isLogin {
	private Document doc = null;
	private fileHelper file;
	public isLogin(){
		// file = new toFile();
		File input = new File ("/sdcard/afterLogin.html");
		//Log.d("MyLog", input.toString());
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public isLogin(String input){
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean RunCode()
{
	Elements ee = doc.select("#sysLogout");
	Log.d("MyLog", ee.toString());
	if(!ee.isEmpty())
		return true;
	else 
		return false;

	}
public String Welcome(){
	
	Elements ee = doc.select("div.customText");
	Log.d("MyLog", ee.toString());
	return ee.get(2).text();
}
}
