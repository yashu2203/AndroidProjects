package com.sl.rcie;

import java.util.ArrayList;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.AccountPicker;

@SuppressLint("InflateParams") public class MainActivity extends Activity 
{
SlidingPaneLayout spl;
String[] menu;
FrameLayout fl;
DrawerLayout dLayout;
ListView dList;
android.app.ActionBar actionbar;
ViewPager viewpager;

final String PREFS_NAME = "MyPrefsFile";

CustomList adapter;
String acname;

String desc="The purpose of the cell is to develop individuals across socio economic backgrounds, who have the courage to dream, the drive to make a difference, the ability in themselves and the perseverance to convert their thoughts into action. The cell plans to prepare a pool of next gene;ration entrepreneurs to the economic and social development of our mother nation";
String rcie="Welcome to RCIE";

String enterpunership="				Entrepreneurship"+"\n"+

"The socio-economic development of any given society is greatly enhanced by the positive development of entrepreneurs in that society. It is this dynamic nature of man that results in the dynamic nature of his society. That is why the search for solutions will never be finite. The basic difference between the natural solutions provider and the entrepreneur is that while the former specializes in just developing solutions, the entrepreneur not only develops solutions but knows how to make people pay for the solutions he developed.The beauty of this is, as the business prospered the impact the business created increased. His solution became a visible means of livelihood for himself and his employees. Young people are the catalyst for change in any county. To effectively appreciate the essence of entrepreneurship in the development of a society, the involvement of youths in developing private enterprises is an absolute necessity";




@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);


SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

if (settings.getBoolean("my_first_time", true)) {
    //the app is being launched for first time, do something        
	Intent intent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"},
	        false, null, null, null, null);
	
	
	 
	 
	startActivityForResult(intent,777);

	
             // first time task

    // record the fact that the app has been started at least once
    settings.edit().putBoolean("my_first_time", false).commit(); 
}

else 
{
	
	 acname=settings.getString("Acname", "Guest");
	
	setview();
	
	Fragment hm =new home3(1);
    FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.beginTransaction().addToBackStack(null)
             .replace(R.id.putfraghere, hm)
              .commit(); 
}
	




  }


void setview()
{


menu = new String[] { "R-CIE","ENTREPRENEURSHIP","B-PLANS","SCHEMES","INSPIRATION","NEWS"};

spl=(SlidingPaneLayout) findViewById(R.id.drawer_layout);
dList = (ListView) findViewById(R.id.left_drawer);

LayoutInflater inflater=MainActivity.this.getLayoutInflater();
View view2=inflater.inflate(R.layout.headerview, null,true);
TextView tv = (TextView) view2.findViewById(R.id.user);


View footer= inflater.inflate(R.layout.footerview, null,true);

Button myspace=(Button) footer.findViewById(R.id.myspace);
myspace.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	//Toast.makeText(MainActivity.this,"You have clicked my space", 2000).show();
		Intent i = new Intent(MainActivity.this,myspace.class);
		startActivity(i);
	}
});
tv.setText(acname);

ArrayList<draw> menu = new ArrayList<draw>();
menu.add(new draw("R-CIE",R.drawable.home));
menu.add(new draw("ENTREPRENEURSHIP",R.drawable.entrep));
menu.add(new draw("B-PLANS",R.drawable.bplan));
menu.add(new draw("SCHEMES",R.drawable.schemes));
menu.add(new draw("INSPIRATION",R.drawable.inspiration));
menu.add(new draw("NEWS",R.drawable.news));
adapter = new CustomList(MainActivity.this, menu);

