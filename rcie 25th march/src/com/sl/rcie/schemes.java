package com.sl.rcie;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class schemes extends Fragment{
	 String items[] = { "State Bank of India", "Bank of Baroda", "Andhra Bank","Small Industries Development Org","Microfinance Program","NSIC"};
	 ListView lv;
	 ArrayList<String> al;
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		        Bundle savedInstanceState)
	    {  View v =getActivity().getLayoutInflater().inflate(R.layout.schemes, container,false);
	        
	        ActionBar b = getActivity().getActionBar();
	        b.setTitle("Schemes");
	        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.intelblue));
	        b.setBackgroundDrawable(cd);
	        b.setIcon(R.drawable.schemes);
	        b.setHomeButtonEnabled(true);
	        TextView tv = (TextView) v.findViewById(R.id.info);
	        tv.setText("An entrepreneur requires a continuous flow of funds not only for setting up of his/ her business, but also for successful operation as well as regular upgradation/ modernisation of the industrial unit. To meet this requirement, the Government (both at the Central and State level) has been undertaking several steps like setting up of banks and financial institutions; formulating various policies and schemes, etc");
	        
	         lv = (ListView) v.findViewById(android.R.id.list);
	         al= new ArrayList<String>();
	         for(String c:items)
	    		 al.add(c);
	        	 ArrayAdapter<String> adap = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,items);
	             lv.setAdapter(adap);
			return v;
	    	
	    }
	 @Override
	public
     void onActivityCreated(Bundle b)
     {   super.onActivityCreated(b);
         lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				 //switch(position) 
				switch(position)
				{ case 0:
					showdialog(getResources().getString(R.string.sbi),"SBI");
					break;
				  case	1:
					  showdialog(getResources().getString(R.string.bob),"BoB");
					  break;
				  case 2:
					  showdialog(getResources().getString(R.string.andhra),"Andhra Bank");
					  break;
				  case 3:
					  showdialog(getResources().getString(R.string.sbi),"SIDO");
					  break;
				  case 4:	
					  showdialog(getResources().getString(R.string.sbi),"Micro Finance");
					  break;
				  case 5:
					  showdialog(getResources().getString(R.string.sbi),"NSIC");
					  break;
				
				}
				
			}
		});
     }
   void showdialog(String s,String t)
   {
	   AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());

			// set title
			alertDialogBuilder.setTitle(t);

			// set dialog message
			alertDialogBuilder
				.setMessage(s)
				.setCancelable(false)
				.setNeutralButton("Got it!",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						dialog.cancel();
					}
				  })
				;

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
		
   }
}
