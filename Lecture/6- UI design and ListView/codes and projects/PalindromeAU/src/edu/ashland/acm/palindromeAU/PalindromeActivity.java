package edu.ashland.acm.palindromeAU;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PalindromeActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);
        
        Button ok=(Button)findViewById(R.id.ok);
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

		        TextView tv=(TextView)findViewById(R.id.result);
		        EditText ev=(EditText)findViewById(R.id.enter);
		        
		        String input=ev.getText().toString();
		        boolean palindrome=true;
		        for (int i=0;i<input.length();i++){
		        	if(input.charAt(i)!=input.charAt(input.length()-1-i)){//not a palindrome
		        		tv.setText(input+" isn't a palindrome!");
		        		palindrome=false;
		        		break;
		        	}
		        }
		        if(palindrome){
		        	tv.setText(input+" is a palindrome!");
		        }
				
				
			}
		});
    }
}
