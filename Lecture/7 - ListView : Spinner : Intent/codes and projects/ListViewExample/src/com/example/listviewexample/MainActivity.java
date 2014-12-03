package com.example.listviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<String> content;
	private Button b;
	private EditText entry;
	private ArrayAdapter<String> aa;
	private ListView v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		content=new ArrayList<String>();
		aa=new ArrayAdapter(this, android.R.layout.simple_list_item_1, content);
		v=(ListView)findViewById(R.id.data);
		v.setAdapter(aa);
		
		v.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				entry=(EditText)findViewById(R.id.entry);
				entry.setText(content.get(position));
				
				
			}
			
		});
		
		
		
	}
	
	public void onSave(View v){
		entry=(EditText)findViewById(R.id.entry);
		content.add(entry.getText().toString());
		entry.setText("");
		//aa.notifyDataSetChanged();
		
	}
}
