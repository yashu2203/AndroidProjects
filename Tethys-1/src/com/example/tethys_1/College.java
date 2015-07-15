package com.example.tethys_1;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.sweetlime.tethys.R;

public class College extends Activity {

	Spinner s1;
	Button c;
	String [] coll = {"Select College","REC"};
	Context  context;
	EditText e1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.college);
		s1 =  (Spinner) findViewById(R.id.spinner1);
		

		
		context = getApplication().getApplicationContext();
		
		 e1 = (EditText) findViewById(R.id.RollEdit);
     
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,coll);

		s1.setAdapter(adapter);
		
		
		c = (Button) findViewById(R.id.bt1);
		
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			if(s1.getSelectedItemPosition()==0)
			{
				Toast.makeText(getApplicationContext(), "Select a College",Toast.LENGTH_SHORT).show();
			}
			else{
				
				String x=e1.getText().toString();
				
			
				
				Date d  = new Date();
				
				int curyear  = d.getYear() + 1900;
				
				String cur = curyear+"";
				
				int curint=0;
				
				if(x.length()<4)
					Toast.makeText(getApplicationContext(), "Invalid Roll no", Toast.LENGTH_SHORT).show();
				else	
				{ curint = Integer.parseInt(x.substring(0,4));
				
				
				//Toast.makeText(getApplicationContext(), ""+curyear, Toast.LENGTH_SHORT).show();
				
				
				if(x.length()<9 || !(x.startsWith("20")) || (curint>curyear) || ((curyear-curint)>4) )
				{
					Toast.makeText(getApplicationContext(), "Invalid Roll no", Toast.LENGTH_SHORT).show();
				}
				else{
				Intent i = new Intent(context,AutoSelect.class);
				Bundle b = new Bundle();
				b.putString("College",coll[s1.getSelectedItemPosition()]);
				i.putExtras(b);
				//new cartdb(College.this);
				startActivity(i);
				College.this.finish();
				}
			}}
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