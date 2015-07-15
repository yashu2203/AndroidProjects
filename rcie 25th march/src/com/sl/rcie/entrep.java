package com.sl.rcie;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class entrep extends Fragment{
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState)
    {  View v =getActivity().getLayoutInflater().inflate(R.layout.newsview, container,false);
        WebView wb = (WebView) v.findViewById(R.id.webView1);
        
        ActionBar b = getActivity().getActionBar();
        b.setTitle("Entrepreneurship");
        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.bgentrep));
        b.setBackgroundDrawable(cd);
        b.setIcon(R.drawable.entrep);
        b.setHomeButtonEnabled(true);
        wb.loadUrl("file:///android_asset/entrepreneurship.html");
		return v;
    	
    }
    
    
   
}
