package com.example.tethys_1;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.sweetlime.tethys.R;

@SuppressLint("NewApi") public class Manual extends Activity {

	EditText e1,e2,e3,e4,e5;
	Button b;
Spinner s1;
	RadioGroup r;
	RadioButton c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		int color = i.getIntExtra("color",R.color.black);
		
	/*	Window window = getWindow();
	    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
	    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	    window.setStatusBarColor(color); */
		
	    setContentView(R.layout.manual);
	    ActionBar ab = getActionBar();
	
	    r  = (RadioGroup) findViewById(R.id.radiogrup);
	     	 	
	    
		ab.setBackgroundDrawable(getResources().getDrawable(color));
		
		e1 = (EditText) findViewById(R.id.sub);
		e2 = (EditText) findViewById(R.id.author);
		e3 = (EditText) findViewById(R.id.custn);
		e4 = (EditText) findViewById(R.id.custp);
		e5 = (EditText) findViewById(R.id.Qedit);
		b = (Button) findViewById(R.id.mproceed);
		
		setContentView(R.layout.manual);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String to="storetethys@yahoo.com"; // EMAIL ID
				String sub = e1.getText().toString();
				String author= e2.getText().toString();
				String custn = e3.getText().toString();
				String custp  =e4.getText().toString();
				String quantity = e5.getText().toString();
				
				
				c= (RadioButton) findViewById(r.getCheckedRadioButtonId());
				 	
		        String cond = c.getText().toString();
				
				
				boolean a = validate();

				if(a==true)
				{
				Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:storetethys@yahoo.com"));
				  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
				  email.putExtra(Intent.EXTRA_SUBJECT, "Order for Books");
				  email.putExtra(Intent.EXTRA_TEXT,"Book Wanted:\nCustomer Name:"+custn+"\n Customer Phone:"+custp+"\n Subject:"+sub+"\nAuthor:"+author+"\nQuantity:"+quantity+"Condition:"+cond);
				
					
				  Intent i = new Intent(Manual.this,NavigationActivity.class);
				 // i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
				  startActivity(i);
				  
				  
				  startActivity(Intent.createChooser(email, "Choose an Email client :"));
				
				  finish();
				}
				else
				{
					Toast.makeText(getApplicationContext(),"Enter valid information in all fields",Toast.LENGTH_SHORT).show();
				}
				//  email.setType("message/rfc822");
			
				  //DB CODE.....................
				  
				 
			}

			private boolean validate() {
				// TODO Auto-generated method stub
				
				
				if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("") ||e4.getText().toString().equals("") ||e5.getText().toString().equals("") || e4.getText().toString().length()<10 )
				return false;
				
				else 
					return true;
			}
		});
		
		
	}

}