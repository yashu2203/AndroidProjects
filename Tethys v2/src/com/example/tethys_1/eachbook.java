package com.example.tethys_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.sweetlime.tethys.R;

public class eachbook extends Activity{
    String auth,sub,nmrp,omrp,mrp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eachbook);
		Intent i = getIntent();
		sub= i.getStringExtra("sub");
		auth= i.getStringExtra("auth");
		nmrp= i.getStringExtra("nmrp");
		omrp= i.getStringExtra("omrp");
		mrp= i.getStringExtra("mrp");
		
	   TextView tv = (TextView) findViewById(R.id.sub);
	    tv.setText(sub);
	    tv = (TextView) findViewById(R.id.auth);
	    tv.setText(auth);
	    tv = (TextView) findViewById(R.id.mrp);
	    tv.setText("Original : Rs"+mrp);
	    tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
	    tv = (TextView) findViewById(R.id.omrp);
	    tv.setText("Used Book : Rs"+ omrp);
	    tv = (TextView) findViewById(R.id.nmrp);
	    tv.setText("New Book : Rs"+nmrp);
	    
	    final Spinner s = (Spinner) findViewById(R.id.spinner1);
	    final String item[] = {"Old", "New"};
	    ArrayAdapter<String> adap = new ArrayAdapter<String>(this,R.layout.spinner_item,item);
	    s.setAdapter(adap);
	    
	    final EditText et = (EditText) findViewById(R.id.et1);
	   
	    
	    Button b = (Button) findViewById(R.id.addtocart);
	    b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String pr;
				if(s.getSelectedItemPosition()==0)
					pr=omrp;
				else
					pr=nmrp;
				
				//int q = Integer.parseInt(et.getText().toString());
				
				if(et.getText().toString().equals(""))
				{
					Toast.makeText(getApplicationContext(), "Please enter a quantity", Toast.LENGTH_SHORT).show();
					
				}
				else
				{
					final int q = Integer.parseInt(et.getText().toString());
				new cartdb(eachbook.this).addBook(new purchase(sub,auth,item[s.getSelectedItemPosition()],Integer.parseInt(pr),q));
				
				Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_SHORT).show();
				eachbook.this.finish();
				}		
				
			}
	    	
	    });
	}
    
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		eachbook.this.finish();
		
	}

	
	
}
