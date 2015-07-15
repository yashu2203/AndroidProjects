package com.example.tethys_1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sweetlime.tethys.R;

public class Checkout extends Activity {

	EditText e1,e2,e3,e4;

	Button b;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkitout);
		
	e1 = (EditText) findViewById(R.id.namet);
	e2 = (EditText) findViewById(R.id.deptt);
	e3 = (EditText) findViewById(R.id.ephone);
	e4 = (EditText) findViewById(R.id.etm);
		
	b= (Button) findViewById(R.id.finbutton);
	b.setOnClickListener(new OnClickListener() {
		String check = getIntent().getStringExtra("check");
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			

			String x=e4.getText().toString();
			
			Date d  = new Date();
			
			int curyear  = d.getYear() + 1900;
			
			String cur = curyear+"";
			
			int curint=0;
			
			if(x.length()<4)
				Toast.makeText(getApplicationContext(), "Invalid Roll no", Toast.LENGTH_SHORT).show();
			
			else
			{
				curint = Integer.parseInt(x.substring(0,4));
				
				
			if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("") ||e4.getText().toString().equals("") || e3.getText().toString().length()<10||x.length()<9 || !(x.startsWith("20")) || (curint>curyear) || ((curyear-curint)>4))
			{
			Toast.makeText(getApplicationContext(), "Enter valid information", Toast.LENGTH_SHORT).show();
			}
			else{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					Checkout.this);
	 

alertDialogBuilder.setTitle("Confirm.");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("Confirm Checkout ?")
					.setCancelable(false)
					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, close
							// current activity
						
							
								String s="";
								s=s+"Customer Name:"+e1.getText().toString()+"\n";
								s=s+"Customer Department:"+e2.getText().toString()+"\n";
								s=s+"Customer Phone:"+e3.getText().toString()+"\n";
								s=s+"Customer Roll:"+e4.getText().toString()+"\n\n\n";
							String to="storetethys@yahoo.com"; 
							Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:storetethys@yahoo.com"));
							 email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
							 email.putExtra(Intent.EXTRA_SUBJECT, "Order for Books");
							 email.putExtra(Intent.EXTRA_TEXT,s+check);
								Intent i = new  Intent(Checkout.this,NavigationActivity.class);
								//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								//i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(i);
								
								
								File f = new File("data/data/"+getPackageName()+"/databases/file");
								try {
									f.createNewFile();
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								
							 startActivity(Intent.createChooser(email, "Choose an Email client :"));
							
							 Checkout.this.finish();
							 
							 
					
						
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
		}
	});
		
		
	}

}
