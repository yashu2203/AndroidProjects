package com.example.tethys_1;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.sweetlime.tethys.R;



@SuppressLint("NewApi") public class NavigationActivity extends FragmentActivity {

	private DrawerLayout mDrawerLayout;
	ImageView home;
	ListFragment fragment = null;
	TextView appname;
	List<String> draweritems;
    String dept[] = { "CSE","ECE","EEE","MECH","BIOTECH","BIOMED","AERO","AUTO","IT","CIVIL" };
    String clg;
    Integer color;
    Integer semchosen=0;
    Integer deptchosen=0;
    ListView lv;
    String rollno;
    ActionBarDrawerToggle mDrawerToggle;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
        clg = i.getStringExtra("clg");
        rollno = i.getStringExtra("roll");
        color = i.getIntExtra("color", R.color.blue);
        
    /*    Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(color);*/
		
        setContentView(R.layout.activity_navigation);
        Drawable d = getResources().getDrawable(color);
        ActionBar ab = getActionBar();
        ab.setBackgroundDrawable(d);         
		setUpDrawer();
	}

	/**
	 * 
	 * Get the names and icons references to build the drawer menu...
	 */
	private void setUpDrawer() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
		mDrawerLayout.setDrawerListener(mDrawerListener);
		getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer,R.string.app_name) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle("Tethys");
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("Tethys");
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);		
	    mDrawerToggle.syncState();
		
		lv = (ListView) findViewById(R.id.lvd);
		ArrayAdapter<String> ad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1);
	    ad.add(new String("Choose Dept, Sem"));
	    ad.add(new String("About Tethys"));
	    ad.add(new String("Rate us on Store"));
	    ad.add(new String("About Developers"));
		lv.setAdapter( ad );
		
		View v = getLayoutInflater().inflate(R.layout.listhead,null);
		TextView roll = (TextView) v.findViewById(R.id.roll);
		roll.setText(rollno);
		roll = (TextView) v.findViewById(R.id.College);
		roll.setText(clg);
		lv.addHeaderView(v);
		
        fragment = new Listbooks(null,0,null,getApplicationContext(),color);
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
	    lv.setOnItemClickListener(mDrawerItemClickedListener);
	}

	

	private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
              

			//getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
          switch(position)
          {
          case 1: 
        	      createPickerDialog();            
        	     break;
          case 2:
        	  displayalert("Tethys");
        	  
        	     break;
          case 3:
        	  final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        	  try {
        	      startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        	  } catch (android.content.ActivityNotFoundException anfe) {
        	      startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        	  }
        	      break;
          case 4:
        	  displayalert("Sweetlime Applications");
        	     break;
          }
			mDrawerLayout.closeDrawer(lv);
		}

		private void displayalert(String string) {
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					NavigationActivity.this);
	 
				// set title
				alertDialogBuilder.setTitle(string);
	 
				String message="";
			if(string.equals("Tethys"))
			{
				message="   Version 2.0.1\n   The online book store for engineering students\n   Wide range of books available for all departments and semesters\n   Contact:9566566267\nE-mail:storetethys@yahoo.com";
				
			}
			else
			{
				message="\n   Sivaram S S\n   pingsivaram@gmail.com\n\n   Sumit Kumar N\n   sumitnrec@gmail.com \n\n   Yashwanth Rao P S R\n   yashu2203@gmail.com";
			}
				
				
				
				// set dialog message
				alertDialogBuilder
					.setMessage(message)
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
			
			
			
			
		}
	};

    public void createPickerDialog()
    {
     final Dialog d = new Dialog(NavigationActivity.this);
     d.requestWindowFeature(Window.FEATURE_NO_TITLE);
     d.setContentView(R.layout.choosesemdept);
     final NumberPicker deptnb = (NumberPicker) d.findViewById(R.id.dept);
     final NumberPicker semnb = (NumberPicker) d.findViewById(R.id.sem);
     
     deptnb.setMaxValue(9);
     deptnb.setMinValue(0);
     semnb.setMaxValue(7);
     semnb.setMinValue(0);
     deptnb.setDisplayedValues(dept);
     
     final String sem[]={"1","2","3","4","5","6","7","8"};
     semnb.setDisplayedValues(sem);
     
     Button done = (Button) d.findViewById(R.id.done);
     done.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 semchosen = Integer.parseInt( sem[semnb.getValue()].toString());
			 deptchosen = deptnb.getValue();
			 d.dismiss();
			 fragment = new Listbooks( dept[deptchosen], semchosen, clg, getApplicationContext(), color );
             getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
			 
		}
     });
     d.setCancelable(false);
     d.show();
     
  }
	// Catch the events related to the drawer to arrange views according to this
	// action if necessary...
	private DrawerListener mDrawerListener = new DrawerListener() {

		@Override
		public void onDrawerStateChanged(int status) {

		}

		@Override
		public void onDrawerSlide(View view, float slideArg) {

		}

		@Override
		public void onDrawerOpened(View view) {
		}

		@Override
		public void onDrawerClosed(View view) {
		}
	};

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				NavigationActivity.this);
 
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
						
						NavigationActivity.this.finish();
						
						
						
						
						
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
