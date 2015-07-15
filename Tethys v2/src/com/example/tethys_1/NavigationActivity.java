package com.example.tethys_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.sweetlime.tethys.R;


@TargetApi(Build.VERSION_CODES.HONEYCOMB) public class NavigationActivity extends FragmentActivity {

	private DrawerLayout mDrawerLayout;
	ImageView home;
	ListFragment fragment = null;
	TextView appname;
	ExpandableListView expListView;
	HashMap<String, List<String>> listDataChild;
	ExpandableListAdapter listAdapter;
	List<String> listDataHeader;
    String dept[] = { "CSE","ECE","EEE","MECH","BIOTECH","BIOMED","AERO","AUTO","IT","CIVIL" };
    String clg;
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_navigation);
        Intent i = getIntent();
        clg = i.getStringExtra("clg");
        Integer color = i.getIntExtra("color", R.color.black);
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
		expListView = (ExpandableListView) findViewById(R.id.lvExp);
		prepareListData();
		fragment = new Listbooks(null,0,null,getApplicationContext());
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		// setting list adapter
		expListView.setAdapter(listAdapter);
		mDrawerLayout.closeDrawer(expListView);

		expListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
			    
		
				fragment = new Listbooks(dept[groupPosition],childPosition+1,clg,getApplicationContext());
				getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
				mDrawerLayout.closeDrawer(expListView);
				return false;
			}
		});
	}

	

	private OnItemClickListener mDrawerItemClickedListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

			/*switch(position){
			case 0:
				fragment = new MercuryFragment();
				break;
			case 1:
				fragment = new VenusFragment();
				break;
			case 2:
				fragment = new EarthFragment();
				break;
			default:
				return;
			}

			getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
              */
			mDrawerLayout.closeDrawer(expListView);
		}
	};

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

	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("CSE");
		listDataHeader.add("ECE");
		listDataHeader.add("EEE");
		listDataHeader.add("MECH");
		listDataHeader.add("BIOTECH");
		listDataHeader.add("BIOMED");
		listDataHeader.add("AERO");
		listDataHeader.add("AUTO");
		listDataHeader.add("IT");
		listDataHeader.add("CIVIL");

		// Adding child data
		List<String> sem = new ArrayList<String>();
		sem.add("Semester 1");
		sem.add("Semester 2");
		sem.add("Semester 3");
		sem.add("Semester 4");
		sem.add("Semester 5");
		sem.add("Semester 6");
		sem.add("Semester 7");
		sem.add("Semester 8");

		

		listDataChild.put(listDataHeader.get(0), sem); // Header, Child data
		listDataChild.put(listDataHeader.get(1), sem);
		listDataChild.put(listDataHeader.get(2), sem);
		listDataChild.put(listDataHeader.get(3), sem);
		listDataChild.put(listDataHeader.get(4), sem);
		listDataChild.put(listDataHeader.get(5), sem);
		listDataChild.put(listDataHeader.get(6), sem);
		listDataChild.put(listDataHeader.get(7), sem);
		listDataChild.put(listDataHeader.get(8), sem);
		listDataChild.put(listDataHeader.get(9), sem);
	}

	public class ExpandableListAdapter extends BaseExpandableListAdapter {

		private Context _context;
		private List<String> _listDataHeader; // header titles
		// child data in format of header title, child title
		private HashMap<String, List<String>> _listDataChild;

		public ExpandableListAdapter(Context context, List<String> listDataHeader,
				HashMap<String, List<String>> listChildData) {
			this._context = context;
			this._listDataHeader = listDataHeader;
			this._listDataChild = listChildData;
		}

		@Override
		public Object getChild(int groupPosition, int childPosititon) {
			return this._listDataChild.get(this._listDataHeader.get(groupPosition))
					.get(childPosititon);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, final int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {

			final String childText = (String) getChild(groupPosition, childPosition);

			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_item, null);
			}

			TextView txtListChild = (TextView) convertView
					.findViewById(R.id.lblListItem);

			txtListChild.setText(childText);
			return convertView;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return this._listDataChild.get(this._listDataHeader.get(groupPosition))
					.size();
		}

		@Override
		public Object getGroup(int groupPosition) {
			return this._listDataHeader.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			return this._listDataHeader.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			String headerTitle = (String) getGroup(groupPosition);
			if (convertView == null) {
				LayoutInflater infalInflater = (LayoutInflater) this._context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.list_group, null);
			}

			TextView lblListHeader = (TextView) convertView
					.findViewById(R.id.lblListHeader);
			lblListHeader.setTypeface(null, Typeface.BOLD);
			lblListHeader.setText(headerTitle);

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}
	
	
}
