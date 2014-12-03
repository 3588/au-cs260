package edu.ashland.cs.webadvisor.plug;
/* get class Results use jsoup(1.8.1) to parser html - test pass api19&21
 * jhuang@ashland.edu
 * 11/28/2014
 * ==ex==
 * getClassResult classResult = new getClassResult()
 * getClassResult classResult = new getClassResult(String data)
 * String[] data = classCode.classResult();
 * 
 * */
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class getClassResult {
	private Document doc = null;
	public getClassResult(){
		File input = new File ("/sdcard/sreachResults.html");
		//Log.d("MyLog", input.toString());
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public getClassResult(String input){
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
public String[] className(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#name");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public String[] classLcation(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#lcation");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public String[] classMeeting(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#meeting");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public String[] classFaculty(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#faculty");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public String[] classCred(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#cred");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public String[] classLevel(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p#level");
	int i=0;
	//save data to string array
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}
	return stringArray;
}
public int getSizeLevels(){
	Elements ee = doc.select("p");
	return ee.size();
}
}
