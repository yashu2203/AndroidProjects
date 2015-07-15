package com.sl.rcie;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Inspiration extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	LayoutInflater inflator=getActivity().getLayoutInflater();
	ActionBar ab = getActivity().getActionBar();
	
	ab.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
	
	ab.setTitle("Inspiration");
	ab.setIcon(R.drawable.inspiration);
	View v=inflator.inflate(R.layout.inspiration,container,false);
	KenBurnsView image1=(KenBurnsView) v.findViewById(R.id.picture);
	KenBurnsView image2=(KenBurnsView) v.findViewById(R.id.picture2);
	KenBurnsView image3=(KenBurnsView) v.findViewById(R.id.picture3);
	TextView t1=(TextView) v.findViewById(R.id.text1);
	//TextView t2=(TextView) v.findViewById(R.id.text2);
	ArrayList<String> quotes1=new ArrayList<String>();
	ArrayList<String> quotes2=new ArrayList<String>();
	ArrayList<String> quotes3=new ArrayList<String>();
	quotes1.add("Money is the most unimportant thing in the world if you have enough to live.");
	quotes1.add("In those days, you wouldn't dream of renting a room without inspecting it first. I wanted to create a brand that people could trust.");
	quotes2.add("I like to work half a day. I dont care of its the first twelve hours or the second twelve hurs. I just put in my half every day. It keeps me out of trouble.");
	quotes2.add("In the world according to the positivist, the inspiring thing about scrambled eggs is that any way you turn them they're sunny side up. In the world according to the existentialist, the hopeless thing about scrambled eggs is that any way you turn them they're scrambled.");
	quotes3.add("Money is the most unimportant thing in the world if you have enough to live.");
	quotes3.add("In those days, you wouldn't dream of renting a room without inspecting it first. I wanted to create a brand that people could trust.");
	/*
	quotes.add("");
	quotes.add("");
	quotes.add("");
	quotes.add("");
	quotes.add("");
	*/
	ListView ls1=(ListView) v.findViewById(R.id.quotelist1);
	ListView ls2=(ListView) v.findViewById(R.id.quotelist2);
	ListView ls3=(ListView) v.findViewById(R.id.quotelist3);
	
	//TextView tv =
	ls1.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,quotes1));
	ls2.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,quotes2));
	ls3.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,quotes3));
	//ls1.setBackgroundColor(Color.BLACK);
	//ls2.setBackgroundColor(Color.BLACK);
	//ls3.setBackgroundColor(Color.BLACK);
	
	//t1.setText("Inspirational Quotes");

	
	image1.setResourceIds(R.drawable.q1,R.drawable.q2);
	image2.setResourceIds(R.drawable.q3,R.drawable.q4);
	image3.setResourceIds(R.drawable.q5,R.drawable.q6);

	
		return v;
	}
	
	
	
/*	class InspirationAdapter extends ArrayAdapter<KenBurnsView>
	{
		
		Activity context;
		ArrayList<String> items;
		public InspirationAdapter(Activity context, int resource,ArrayList<String> items) {
			super(context,R.layout.eachrowinsp);
			this.context=context;
			this.items=items;
			
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		
		LayoutInflater inflater=context.getLayoutInflater();
		View eachrow=inflater.inflate(R.layout.eachrowinsp, parent,false);
		
			KenBurnsView image=(KenBurnsView) eachrow.findViewById(R.id.picture);
			TextView t1=(TextView) eachrow.findViewById(R.id.text1);
			TextView t2=(TextView) eachrow.findViewById(R.id.text2);
			
			t1.setText(items.get(position));
			
		
				image.setResourceIds(R.drawable.bg1,R.drawable.picture1);
			
		
				t2.setText("This is quote 2");
		
			return eachrow;
		}
		
		
	}*/
}
