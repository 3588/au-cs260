package edu.ashland.cs.listexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ArrayList<String> content;
	private EditText e;
	private Button b;
	private ListView myListView;
	private ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		content = new ArrayList<String>();
		e = (EditText) findViewById(R.id.entry);
		b = (Button) findViewById(R.id.save);
		myListView = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
				content);
		myListView.setAdapter(adapter);

	}

	public void onSave(View view) {
		content.add(e.getText().toString());
		adapter.notifyDataSetChanged();
		e.setText("");
	}
}
