package com.bgxt.httpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class HTMLParser {

	private String firstname, htmlString;
	private Document doc;
	public HTMLParser(String html){
		htmlString=html;
		doc=Jsoup.parse(html);
	}
	public String  GET_LIST_VAR1_left_oddrow() {
		Element t;
		t=doc.select("div.mainBody").first();
		t=t.select("div.custom").first();
		t=t.select("div.customText").first();
		return 
	}
}
