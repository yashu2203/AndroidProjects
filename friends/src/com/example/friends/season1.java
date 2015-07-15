package com.example.friends;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
class season1 extends ListFragment {
	String url="";
	List<episode> eps ;
	ArrayAdapter<episode> adapter;
	int posit;
	@SuppressLint("ValidFragment")
	season1 getInstance()
    {
    	return new season1();
    }
	void pos(int a)
	{ posit=a;
	}
	public void onCreate(Bundle b)
	{ super.onCreate(b);
	  eps =new ArrayList<episode>();
	  adapter=new myadapter(getActivity(),R.layout.listvueachitem);
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
		 String s = null;
      	View v1 = inflater.inflate(R.layout.s1listvu, container, false);
    	 //populatepisodelist();
    	 switch(posit)
    	 { case 0: s="Season 1";
    		       populatepisodelist();
    		       break;
    	 case 1:   s="Season 2";
    		       ps2();
    		       break;
    	 case 2:s="Season 3";
		       ps3();
		       break;
    	 case 3:s="Season 4";
		       ps4();
		       break;
    	 case 4:s="Season 5";
		       ps5();
		       break;
    	 case 5:s="Season 6";
		       ps6();
		       break;
    	 case 6:s="Season 7";
		       ps7();
		       break;
    	 case 7:s="Season 8";
		       ps8();
		       break;
    	 case 8:s="Season 9";
		       ps9();
		       break;
    	 case 9:s="Season 10";
    		    ps10();
    		    break;
    	 
    		       
    	 }
    	 
    	((MainActivity) getActivity()).setActionBarTitle(s);
 		ListView lv=(ListView) v1.findViewById(android.R.id.list);
 		lv.setAdapter(adapter);
 	

       return v1;
    }
	
	
	 public void onListItemClick(ListView l, View v, int position, long id) {
	        
	        super.onListItemClick(l, v, position, id);
	       Intent i = new Intent(Intent.ACTION_VIEW);
	  switch(posit)
	    	 { case 0:
	    		       s1url(position);
	    		       break;
	    	 case 1:
	    		 s2url(position);
	    		       break;
	    	 case 2:
	    		 s3url(position);
			       break;
	    	 case 3:
	    		 s4url(position);
			       break;
	    	 case 4:
	    		 s5url(position);
			       break;
	    	 case 5:
	    		 s6url(position);
			       break;
	    	 case 6:
	    		 s7url(position);
			       break;
	    	 case 7:
	    		 s8url(position);
			       break;
	    	 case 8:
	    		 s9url(position);
			       break;
	    	 case 9:
	    		 s10url(position);
	    		    break;
	    	  }
	        
			//Toast.makeText(getActivity(), url, Toast.LENGTH_LONG).show();  
	        i.setDataAndType(Uri.parse(url), "video/*");
			season1.this.startActivity(i);
	    }	
    private void populatepisodelist() {
    
    	
	/*1*/	eps.add(new episode("The One Where It All Began","22/Sep/94",R.drawable.s1e1));
	/*2*/	eps.add(new episode("The One With the Sonogram at the End ","29/Sep/94",R.drawable.s1e2));
	/*3*/	eps.add(new episode("The One With the Thumb","06/Oct/94",R.drawable.s1e3));
	/*4*/	eps.add(new episode("The One With George Stephanopoulis","13/Oct/94",R.drawable.s1e4));
	/*5*/	eps.add(new episode("The One With the East German Laundry Detergent ","20/Oct/94",R.drawable.s1e5));
	/*6*/	eps.add(new episode("The One With the Butt ","27/Oct/94",R.drawable.s1e6));
	/*7*/	eps.add(new episode("The One With the Blackout","03/Nov/94",R.drawable.s1e7));
	/*8*/	eps.add(new episode("The One Where Nana Dies Twice","10/Nov/94",R.drawable.s1e8));
	/*9*/	eps.add(new episode("The One Where Underdog Gets Away","17/Nov/94",R.drawable.s1e9));
    /*10*/	eps.add(new episode("The One With the Monkey","15/Dec/94",R.drawable.s1e10));
    /*11*/	eps.add(new episode("The One With Mrs. Bing ","05/Jan/95",R.drawable.s1e11));
    /*12*/	eps.add(new episode("The One With the Dozen Lasagnas","12/Jan/95",R.drawable.s1e12));
    /*13*/	eps.add(new episode("The One With the Boobies","19/Jan/95",R.drawable.s1e13));
    /*14*/	eps.add(new episode("The One With the Candy Hearts","09/Feb/95",R.drawable.s1e14));
    /*15*/	eps.add(new episode("The One With the Stoned Guy","16/Feb/95",R.drawable.s1e15));
    /*16*/	eps.add(new episode("The One With Two Parts","23/Feb/95",R.drawable.s1e1617));
    /*17*/	//eps.add(new episode("The One With Two Parts (2)","23/Feb/95",R.drawable.s1e1));
    /*18*/	eps.add(new episode("The One With All the Poker","02/Mar/95",R.drawable.s1e18));
    /*19*/	eps.add(new episode("The One Where the Monkey Gets Away","09/Mar/95",R.drawable.s1e19));
    /*20*/	eps.add(new episode("The One With the Evil Orthodontist","06/Apr/95",R.drawable.s1e20));
    /*21*/	eps.add(new episode("The One With the Fake Monica","27/Apr/95",R.drawable.s1e21));
    /*22*/	eps.add(new episode("The One With the Ick Factor","04/May/95",R.drawable.s1e22));
    /*23*/	eps.add(new episode("The One With the Birth","11/May/95",R.drawable.s1e23));
    /*24*/	eps.add(new episode("The One Where Rachel Finds Out ","18/May/95",R.drawable.s1e24));
   
    }
    void ps2()
    { eps.clear();
    /*1*/	eps.add(new episode(" The One With Ross's New Girlfriend","21/Sep/95",R.drawable.s2e1));
	/*2*/	eps.add(new episode(" The One With the Breast Milk","28/Sep/95",R.drawable.s2e2));
	/*3*/	eps.add(new episode(" The One Where Heckles Dies","05/Oct/95",R.drawable.s2e3));
	/*4*/	eps.add(new episode("The One With Phoebe's Husband","12/Oct/95",R.drawable.s2e4));
	/*5*/	eps.add(new episode("The One With Five Steaks and an Eggplant","19/Oct/95",R.drawable.s2e5));
	/*6*/	eps.add(new episode("The One With the Baby on the Bus ","02/Nov/95",R.drawable.s2e6));
	/*7*/	eps.add(new episode("The One Where Ross Finds Out","09/Nov/95",R.drawable.s2e7));
	/*8*/	eps.add(new episode("The One With the List","16/Nov/95",R.drawable.s2e8));
	/*9*/	eps.add(new episode("The One With Phoebe's Dad","14/Dec/95",R.drawable.s2e9));
    /*10*/	eps.add(new episode("The One With Russ","04/Jan/96",R.drawable.s2e10));
    /*11*/	eps.add(new episode("The One With the Lesbian Wedding","18/Jan/96",R.drawable.s2e11));
    /*12*/	eps.add(new episode("The One After the Superbowl","28/Jan/96",R.drawable.s2e1213));
    /*13*/	eps.add(new episode("The One With the Prom Video","01/Feb/96",R.drawable.s2e14));
    /*14*/	eps.add(new episode(" The One Where Ross and Rachel... You Know ","08/Feb/96",R.drawable.s2e15));
    /*15*/	eps.add(new episode("TThe One Where Joey Moves Out","15/Feb/96",R.drawable.s2e16));
    /*16*/	eps.add(new episode("The One Where Eddie Moves In","22/Feb/96",R.drawable.s2e17));
    /*17*/	eps.add(new episode("The One Where Dr. Ramoray Dies","21/Mar/96",R.drawable.s2e18));
    /*18*/	eps.add(new episode("The One Where Eddie Won't Go","28/Mar/96",R.drawable.s2e19));
    /*19*/	eps.add(new episode("The One Where Old Yeller Dies","04/Apr/96",R.drawable.s2e20));
    /*20*/	eps.add(new episode("The One With the Bullies","25/Apr/96",R.drawable.s2e21));
    /*21*/	eps.add(new episode("The One With the Two Parties","02/May/96",R.drawable.s2e22));
    /*22*/	eps.add(new episode("The One With the Chicken Pox","09/May/96",R.drawable.s2e23));
    /*23*/	eps.add(new episode("The One With Barry and Mindy's Wedding","16/May/96",R.drawable.s2e24));
   
    }
    void ps3()
    { eps.clear();
    /*1*/	eps.add(new episode("The One With the Princess Leia Fantasy","16/Sep/96",R.drawable.s3e1));
	/*2*/	eps.add(new episode("The One Where No One's Ready","26/Sep/96",R.drawable.s3e2));
	/*3*/	eps.add(new episode("The One With the Jam","03/Oct/96",R.drawable.s3e3));
	/*4*/	eps.add(new episode("The One With the Metaphorical Tunnel","10/Oct/96",R.drawable.s3e4));
	/*5*/	eps.add(new episode("The One With Frank Jr.","17/Oct/96",R.drawable.s3e5));
	/*6*/	eps.add(new episode("The One With the Flashback","31/Oct/96",R.drawable.s3e6));
	/*7*/	eps.add(new episode("The One With the Race Car Bed","07/Nov/96",R.drawable.s3e7));
	/*8*/	eps.add(new episode("The One With the Giant Poking Device","14/Nov/96",R.drawable.s3e8));
	/*9*/	eps.add(new episode("The One With the Football","21/Nov/96",R.drawable.s3e9));
    /*10*/	eps.add(new episode("The One Where Rachel Quits","12/Dec/96",R.drawable.s3e10));
    /*11*/	eps.add(new episode("The One Where Chandler Can't Remember Which Sister","09/Jan/97",R.drawable.s3e11));
    /*12*/	eps.add(new episode("The One With All the Jealousy","16/Jan/97",R.drawable.s3e12));
    /*13*/	eps.add(new episode("The One Where Monica and Richard are Just Friends","30/Jan/97",R.drawable.s3e13));
    /*14*/	eps.add(new episode("The One With Phoebe's Ex-Partner","06/Feb/97",R.drawable.s3e14));
    /*15*/	eps.add(new episode("The One Where Ross and Rachel Take a Break","13/Feb/97",R.drawable.s3e15));
    /*16*/	eps.add(new episode("The One the Morning After","20/Feb/97",R.drawable.s3e16));
    /*17*/	eps.add(new episode(" The One Without the Ski Trip","06/Mar/97",R.drawable.s3e17));
    /*18*/	eps.add(new episode("The One With the Hypnosis Tape","13/Mar/97",R.drawable.s3e18));
    /*19*/	eps.add(new episode("The One With the Tiny T-Shirt","27/Mar/97",R.drawable.s3e19));
    /*20*/	eps.add(new episode("The One With the Dollhouse","10/Apr/97",R.drawable.s3e20));
    /*21*/	eps.add(new episode("The One With a Chick and a Duck","17/Apr/97",R.drawable.s3e21));
    /*22*/	eps.add(new episode("The One With the Screamer","24/Apr/97",R.drawable.s3e22));
    /*23*/	eps.add(new episode("The One With Ross's Thing","01/May/97",R.drawable.s3e23));
    /*24*/	eps.add(new episode("The One With the Ultimate Fighting Champion","08/May/97",R.drawable.s3e24));
    eps.add(new episode("The One at the Beach","15/May/97",R.drawable.s3e25));
       
    }
    void ps4()
    { eps.clear();
    /*1*/	eps.add(new episode("The One With the Jellyfish","25/Sep/97",R.drawable.s4e1));
	/*2*/	eps.add(new episode("The One With the Cat","02/Oct/97",R.drawable.s4e2));
	/*3*/	eps.add(new episode("The One With the 'Cuffs","09/Oct/97",R.drawable.s4e3));
	/*4*/	eps.add(new episode("The One With the Ballroom Dancing","16/Oct/97",R.drawable.s4e4));
	/*5*/	eps.add(new episode("The One With Joey's New Girlfriend","30/Oct/97",R.drawable.s4e5));
	/*6*/	eps.add(new episode("The One With the Dirty Girl","06/Nov/97",R.drawable.s4e6));
	/*7*/	eps.add(new episode("The One Where Chandler Crosses the Line","13/Nov/97",R.drawable.s4e7));
	/*8*/	eps.add(new episode("The One With Chandler in a Box","20/Nov/97",R.drawable.s4e8));
	/*9*/	eps.add(new episode("The One Where They're Going to Party!","11/Dec/97",R.drawable.s4e9));
    /*10*/	eps.add(new episode("The One With the Girl from Poughkeepsie","18/Dec/97",R.drawable.s4e10));
    /*11*/	eps.add(new episode("The One With Phoebe's Uterus","08/Jan/98",R.drawable.s4e11));
    /*12*/	eps.add(new episode("The One With the Embryos","15/Jan/98",R.drawable.s4e12));
    /*13*/	eps.add(new episode("The One With Rachel's Crush","29/Jan/98",R.drawable.s4e13));
    /*14*/	eps.add(new episode("The One With Joey's Dirty Day","05/Feb/98",R.drawable.s4e14));
    /*15*/	eps.add(new episode("The One With All the Rugby","26/Feb/98",R.drawable.s4e15));
    /*16*/	eps.add(new episode("The One With the Fake Party","19/Mar/98",R.drawable.s4e16));
    /*17*/	eps.add(new episode("The One With the Free Porn"," 26/Mar/98",R.drawable.s4e17));
    /*18*/	eps.add(new episode("The One With Rachel's New Dress","02/Apr/98",R.drawable.s4e18));
    /*19*/	eps.add(new episode("The One With All the Haste","09/Apr/98",R.drawable.s4e19));
    /*20*/	eps.add(new episode("The One With All the Wedding Dresses","16/Apr/98",R.drawable.s4e20));
    /*21*/	eps.add(new episode("The One With the Invitation","23/Apr/98",R.drawable.s4e21));
    /*22*/	eps.add(new episode(" The One With the Worst Best Man Ever","30/Apr/98",R.drawable.s4e22));
    /*23*/	eps.add(new episode("The One With Ross's Wedding","07/May/98",R.drawable.s4e2324));
    }
    void ps5()
    { eps.clear();
    eps.add(new episode("The One After Ross Says Rachel","24/Sep/98",R.drawable.s5e1));
	eps.add(new episode("The One With All the Kissing","01/Oct/98",R.drawable.s5e2));
	eps.add(new episode("The One Hundredth","08/Oct/98",R.drawable.s5e3));
	eps.add(new episode("The One Where Phoebe Hates PBS","15/Oct/98",R.drawable.s5e4));
	eps.add(new episode("The One With the Kips","29/Oct/98",R.drawable.s5e5));
	eps.add(new episode("The One With the Yeti","05/Nov/98",R.drawable.s5e6));
	eps.add(new episode("The One Where Ross Moves In","12/Nov/98",R.drawable.s5e7));
	eps.add(new episode("The One With All the Thanksgivings","19/Nov/98",R.drawable.s5e8));
	eps.add(new episode("The One With Ross's Sandwich","10/Dec/98",R.drawable.s5e9));
	eps.add(new episode("The One With the Inappropriate Sister","17/Dec/98",R.drawable.s5e10));
	eps.add(new episode("The One With All the Resolutions","07/Jan/99",R.drawable.s5e11));
	eps.add(new episode("The One With Chandler's Work Laugh","21/Jan/99",R.drawable.s5e12));
	eps.add(new episode("The One With Joey's Bag","04/Feb/99",R.drawable.s5e13));
	eps.add(new episode("The One Where Everybody Finds Out","11/Feb/99",R.drawable.s5e14));
	eps.add(new episode("The One With the Girl Who Hits Joey","18/Feb/99",R.drawable.s5e15));
	eps.add(new episode("The One With the Cop","23/Feb/99",R.drawable.s5e16));
	eps.add(new episode("The One With Rachel's Inadvertent Kiss","18/Mar/99",R.drawable.s5e17));
	eps.add(new episode("The One Where Rachel Smokes","08/Apr/99",R.drawable.s5e18));
	eps.add(new episode("The One Where Ross Can't Flirt","22/Apr/99",R.drawable.s5e19));
	eps.add(new episode("The One With the Ride-Along","29/Apr/99",R.drawable.s5e20));
	eps.add(new episode("The One With the Ball","06/May/99",R.drawable.s5e21));
	eps.add(new episode("The One With Joey's Big Break","13/May/99",R.drawable.s5e22));
	eps.add(new episode("The One in Vegas","20/May/99",R.drawable.s52324));
    }
    void ps6()
    { eps.clear();
    eps.add(new episode("The One After Vegas","23/Sep/99",R.drawable.s6e1));
	eps.add(new episode("The One Where Ross Hugs Rachel","30/Sep/99",R.drawable.s6e2));
	eps.add(new episode("The One With Ross's Denial","07/Oct/99",R.drawable.s6e3));
	eps.add(new episode("The One Where Joey Loses His Insurance","14/Oct/99",R.drawable.s6e4));
	eps.add(new episode("The One With Joey's Porsche","21/Oct/99",R.drawable.s6e5));
	eps.add(new episode("The One on the Last Night","04/Nov/99",R.drawable.s6e6));
	eps.add(new episode("The One Where Phoebe Runs","11/Nov/99",R.drawable.s6e7));
	eps.add(new episode("The One With Ross's Teeth","18/Nov/99",R.drawable.s6e8));
	eps.add(new episode("The One Where Ross Got High","25/Nov/99",R.drawable.s6e9));
	eps.add(new episode("The One With the Routine","16/Dec/99",R.drawable.s6e10));
	eps.add(new episode("The One With the Apothecary Table","06/Jan/00",R.drawable.s6e11));
	eps.add(new episode("The One With the Joke ","13/Jan/00",R.drawable.s6e12));
	eps.add(new episode("The One With Rachel's Sister","03/Feb/00",R.drawable.s6e13));
	eps.add(new episode("The One Where Chandler Can't Cry","10/Feb/00",R.drawable.s6e14));
	eps.add(new episode("The One That Could Have Been","17/Feb/00",R.drawable.s6e1516));
	eps.add(new episode("The One With Unagi","24/Feb/00",R.drawable.s6e17));
	eps.add(new episode("The One Where Ross Dates a Student","09/Mar/00",R.drawable.s6e18));
	eps.add(new episode("The One With Joey's Fridge","23/Mar/00",R.drawable.s6e19));
	eps.add(new episode("The One With Mac and C.H.E.E.S.E.","13/Apr/00",R.drawable.s6e20));
	eps.add(new episode("The One Where Ross Meets Elizabeth's Dad","27/Apr/00",R.drawable.s6e21));
	eps.add(new episode("The One Where Paul's the Man","04/May/00",R.drawable.s6e22));
	eps.add(new episode("The One With the Ring","11/May/00",R.drawable.s6e23));
	eps.add(new episode("The One With the Proposal","18/May/00",R.drawable.s6e2425));
    }
    void ps7()
    { eps.clear();
    eps.add(new episode("The One With Monica's Thunder","12/Oct/00",R.drawable.s7e1));
	eps.add(new episode("The One With Rachel's Book","12/Oct/00",R.drawable.s7e2));
	eps.add(new episode("The One With Phoebe's Cookies","19/Oct/00",R.drawable.s7e3));
	eps.add(new episode("The One With Rachel's Assistant","26/Oct/00",R.drawable.s7e4));
	eps.add(new episode("The One With the Engagement Picture","02/Nov/00",R.drawable.s7e5));
	eps.add(new episode("The One With the Nap Partners","09/Nov/00",R.drawable.s7e6));
	eps.add(new episode("The One With Ross's Library Book","16/Nov/00",R.drawable.s7e7));
	eps.add(new episode("The One Where Chandler Doesn't Like Dogs","23/Nov/00",R.drawable.s7e8));
	eps.add(new episode("The One With All the Candy","07/Dec/00",R.drawable.s7e9));
	eps.add(new episode("The One With the Holiday Armadillo","14/Dec/00",R.drawable.s7e10));
	eps.add(new episode("The One With All the Cheesecakes","04/Jan/01",R.drawable.s7e11));
	eps.add(new episode("The One Where They're Up All Night","11/Jan/01",R.drawable.s7e12));
	eps.add(new episode("The One Where Rosita Dies","01/Feb/01",R.drawable.s7e13));
	eps.add(new episode("The One Where They All Turn Thirty","08/Feb/01",R.drawable.s7e14));
	eps.add(new episode("The One With Joey's New Brain","15/Feb/01",R.drawable.s7e15));
	eps.add(new episode("The One With the Truth About London","22/Feb/01",R.drawable.s7e16));
	eps.add(new episode("The One With the Cheap Wedding Dress","15/Mar/01",R.drawable.s7e17));
	eps.add(new episode("The One With Joey's Award","29/Mar/01",R.drawable.s7e18));
	eps.add(new episode("The One With Ross and Monica's Cousin","19/Apr/01",R.drawable.s7e19));
	eps.add(new episode("The One With Rachel's Big Kiss","26/Apr/01",R.drawable.s7e20));
	eps.add(new episode("The One With the Vows ","03/May/01",R.drawable.s7e21));
	eps.add(new episode("The One With Chandler's Dad","10/May/01",R.drawable.s7e22));
	eps.add(new episode("The One with Monica and Chandler's Wedding","17/May/01",R.drawable.s7e2324));
    }
    
