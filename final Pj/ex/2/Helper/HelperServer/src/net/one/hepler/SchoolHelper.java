package net.one.hepler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolHelper extends HttpServlet {


//	public SchoolHelper() {
//		super();
//	}

//
//	public void destroy() {
//		super.destroy(); 
//
//	}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		//test(name);
		//test(psd);
		//System.out.println("name : " + name + "  psd" + psd);
		if("yang".equals(name)&&"123".equals(psd)){
			out.print("true");
		}else{
			out.print("false");
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doGet(request, response);

	}

//	private void test(String str){
//		try {
//			//1.创建file对象
//			File file=new File("E:\\input1.txt");
//			if(!file.exists()) //判断是否存在
//			{
//				file.createNewFile();
//				System.out.println("文件创建成功!");
//			}
//			//2.创建输出流  追加写 覆盖写
//			FileOutputStream fos=new FileOutputStream(file,true);
//			//3.输出操作
//			byte b[]={'a','b','c','d','e'};
//			fos.write(str.getBytes());
//			//4.清空流 关闭流
//			fos.flush();//*****
//			fos.close();
//			System.out.println("文件输出完毕！");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	public void init() throws ServletException {
//
//	}

}
