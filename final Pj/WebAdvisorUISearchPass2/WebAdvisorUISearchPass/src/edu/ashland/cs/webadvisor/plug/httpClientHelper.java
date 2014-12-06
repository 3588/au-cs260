package edu.ashland.cs.webadvisor.plug;
/*Andorid HTTP POST GET Class - test pass on api19&21
 * need add permission
 * <uses-permission android:name="android.permission.INTERNET"/
 * This class post data to webadvisor and PHP API, and use fileHelper to save result to loac html file
 * This class get data from PHP API, and save to html file
* jhuang@ashland.edu
 * 11/28/2014
 * 
 * ==ex==
 * httpClientHelper server = new httpClientHelper();
 * server.doPost(String[] keyStrings,String[] dataStrings,String url,"xxxx");
 *  GET use doPost also, post null key and data
 * */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;

import android.util.Log;

public class httpClientHelper {
	private String result="",fileName="", urlinit="https://webadvisor.ashland.edu";
	public String doPost(String[] keyStrings, String[] dataStrings, String url, String fileName) {
		this.fileName = fileName;
		HttpClient hc = new DefaultHttpClient();
		HttpPost hp = new HttpPost(urlinit);//for webadvisor only
		HttpProtocolParams.setUserAgent(hc.getParams(), "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 4 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		hc.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for(int i=0; i<keyStrings.length ;i++)
			list.add(new BasicNameValuePair(keyStrings[i], dataStrings[i]));
		try {
			HttpEntity he =new UrlEncodedFormEntity(list,"utf-8");
			HttpResponse response = hc.execute(hp);
			hp = new HttpPost(url);
			hp.setEntity(he);
			response = null;
			response = hc.execute(hp);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity het =response.getEntity();			
				InputStream in = het.getContent();
				BufferedReader bf = new BufferedReader(new InputStreamReader(in));
				String redLine = null;
				while((redLine=bf.readLine())!=null){
					//System.out.println(redLine);
					result=result+redLine;
				}
				in.close();
			}else{
				result = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "Exception";
		}
		save();
		return result;
	}
	//use fileHelper to save the result to file
	//must save data in Thread since this class run under the Thread
	public Boolean save() {
		fileHelper saveToFile = new fileHelper();
		saveToFile.write(fileName, result);
		if(saveToFile.write(fileName, result)){
		    Log.d("MyLog", fileName+".html created");
		    return true;
		    }else{
		    	Log.d("MyLog", "I/O error");
		    	return false;
		    }
	}}
