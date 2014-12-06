package webadvisor.plug;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class jsoup {
	private Document doc = null;
	public jsoup(){
		File input = new File ("sreachResults.html");
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public jsoup(String html){
		File input = new File (html);
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	int getSize(){
		Elements ee = doc.select(".windowIdx");
		return ee.size();
	}

String[] Term()
{
	return Run("p#WSS_COURSE_SECTIONS_");
}
String[] Status()
{
	return Run("p#LIST_VAR1_");
}
String[] Name()
{
	return Run("a#SEC_SHORT_TITLE_");
}
String[] Location()
{
	return Run("p#SEC_LOCATION_");
}
String[] Meeting ()
{
	return Run("p#SEC_MEETING_INFO_");
}
String[] Faculty()
{
	return Run("p#SEC_FACULTY_INFO_");
}
String[] Academic()
{
	return Run("p#SEC_ACAD_LEVEL_");
}
String[] Run(String tag)
{
	int size = getSize();
	String[] stringArray = new String[size];
	for(int i = 1; i<size; i++){
	Elements e = doc.select(tag+i);
	stringArray[i]=e.text();
	}
	stringArray[0] = Integer.toString(size);
	
	return stringArray;
	}

}
