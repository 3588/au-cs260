package webadvisor.plug;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		sreachResult test = new sreachResult();
		int size=test.getSize();
		String[] datas=new String[size];
		datas = test.Meeting();
		for(String data:datas){
			System.out.println(data);
		}
		
		/*
		sreach test = new sreach();
		int size=test.getSizeLevels();
		String[] datas=new String[size];
		datas = test.LevelsName();
		for(String data:datas){
			System.out.println(data);
		}
		
		size=test.getSizeSubjects();
		datas=new String[size];
		datas = test.Subjects();
		for(String data:datas){
			System.out.println(data);
		}
		*/
		/*
		isLogin test = new isLogin();
		if(test.Run())
			System.out.println(test.Welcome());
			*/
		/*
		schedule test = new schedule();
		int size=test.getSize();
		String[] datas=new String[size];
		datas = test.Meeting();
		for(String data:datas){
			System.out.println(data);
		}
		size=test.getSizeTerm();
		datas=new String[size];
		datas = test.Term();
		for(String data:datas){
			System.out.println(data);
		}
		*/
	}

}
