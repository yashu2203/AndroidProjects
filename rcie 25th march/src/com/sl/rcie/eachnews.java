package com.sl.rcie;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class eachnews extends Activity{
	TextView paragraph,title;
	ImageView image;
    SharedPreferences spf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eachnews);
        ActionBar ab = getActionBar();
        ab.hide();
        paragraph =(TextView)findViewById(R.id.paragraph);
        title =(TextView)findViewById(R.id.titehead);
        image = (ImageView)findViewById(R.id.image);
        
        ImageButton b = (ImageButton) findViewById(R.id.imageButton1);
        b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"Article Added to your Space",Toast.LENGTH_SHORT).show();
				SharedPreferences sharedPreferences = getSharedPreferences("MyPrefsFile", 0);
		        sharedPreferences.edit()
		        .putString("set","yes").commit();
			}
        	
        });
    }

}
