package com.sl.rcie;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("InflateParams") public class myspace extends Activity{
	ListView lv;
	
	String[] items={""};
	@Override
	public void onCreate(Bundle b)
	{
	  super.onCreate(b);
	  SharedPreferences sharedPreferences = getSharedPreferences("MyPrefsFile", 0);
      String str = sharedPreferences.getString("set", "no");
	  if(str.equals("yes"))
	  {
		  items[0]="Zostal Entrepreneurship";
	  }
	  else
	  {
		  items[0]="No Articles saved";
		  //lv.setActivated(false);
	  }
      
      
      setContentView(R.layout.myspacelist);
	  ActionBar ab = getActionBar();
	  ab.setTitle("Saved Articles");
	  LayoutInflater inflater = LayoutInflater.from(this);
      View view2= inflater.inflate(R.layout.actionbar,null);
      ab.setCustomView(view2);
      ab.setDisplayShowCustomEnabled(true);
      ab.setIcon(R.drawable.news);
      ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.intelblue));
      ab.setBackgroundDrawable(cd);
	  lv = (ListView) findViewById(R.id.mylist);
	  ArrayAdapter<String> adap = new ArrayAdapter<String>(myspace.this,android.R.layout.simple_list_item_1,items);
	  lv.setAdapter(adap);
	  lv.setOnItemClickListener(new OnItemClickListener()
	  {
 
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			if(items[0].equals("No Articles saved"))
			{
				
			}
			else
			{
			Intent i = new Intent(myspace.this,eachsavednews.class);
			startActivity(i);
			}
		}
		  
	  });
	}

}
