package webadvisor.plug;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sreach {
	private Document doc = null;
	public sreach(){
		File input = new File ("sreach.html");
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public sreach(String html){
		File input = new File (html);
		try {
			 doc = Jsoup.parse(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	int getSizeSubjects(){
		Elements ee = doc.select("#LIST_VAR1_1 option");
		
		return ee.size();
	}

String[] Subjects()
{
	int size = getSizeSubjects();
	String[] stringArray = new String[size];
	Elements ee = doc.select("#LIST_VAR1_1 option");
	int i=0;
	for(Element e : ee){
		stringArray[i]=e.attr("value");
		i++;
	}

	return stringArray;
}
String[] SubjectsName()
{
	int size = getSizeSubjects();
	String[] stringArray = new String[size];
	Elements ee = doc.select("#LIST_VAR1_1 option");
	int i=0;
	for(Element e : ee){
		stringArray[i]=e.text();
		i++;
	}

	return stringArray;
}
int getSizeLevels(){
	Elements ee = doc.select("#LIST_VAR2_1 option");
	return ee.size();
}

String[] Levels()
{
int size = getSizeLevels();
String[] stringArray = new String[size];
Elements ee = doc.select("#LIST_VAR2_1 option");
int i=0;
for(Element e : ee){
	stringArray[i]=e.attr("value");
	i++;
}

return stringArray;
}
String[] LevelsName()
{
int size = getSizeLevels();
String[] stringArray = new String[size];
Elements ee = doc.select("#LIST_VAR2_1 option");
int i=0;
for(Element e : ee){
	stringArray[i]=e.text();
	i++;
}

return stringArray;
}

int getSizeTerm(){
	Elements ee = doc.select("#VAR1 option");
	return ee.size();
}

String[] Term()
{
int size = getSizeTerm();
String[] stringArray = new String[size];
Elements ee = doc.select("#VAR1 option");
int i=0;
for(Element e : ee){
	stringArray[i]=e.attr("value");
	i++;
}
return stringArray;
}
String[] TermName()
{
int size = getSizeTerm();
String[] stringArray = new String[size];
Elements ee = doc.select("#VAR1 option");
int i=0;
for(Element e : ee){
	stringArray[i]=e.text();
	i++;
}

return stringArray;
}
}
