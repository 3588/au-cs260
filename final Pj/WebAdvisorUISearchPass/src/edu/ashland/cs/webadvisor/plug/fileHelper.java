package edu.ashland.cs.webadvisor.plug;
/*Andorid Write and Read file Class - test pass on api19&21
 * need add permission
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 * <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 * jhuang@ashland.edu
 * 11/28/2014
 * 
 * 
 * ==ex==
 * fileHelper file = new fileHelper();
 * if(file.write(filename, data))
 *    OK
 * String data = file.read(filename);
 * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class fileHelper {
   public fileHelper() {
      }
   public Boolean write(String fname, String fcontent){
      try {
    	  //save to sdcard only, dont save to other dir
        String fpath = "/sdcard/"+fname+".html";
        File file = new File(fpath);
        // If file does not exists, then create it
        if (!file.exists()) {
          file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(fcontent);
        bw.close();
        fw.close();
        return true;
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
   }
   //didn't usr it in this app
   //find other simple way
   //File input = new File ("/sdcard/xxxx.html");
   //String data = input.toString();
   public String read(String fname){
     BufferedReader br = null;
     String response = null;
      try {
        StringBuffer output = new StringBuffer();
        String fpath = "/sdcard/"+fname+".html";
        br = new BufferedReader(new FileReader(fpath));
        String line = "";
        while ((line = br.readLine()) != null) {
          output.append(line +"\n");
        }
        response = output.toString();
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
      return response;
   }
}