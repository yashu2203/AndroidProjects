package com.example.tethys_1;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.sweetlime.tethys.R;

public class AutoSelect extends Activity{
Spinner s1,s2;
Button b1;
String s;
String[] dept={"MECH","AUTO","CSE","IT","ECE","EEE","BIOTECH","AERO","CIVIL"};
String[] sem={"2","4","6",};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autoselect);
		
		
		 final String DB_PATH = "data/data/"+getPackageName()+"/databases/cart3";
		 
		 try{
	        	File file = new File(DB_PATH);
		 if(file.exists())
		 {
			
			 File f = new File("data/data/"+getPackageName()+"/databases/file");
			 
			 
			 if(f.exists())
			 {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						AutoSelect.this);
		 
					// set title
					alertDialogBuilder.setTitle("Alert!");
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("If you have Clicked 'Send',  Your order has been successfully placed and it will be delivered within 3 days  in the \"Students corner\".. \nAlso, you will be informed about the delivery details over the phone within 24 hours.")
						.setCancelable(false)
						
						.setNeutralButton("OK",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
								
								/*Intent i = new  Intent(AutoSelect.this,AutoSelect.class);
								
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
								i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								
								startActivity(i);*/
							}
						});
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
						
						
						
				
			 }
			  
			 //info.setEnabled(true); 
		 }
		 else
		 {
			 //info.setEnabled(false);
		 }
		 }
		 catch(Exception e)
		 {}
		Intent i =getIntent();
		 s = i.getStringExtra("College");
		//Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
		
		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dept);
		s1.setAdapter(adapter);
		
		s2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sem);
		s2.setAdapter(adapter1);
		
		b1=(Button) findViewById(R.id.selproceed);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				
				
				boolean a = isNetConnected();
				
				if(a==true)
				{
				Bundle b = new Bundle();
				if(s1.getSelectedItemPosition()==6)
				{
					b.putString("dept","BIOTEC");
				}
				else
				{
				b.putString("dept", dept[s1.getSelectedItemPosition()]);
				}
				b.putString("sem", sem[s2.getSelectedItemPosition()]);
				b.putString("coll",s);
				Intent i = new Intent(AutoSelect.this,Listbooks.class);
				i.putExtras(b);
				startActivity(i);
				
				}
				else
					Toast.makeText(getApplicationContext(),"Please check your network connection"  , Toast.LENGTH_SHORT).show();
			
			}

			private boolean isNetConnected() {
				// TODO Auto-generated method stub
				
					  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					  NetworkInfo ni = cm.getActiveNetworkInfo();
					  if (ni == null) {
					   // There are no active networks.
					   return false;
					  } else
					   return true;
					 
			}
		});
		
		
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				AutoSelect.this);
 
			// set title
			alertDialogBuilder.setTitle("Exit");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Are you sure to exit?")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						
						AutoSelect.this.finish();
						
						
						
						
						
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
		
	}
	
	
}