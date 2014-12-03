package edu.ashland.cs.webadvisor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class About extends Activity{

	ImageView imageView1;
	ImageView imageView2;
	RoundImage roundedImage;
	RoundImage roundedImage2;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.about);
          imageView1 = (ImageView) findViewById(R.id.imageView1);
          imageView2 = (ImageView) findViewById(R.id.imageView2);
          Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.image);
          Bitmap bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.image2);
          roundedImage = new RoundImage(bm);
          roundedImage2 = new RoundImage(bm2);
          imageView1.setImageDrawable(roundedImage);
          imageView2.setImageDrawable(roundedImage2);
          btnBack = (Button) findViewById(R.id.btnBack);
          btnBack.setOnClickListener(new View.OnClickListener() {
              
              public void onClick(View arg0) {
                  Intent back = new Intent(getApplicationContext(), MainActivity.class);
                  startActivity(back);
                  // Closing screen
                  finish();
              }
          });
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			Intent intent=new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

}