    void ps8()
    { eps.clear();
    eps.add(new episode("The One After I Do ", "27/Sep/01",R.drawable.s8e1));
	eps.add(new episode("The One With the Red Sweater","04/Oct/01",R.drawable.s8e2));
	eps.add(new episode("The One Where Rachel Tells... ","11/Oct/01",R.drawable.s8e3));
	eps.add(new episode("The One With the Videotape","18/Oct/01",R.drawable.s8e4));
	eps.add(new episode("The One With Rachel's Date","25/Oct/01",R.drawable.s8e5));
	eps.add(new episode("The One With the Halloween Party ","01/Nov/01",R.drawable.s8e6));
	eps.add(new episode("The One With the Stain","08/Nov/01",R.drawable.s8e7));
	eps.add(new episode("The One With the Stripper","15/Nov/01",R.drawable.s8e8));
	eps.add(new episode("The One With the Rumor","22/Nov/01",R.drawable.s8e9));
	eps.add(new episode("The One With Monica's Boots","06/Dec/01",R.drawable.s8e10));
	eps.add(new episode("The One With the Creepy Holiday Card","13/Dec/01",R.drawable.s8e11));
	eps.add(new episode("The One Where Joey Dates Rachel","10/Jan/02",R.drawable.s8e12));
	eps.add(new episode("The One Where Chandler Takes a Bath","17/Jan/02",R.drawable.s8e13));
	eps.add(new episode("The One With the Secret Closet","31/Jan/02",R.drawable.s8e14));
	eps.add(new episode("The One With the Birthing Video","07/Feb/02",R.drawable.s8e15));
	eps.add(new episode("The One Where Joey Tells Rachel","28/Feb/02",R.drawable.s8e16));
	eps.add(new episode("The One With the Tea Leaves","07/Mar/02",R.drawable.s8e17));
	eps.add(new episode("The One in Massapequa","28/Mar/02",R.drawable.s8e18));
	eps.add(new episode("The One With Joey's Interview","04/Apr/02",R.drawable.s8e19));
	eps.add(new episode("The One With the Baby Shower ","25/Apr/02",R.drawable.s8e20));
	eps.add(new episode("The One With the Cooking Class ","02/May/02",R.drawable.s8e21));
	eps.add(new episode("The One Where Rachel is Late","09/May/02",R.drawable.s8e22));
	eps.add(new episode("The One Where Rachel Has a Baby","16/May/02",R.drawable.s8e2324));
    }
    void ps9()
    { eps.clear();
    eps.add(new episode("The One Where No One Proposes", "26/Sep/02",R.drawable.s9e1));
	eps.add(new episode("The One Where Emma Cries","03/Oct/02",R.drawable.s9e2));
	eps.add(new episode("The One With the Pediatrician","10/Oct/02",R.drawable.s9e3));
	eps.add(new episode("The One With the Sharks","17/Oct/02",R.drawable.s9e4));
	eps.add(new episode("The One With Phoebe's Birthday Dinner","31/Oct/02",R.drawable.s9e5));
	eps.add(new episode("The One With the Male Nanny ","07/Nov/02",R.drawable.s9e6));
	eps.add(new episode("The One With Ross's Inappropriate Song","14/Nov/02",R.drawable.s9e7));
	eps.add(new episode("The One With Rachel's Other Sister","21/Nov/02",R.drawable.s9e8));
	eps.add(new episode("The One With Rachel's Phone Number ","05/Dec/02",R.drawable.s9e9));
	eps.add(new episode("The One With Christmas In Tulsa","12/Dec/02",R.drawable.s9e10));
	eps.add(new episode(" The One Where Rachel Goes Back To Work "," 09/Jan/03 ",R.drawable.s9e11));
	eps.add(new episode("The One With Phoebe's Rats","16/Jan/03",R.drawable.s9e12));
	eps.add(new episode("The One Where Monica Sings","30/Jan/03",R.drawable.s9e13));
	eps.add(new episode("The One With the Blind Dates","06/Feb/03",R.drawable.s9e14));
	eps.add(new episode("The One With the Mugging","13/Feb/03 ",R.drawable.s9e15));
	eps.add(new episode("The One With the Boob Job","20/Feb/03",R.drawable.s9e16));
	eps.add(new episode("The One With the Memorial Service","13/Mar/03",R.drawable.s9e17));
	eps.add(new episode("The One With the Lottery","03/Apr/03",R.drawable.s9e18));
	eps.add(new episode("The One With Rachel's Dream","17/Apr/03",R.drawable.s9e19));
	eps.add(new episode("The One With the Soap Opera Party ","24/Apr/03",R.drawable.s9e20));
	eps.add(new episode("The One With the Fertility Test","01/May/03",R.drawable.s9e21));
	eps.add(new episode("The One With the Donor","08/May/03",R.drawable.s9e22));
	eps.add(new episode("The One in Barbados","15/May/03",R.drawable.s9e2324));
    }
    void ps10()
    { eps.clear();
    eps.add(new episode("The One After Joey And Rachel Kiss", "25/Sep/03",R.drawable.s10e1));
	eps.add(new episode("The One Where Ross is Fine","02/Oct/03",R.drawable.s10e2));
	eps.add(new episode("The One With Ross's Tan","09/Oct/03",R.drawable.s10e3));
	eps.add(new episode("The One With the Cake","23/Oct/03",R.drawable.s10e4));
	eps.add(new episode("The One Where Rachel's Sister Babysits","30/Oct/03",R.drawable.s10e5));
	eps.add(new episode("The One With Ross's Grant","06/Nov/03",R.drawable.s10e6));
	eps.add(new episode("The One With the Home Study","13/Nov/03",R.drawable.s10e7));
	eps.add(new episode("The One With the Late Thanksgiving","20/Nov/03",R.drawable.s10e8));
	eps.add(new episode("The One With the Birth Mother","08/Jan/04",R.drawable.s10e9));
	eps.add(new episode("The One Where Chandler Gets Caught ","15/Jan/04",R.drawable.s10e10));
	eps.add(new episode("The One Where the Stripper Cries","05/Feb/04",R.drawable.s10e11));
	eps.add(new episode("The One With Phoebe's Wedding","12/Feb/04",R.drawable.s10e12));
	eps.add(new episode("The One Where Joey Speaks French","19/Feb/04",R.drawable.s10e13));
	eps.add(new episode("The One With Princess Consuela","26/Feb/04",R.drawable.s10e14));
	eps.add(new episode("The One Where Estelle Dies","22/Apr/04",R.drawable.s10e15));
	eps.add(new episode("The One With Rachel's Going Away Party ","29/Apr/04",R.drawable.s10e16));
	eps.add(new episode("The Last One","06/May/04",R.drawable.s10e1718));
    }
    void s1url(int a)
    {url="http://www.heavyhost.com/uploads/dgu.mp4";
     switch(a)
	 { case 0:
         url="http://www.heavyhost.com/uploads/dgu.mp4";
          break;
	 case 1:
         url="http://www.heavyhost.com/uploads/dgu.mp4";
          break;
	 case 2:
         url="";
          break;
	 case 3:
         url="";
          break;
	 case 4:
         url="";
          break;
	 case 5:
         url="";
          break;
	 case 6:
         url="";
          break;
	 case 7:
         url="";
          break;
	 case 8:
         url="";
          break;
	 case 9:
         url="";
          break;
	 case 10:
         url="";
          break;
	 case 11:
         url="";
          break;
	 case 12:
         url="";
          break;
	 case 13:
         url="";
          break;
	 case 14:
         url="";
          break;
	 case 15:
         url="";
          break;
	 case 16:
         url="";
          break;
	 case 17:
         url="";
          break;
	 case 18:
         url="";
          break;
	 case 19:
         url="";
          break;
	 case 20:
         url="";
          break;
	 case 21:
         url="";
          break;
	 case 22:
         url="";
          break;
	 case 23:
         url="";
          break;
	 case 24:
         url="";
          break;
	    }
    }
    void s2url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="http://www.heavyhost.com/uploads/dgu.mp4";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s3url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="http://www.heavyhost.com/uploads/dgu.mp4";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s4url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="http://www.heavyhost.com/uploads/dgu.mp4";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s5url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="http://www.heavyhost.com/uploads/dgu.mp4";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s6url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="http://www.heavyhost.com/uploads/dgu.mp4";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s7url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s8url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s9url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    void s10url(int a)
    {
    	 switch(a)
    	 { case 0:
             url="";
              break;
    	 case 1:
             url="";
              break;
    	 case 2:
             url="";
              break;
    	 case 3:
             url="";
              break;
    	 case 4:
             url="";
              break;
    	 case 5:
             url="";
              break;
    	 case 6:
             url="";
              break;
    	 case 7:
             url="";
              break;
    	 case 8:
             url="";
              break;
    	 case 9:
             url="";
              break;
    	 case 10:
             url="";
              break;
    	 case 11:
             url="";
              break;
    	 case 12:
             url="";
              break;
    	 case 13:
             url="";
              break;
    	 case 14:
             url="";
              break;
    	 case 15:
             url="";
              break;
    	 case 16:
             url="";
              break;
    	 case 17:
             url="";
              break;
    	 case 18:
             url="";
              break;
    	 case 19:
             url="";
              break;
    	 case 20:
             url="";
              break;
    	 case 21:
             url="";
              break;
    	 case 22:
             url="";
              break;
    	 case 23:
             url="";
              break;
    	 case 24:
             url="";
              break;
    	    }
    }
    
    
    class myadapter extends ArrayAdapter<episode>
	   {
		   Context mContext;
		   
	 	
		 public myadapter(Context context, int resource) 
		{
			super(context, R.layout.listvueachitem,eps);
			mContext=context;
		}
		@Override
		      public View getView(int position, View convertView, ViewGroup parent) 
		      { View vu=convertView;
			          if(vu==null)
	               { 
			         LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
	                  vu=inflater.inflate(R.layout.listvueachitem, parent, false);
	                }
			//find the episode that needs to be filled with info
			episode currentep= eps.get(position);
			//fill the imageview
			ImageView iv=(ImageView) vu.findViewById(R.id.ep_icon);
			iv.setImageResource(currentep.getthumbid());
			//fill the ep name
			TextView tv1=(TextView) vu.findViewById(R.id.epname);
			tv1.setText(currentep.getepname());
			//fill the airdate
			TextView tv2=(TextView) vu.findViewById(R.id.airdate);
			tv2.setText(currentep.getairdate());
			
			return vu;
		                } 
	     }
}
	
	
	  
	   
