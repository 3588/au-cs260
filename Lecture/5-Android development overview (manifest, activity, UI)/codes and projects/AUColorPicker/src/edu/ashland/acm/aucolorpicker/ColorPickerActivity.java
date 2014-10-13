package edu.ashland.acm.aucolorpicker;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ColorPickerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_picker);
    }

	public void onClick(View view){
		RelativeLayout relative=(RelativeLayout)findViewById(R.id.whole);
		Button b=(Button)view;
		ColorStateList cl=b.getTextColors();
		relative.setBackgroundColor(cl.getDefaultColor());
	}

}
