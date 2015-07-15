package com.sl.rcie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends Activity{
	
	/** Called when the activity is first created. */
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        
        ImageView im1= (ImageView) findViewById(R.id.iv1);
    	Animation anim=AnimationUtils.loadAnimation(splash.this,R.anim.fade);
    	im1.startAnimation(anim);
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
            	
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, 2000);
    }


}
