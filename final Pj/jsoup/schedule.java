package webadvisor.plug;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class schedule {
	private Document doc = null;
	private sreach term = new sreach();
	public schedule(){
		File input = new File ("schedule.html");
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public schedule(String html){
		File input = new File (html);
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
String[] Term()
{
	return term.Term();
}
String[] TermName()
{
	return term.TermName();
}
int getSizeTerm(){
	return term.getSizeTerm();
}
int getSize(){
	Elements ee = doc.select(".windowIdx");
	return ee.size();
}
String[] Name()
{
	return Run("a#LIST_VAR6_");
}
String[] Meeting()
{
	return Run("p#LIST_VAR12_");
}
String[] Creds()
{
	return Run("p#LIST_VAR8_");
}
String[] Start()
{
	return Run("p#DATE_LIST_VAR1_");
}
String[] Run(String tag)
{
	int size = getSize();
	String[] stringArray = new String[size];
	for(int i = 0; i<size; i++){
	Elements e = doc.select(tag+i);
	stringArray[i]=e.text();
	}
	return stringArray;
	}
}
