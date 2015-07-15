package com.example.tethys_1;



import java.util.Date;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sweetlime.tethys.R;

public class College extends Activity{
    Integer btselected = -1;
	Button b1,b2,b3,b4;
	String x;
	String[] clg = {"REC","RIT","RSA"};
	Integer[] color = {R.color.blue,R.color.red,R.color.purple};
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollmain);
		
		b1 = ((Button) findViewById(R.id.button1));
		b2 = ((Button) findViewById(R.id.button2));
		b3 = ((Button) findViewById(R.id.button3));
		b4 = ((Button) findViewById(R.id.button4));
		final ActionBar ab = getActionBar();
	    b1.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.recborder);
				b2.setBackgroundResource(R.drawable.ritorig);
				b3.setBackgroundResource(R.drawable.rsaorig);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 0;
				Drawable d = getResources().getDrawable(R.color.blue);
				ab.setBackgroundDrawable(d);
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.recorig);
				b2.setBackgroundResource(R.drawable.ritborder);
				b3.setBackgroundResource(R.drawable.rsaorig);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 1;
				Drawable d = getResources().getDrawable(R.color.red);
				ab.setBackgroundDrawable(d);
			}
		});
b3.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.recorig);
				b2.setBackgroundResource(R.drawable.ritorig);
				b3.setBackgroundResource(R.drawable.rsaborder);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 2;
				Drawable d = getResources().getDrawable(R.color.purple);
				ab.setBackgroundDrawable(d);
			}
		});
b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.recorig);
				b2.setBackgroundResource(R.drawable.ritorig);
				b3.setBackgroundResource(R.drawable.rsaorig);
				b4.setBackgroundResource(R.drawable.moreborder);
				btselected = 3;
				Drawable d = getResources().getDrawable(R.color.gray);
				ab.setBackgroundDrawable(d);
				alert();
			}
		});
        final EditText e1  = (EditText) findViewById(R.id.rollno);
        e1.clearFocus();
		Button b = (Button) findViewById(R.id.next);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(btselected==3 || btselected==-1)
				{ 
					Toast.makeText(getApplicationContext(), "Choose a College!", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Date d  = new Date();
					int curyear  = d.getYear() + 1900;
					String cur = curyear+"";
					int curint=0;
					x = e1.getText().toString();		
					if(x.length() < 4 )
						Toast.makeText(getApplicationContext(), "Invalid-Roll-no", Toast.LENGTH_SHORT).show();
					else	
					{  
						curint = Integer.parseInt(x.substring(0,4));
						
					if(x.length()!=9 || !(x.startsWith("20")) || (curint>curyear) || ((curyear-curint)>4) )
					{
						Toast.makeText(getApplicationContext(), "Invalid Roll no", Toast.LENGTH_SHORT).show();
					}
					else{
						Intent i = new Intent(College.this,NavigationActivity.class);
						Bundle b2 = new Bundle();
						b2.putString("clg",clg[btselected]);
						b2.putInt("color",color[btselected]);
						i.putExtras(b2);
						startActivity(i);
						College.this.finish();
					}
				   } //end of ET validation
				}
			}
			
		});
		
		
					
}

		
		private void alert() {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					College.this);
	 
				// set title
				alertDialogBuilder.setTitle("More Colleges");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("Currently service unavailable in other colleges. Coming soon!")
					.setCancelable(false)
					
					.setNeutralButton("OK",new DialogInterface.OnClickListener() {
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
					b4.setBackgroundResource(R.drawable.moreborder);
			
		}
  

}