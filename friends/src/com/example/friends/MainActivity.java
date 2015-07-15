package com.example.friends;




import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;


class episode {
	   // String epnum;
		String epname;
		String airdate;
		int thumbid;
		
		public episode(String epname, String airdate, int thumbid) {
			super();
			//this.epnum = epnum;
			this.epname = epname;
			this.airdate = airdate;
			this.thumbid = thumbid;
		}
		//String getepnum()
		//{ return epnum;
	    //}
		String getepname()
		{ return epname;
		}
		String getairdate()
		{ return airdate;
		}
		int getthumbid()
		{ return thumbid;
		}

	}


 
//MAIN ACTIVITY
@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {
      
	  String[] draweritems;
	     ListView drawerlv;
	    String s1;
	    DrawerLayout drawerlt ;
	   ActionBarDrawerToggle abdt;
	    
		
	   
	class DrawerItemClickListener implements ListView.OnItemClickListener {
	        @Override
	  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	       
	        	  drawerlt.closeDrawer(drawerlv);
	        	drawerlt= (DrawerLayout)findViewById(R.id.drawer_layout);   
	     FrameLayout fm= (FrameLayout) findViewById(R.id.frag);
	     fm.setBackgroundResource(R.drawable.bblack);
	   
	    ListFragment s=new season1();
	    ((season1) s).pos(position);
	    
		 FragmentManager fragmentManager = getSupportFragmentManager();
		   fragmentManager.beginTransaction()
		                 .replace(R.id.frag, s)
		                  .commit(); 
		    
		                  
	      
	    }//end of onitemclick
	}//end of class
	
	void viaicon()
	{   
		 drawerlt = (DrawerLayout) findViewById(R.id.drawer_layout);
	        abdt = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                drawerlt,         /* DrawerLayout object */
	                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
	                R.string.drawername,  /* "open drawer" description */
	                R.string.drawername  /* "close drawer" description */
	                ) {

	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	                super.onDrawerClosed(view);
	                setTitle(s1); 
	               
	            }

	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                super.onDrawerOpened(drawerView);
	                
	                setTitle(R.string.drawername);
	            }
	            
	        };

	        // Set the drawer toggle as the DrawerListener
	        drawerlt.setDrawerListener(abdt);
             
	       
	}
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.test);
	          
	        draweritems = getResources().getStringArray(R.array.items);
		       drawerlv = (ListView) findViewById(R.id.lv1);
		       drawerlv.setAdapter(new ArrayAdapter<String>(this,
		       R.layout.drawer, draweritems));
		       viaicon();
			      DrawerItemClickListener my = new DrawerItemClickListener();
			      drawerlv.setOnItemClickListener(my);
	
	    }
	
		public void setActionBarTitle(String title) {
			
			s1=title;
			setTitle(title);
		}
			
		
	    
		
	  
	   
    }
