package com.sl.rcie;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class eachsavednews extends Activity{
	
	TextView paragraph,title;
	ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eachsavednews);
        ActionBar ab = getActionBar();
        ab.hide();
        paragraph =(TextView)findViewById(R.id.paragraph);
        title =(TextView)findViewById(R.id.titehead);
        image = (ImageView)findViewById(R.id.image);
        
    }


}
