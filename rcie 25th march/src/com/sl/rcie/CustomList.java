package com.sl.rcie;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class draw
{
	String t;
	public draw(String t, int id) {
		super();
		this.t = t;
		this.id = id;
	}
	int id;
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
public class CustomList extends ArrayAdapter<draw>{
	
	Activity context;
	ArrayList<draw> items;
	
	
public CustomList(Activity context,ArrayList<draw> items)
{    
	super(context,R.layout.customdrawer,items);
	//super(context,R.layout.customlist,items);
	
	this.context=context;
	this.items=items;
}

@SuppressLint("ViewHolder") @Override
public View getView(int position, View convertView, ViewGroup parent) {
	
	View view;
	LayoutInflater inflater=context.getLayoutInflater();
	view=inflater.inflate(R.layout.customdrawer, parent,false);
	TextView tv=(TextView) view.findViewById(R.id.txt);
	ImageView img=(ImageView) view.findViewById(R.id.img);
	draw d = (draw) items.get(position);
	tv.setText(d.getT());
	img.setImageResource(d.getId());
	/*if(position%2==0)
	img.setImageResource(R.drawable.ic_launcher);
	else 
		img.setImageResource(R.drawable.ic_launcher);
	
	*/
	
	
	
	return view;
}
}
