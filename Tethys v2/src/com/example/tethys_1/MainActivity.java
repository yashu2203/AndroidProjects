package com.example.tethys_1;



import java.io.File;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.view.Window;
import com.sweetlime.tethys.R;


@SuppressLint("NewApi") public class MainActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_main);
      
        final String DB_PATH = "data/data/"+getPackageName()+"/databases/cart3";
        try{
        	File file = new File(DB_PATH);
            file.delete();
        }
        catch(Exception e) {}
        
        Runnable r =new Runnable(){
			public void run()
			{

				Intent i = new Intent(MainActivity.this,College.class);
				startActivity(i);
				MainActivity.this.finish();
			}
		};
		    Handler h = new Handler();
		    h.postDelayed(r,3000);
          new cartdb(MainActivity.this);
    }

    
    
   
  

   
}
