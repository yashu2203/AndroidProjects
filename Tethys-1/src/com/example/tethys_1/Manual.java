package com.example.tethys_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.sweetlime.tethys.R;

public class Manual extends Activity {

	EditText e1,e2,e3,e4,e5;
	Button b;
	Spinner s1;
	
	String cond[]={"Select Book Condition","Old","New"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manual);
		s1=(Spinner) findViewById(R.id.condspinn);
		e1 = (EditText) findViewById(R.id.sub);
		e2 = (EditText) findViewById(R.id.author);
		e3 = (EditText) findViewById(R.id.custn);
		e4 = (EditText) findViewById(R.id.custp);
		e5 = (EditText) findViewById(R.id.Qedit);
		b = (Button) findViewById(R.id.mproceed);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cond);

		s1.setAdapter(adapter);
		
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
				String condi = cond[s1.getSelectedItemPosition()];
				
				
				boolean a = validate();

				if(a==true)
				{
				Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:storetethys@yahoo.com"));
				  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
				  email.putExtra(Intent.EXTRA_SUBJECT, "Order for Books");
				  email.putExtra(Intent.EXTRA_TEXT,"Book Wanted:\nCustomer Name:"+custn+"\n Customer Phone:"+custp+"\n Subject:"+sub+"\nAuthor:"+author+"\nQuantity:"+quantity);
				
					
				  Intent i = new Intent(Manual.this,AutoSelect.class);
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
				
				
				if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("") ||e4.getText().toString().equals("") ||e5.getText().toString().equals("") || e4.getText().toString().length()<10 || s1.getSelectedItemPosition()==0 )
				return false;
				
				else 
					return true;
			}
		});
		
		
	}

}