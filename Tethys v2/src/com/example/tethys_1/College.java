package com.example.tethys_1;



import java.util.Date;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sweetlime.tethys.R;

@SuppressLint("ResourceAsColor") public class College extends Activity{
    Integer btselected = -1;
	Button b1,b2,b3,b4;
	String x;
	String[] clg = {"Rajalakshmi Engineering College","Rajalakshmi Institute of Technology","Maamallan Institute of Technology","Sree Sastha Institute of Technology"};
	Integer[] color = {R.color.blue,R.color.red,R.color.purple,R.color.black};
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	/*	Window window = getWindow();
	    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
	    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	    window.setStatusBarColor(R.color.black);
		*/
	    setContentView(R.layout.college);
		
		b1 = ((Button) findViewById(R.id.button1));
		b2 = ((Button) findViewById(R.id.button2));
		b3 = ((Button) findViewById(R.id.button3));
		b4 = ((Button) findViewById(R.id.button4));
		final ActionBar ab = getActionBar();
	    b1.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.recorig);
				b2.setBackgroundResource(R.drawable.moreorig);
				b3.setBackgroundResource(R.drawable.moreorig);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 0;
				b1.setTextColor(Color.parseColor("#FFFFFF"));
				b2.setTextColor(Color.parseColor("#252525"));
				b3.setTextColor(Color.parseColor("#252525"));
				b4.setTextColor(Color.parseColor("#252525"));
				Drawable d = getResources().getDrawable(R.color.blue);
				ab.setBackgroundDrawable(d);
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
		
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.moreorig);
				b2.setBackgroundResource(R.drawable.recorig);
				b3.setBackgroundResource(R.drawable.moreorig);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 1;
				b2.setTextColor(Color.parseColor("#FFFFFF"));
				b1.setTextColor(Color.parseColor("#252525"));
				b3.setTextColor(Color.parseColor("#252525"));
				b4.setTextColor(Color.parseColor("#252525"));
				Drawable d = getResources().getDrawable(R.color.blue);
				ab.setBackgroundDrawable(d);
			}
		});
b3.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.moreorig);
				b2.setBackgroundResource(R.drawable.moreorig);
				b3.setBackgroundResource(R.drawable.recorig);
				b4.setBackgroundResource(R.drawable.moreorig);
				btselected = 2;
				b3.setTextColor(Color.parseColor("#FFFFFF"));
				b1.setTextColor(Color.parseColor("#252525"));
				b2.setTextColor(Color.parseColor("#252525"));
				b4.setTextColor(Color.parseColor("#252525"));
				Drawable d = getResources().getDrawable(R.color.blue);
				ab.setBackgroundDrawable(d);
			}
		});
b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View b) {
				// TODO Auto-generated method stub
				b1.setBackgroundResource(R.drawable.moreorig);
				b2.setBackgroundResource(R.drawable.moreorig);
				b3.setBackgroundResource(R.drawable.moreorig);
				b4.setBackgroundResource(R.drawable.recorig);
				b4.setTextColor(Color.parseColor("#FFFFFF"));
				b1.setTextColor(Color.parseColor("#252525"));
				b2.setTextColor(Color.parseColor("#252525"));
				b3.setTextColor(Color.parseColor("#252525"));
				btselected = 3;
				Drawable d = getResources().getDrawable(R.color.blue);
				ab.setBackgroundDrawable(d);
			}
		});
		Button b = (Button) findViewById(R.id.next);
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(btselected==-1)
				{ 
					Toast.makeText(getApplicationContext(), "Choose a College!", Toast.LENGTH_SHORT).show();
				}
				else
				{
						Intent i = new Intent(College.this,NavigationActivity.class);
						Bundle b2 = new Bundle();
						b2.putString("clg",clg[btselected]);
						b2.putInt("color",color[0]);
						i.putExtras(b2);
						startActivity(i);
						College.this.finish();
				}
			}
			
		});
		
		
					
}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				College.this);
 
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
						
						College.this.finish();
						
						
						
						
						
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