dList.addHeaderView(view2);
dList.addFooterView(footer);
dList.setDivider(null);
dList.setAdapter(adapter);
dList.setSelection(1);
fl = (FrameLayout) findViewById(R.id.putfraghere);
dList.setOnItemClickListener(new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	    
		//TextView tv = (TextView) view.findViewById(R.id.txt);
		//tv.setTextColor(Color.RED);
		
	//	Toast.makeText(MainActivity.this, position+"", 2000).show();
		if(position==3)
        { spl.closePane();
           
       	 Fragment bp =new bplan();
            FragmentManager fragmentManager1 = getFragmentManager();
            fragmentManager1.beginTransaction().addToBackStack(null)
                     .replace(R.id.putfraghere, bp)
                      .commit(); 
            
        }
		else 
		if(position==6)
		{ 
			spl.closePane();
			if(isNetworkOnline()==false)
			{
				AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
				adb.setTitle("Oops!");
				adb.setMessage("NewsFeed requires Internet connection to display feeds. Please check yur Internet conection and try again").setNeutralButton("Okay", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						dialog.cancel();
					}
				  });
				AlertDialog ad = adb.create();
				ad.show();
			}
			else
			{
			getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.putfraghere, new CardLayoutFragment()).commit();
			}
		}
		else
		if(position==2)
		{  
			spl.closePane();
			Fragment hm =new entrep();
		      FragmentManager fragmentManager = getFragmentManager();
		      fragmentManager.beginTransaction().addToBackStack(null)
		               .replace(R.id.putfraghere, hm)
		                .commit();
		}
		else
			if(position==0)
			{
				
			}
			else
				if(position==4)
				  {   dList.setSelected(true);
					spl.closePane();
					Fragment hm =new schemes();
							
				      FragmentManager fragmentManager = getFragmentManager();
				      fragmentManager.beginTransaction().addToBackStack(null)
				               .replace(R.id.putfraghere, hm)
				                .commit(); 	
					
				}
				else
					if(position==5)
					{
						spl.closePane();
						Fragment hm =new Inspiration();
								
					      FragmentManager fragmentManager = getFragmentManager();
					      fragmentManager.beginTransaction().addToBackStack(null)
					               .replace(R.id.putfraghere, hm)
					                .commit(); 	
					}
					else
		{  dList.setSelected(true);
			spl.closePane();
			Fragment hm =new home3(position);
					
		      FragmentManager fragmentManager = getFragmentManager();
		      fragmentManager.beginTransaction().addToBackStack(null)
		               .replace(R.id.putfraghere, hm)
		                .commit(); 
		}
		
		
	}
});
spl.setShadowResourceLeft(R.drawable.shadow);
spl.setPanelSlideListener(new PanelSlideListener(){

	@Override
	public void onPanelClosed(View arg0) {
		// TODO Auto-generated method stub
		getActionBar().show();
	}

	@Override
	public void onPanelOpened(View arg0) {
		// TODO Auto-generated method stub
		getActionBar().hide();
	}

	@Override
	public void onPanelSlide(View arg0, float arg1) {
		// TODO Auto-generated method stub
		getActionBar().hide();
	}
	
});
dList.setSelector(android.R.color.darker_gray);

}
protected void onActivityResult(final int requestCode, final int resultCode,
        final Intent data) {
    if (requestCode == 777 && resultCode == RESULT_OK) {
        acname = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
        
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, 0);
        sharedPreferences.edit()
        .putString("Acname",acname).commit();
      
      setview(); 
      Fragment hm =new home3(1);
      FragmentManager fragmentManager = getFragmentManager();
      fragmentManager.beginTransaction().addToBackStack(null)
               .replace(R.id.putfraghere, hm)
                .commit(); 
      
      
      }
    
    else
    {acname="Guest";
    	setview(); 
        Fragment hm =new home3(1);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null)
                 .replace(R.id.putfraghere, hm)
                  .commit(); 
        
    }
   
}
public boolean isNetworkOnline() {
    boolean status=false;
    try{
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getNetworkInfo(0);
        if (netInfo != null && netInfo.getState()==NetworkInfo.State.CONNECTED) {
            status= true;
        }else {
            netInfo = cm.getNetworkInfo(1);
            if(netInfo!=null && netInfo.getState()==NetworkInfo.State.CONNECTED)
                status= true;
        }
    }catch(Exception e){
        e.printStackTrace();  
        return false;
    }
    return status;

    }  

@Override
public void onBackPressed()
{  if (getFragmentManager().getBackStackEntryCount() == 1) {
	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			MainActivity.this);

		// set title
		alertDialogBuilder.setTitle("Confirm");

		// set dialog message
		alertDialogBuilder
			.setMessage("Click yes to exit!")
			.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					MainActivity.this.finish();
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
     else
     {  
    	 getFragmentManager().popBackStack();
      }
   }

}