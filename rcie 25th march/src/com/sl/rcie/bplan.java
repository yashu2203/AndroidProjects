package com.sl.rcie;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;

public class bplan extends Fragment{
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState)
    {  View v =getActivity().getLayoutInflater().inflate(R.layout.newsview, container,false);
        WebView wb = (WebView) v.findViewById(R.id.webView1);
        
        ActionBar b = getActivity().getActionBar();
        b.setTitle("Business Plans");
        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.intelblue));
        b.setIcon(R.drawable.bplan);
        b.setBackgroundDrawable(cd);
        b.setHomeButtonEnabled(true);
        wb.loadUrl("file:///android_asset/B-Plans.html");
		return v;
    	
    }
    
    
   
}
