package edu.ashland.cs.spinnerexample;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int[] images={R.drawable.cao, R.drawable.ajwa, R.drawable.swanson};
	private ArrayList<String> contact;
	private Spinner list;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contact=new ArrayList<String>();
		contact.add("Paul Cao");
		contact.add("Iyad Ajwa");
		contact.add("Chris Swanson");
		ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, contact);
		list=(Spinner)findViewById(R.id.selection);
		list.setAdapter(adapter);
		
		list.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView name=(TextView)findViewById(R.id.name);
				ImageView image=(ImageView)findViewById(R.id.picture);
				name.setText(contact.get(position));
				image.setBackground(getResources().getDrawable(images[position]));
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
				
				
			}
		});
	}
}
