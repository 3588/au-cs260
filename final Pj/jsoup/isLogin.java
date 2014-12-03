package webadvisor.plug;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class isLogin {
	private Document doc = null;
	public isLogin(){
		File input = new File ("afterLogin.html");
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public isLogin(String html){
		File input = new File (html);
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
boolean Run()
{
	Elements ee = doc.select("#sysLogout");
	if(!ee.isEmpty())
		return true;
	else 
		return false;

	}
public String Welcome(){
	Elements ee = doc.select("div.customText");
	return ee.get(2).text();
}
}
