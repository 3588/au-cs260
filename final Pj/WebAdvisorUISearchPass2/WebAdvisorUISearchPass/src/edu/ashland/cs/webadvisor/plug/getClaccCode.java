package edu.ashland.cs.webadvisor.plug;
/* get class use jsoup(1.8.1) to parser html - test pass api19&21
 * jhuang@ashland.edu
 * 11/28/2014
 * ==ex==
 * getClaccCode classCode = new getClaccCode()
 * getClaccCode classCode = new getClaccCode(String data)
 * String[] data = classCode.classCode();
 * 
 * */
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class getClaccCode {
	private Document doc = null;
	public getClaccCode(){
		File input = new File ("/sdcard/classCode.html");
		//Log.d("MyLog", input.toString());
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public getClaccCode(String input){
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
public String[] classCode(){
	int size = getSizeLevels();
	String[] stringArray = new String[size];
	Elements ee = doc.select("p");
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
