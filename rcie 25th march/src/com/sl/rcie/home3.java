package com.sl.rcie;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ListFragment;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


class desc
{
	String t;
	desc(String a)
	{ t=a;
	}
	String getT()
	{return t;
	}
	
}

public class home3 extends ListFragment{

    private int mActionBarTitleColor;
    private int mActionBarHeight;
    private int mHeaderHeight;
    private int mMinHeaderTranslation;
    private ListView mListView;
    private KenBurnsView mHeaderPicture;
    private ImageView mHeaderLogo;
    private View mHeader;
    private View mPlaceHolderView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;

    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();

    private AlphaForegroundColorSpan mAlphaForegroundColorSpan;
    private SpannableString mSpannableString;

    private TypedValue mTypedValue = new TypedValue();
    TextView tv;
    ArrayList<desc> descList;
    int p;
    String content;
    
    home3(int pos)
    {
    	p=pos;
    }
    
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
		View v = null;
		if(p==1)
		{  v = inflater.inflate(R.layout.home, container, false);
	        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
	        mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
	        mMinHeaderTranslation = -mHeaderHeight + getActionBarHeight();
	        mListView = (ListView) v.findViewById(android.R.id.list);
	        mHeader = v.findViewById(R.id.header);
	        mHeaderPicture = (KenBurnsView) v.findViewById(R.id.header_picture);
	        mHeaderPicture.setResourceIds(R.drawable.bghome, R.drawable.bghome2);
	        descList=new ArrayList<desc>();
	        mHeaderLogo = (ImageView) v.findViewById(R.id.header_logo);
	        mActionBarTitleColor = getResources().getColor(R.color.actionbar_title_color);
	        mSpannableString = new SpannableString(getString(R.string.noboringactionbar_title));
	        mAlphaForegroundColorSpan = new AlphaForegroundColorSpan(mActionBarTitleColor);
	        ActionBar actionBar = getActivity().getActionBar();
	        actionBar.setBackgroundDrawable(null);
	        actionBar.setIcon(R.drawable.ic_transparent);
		}
		  
		  
	      return v;
		}
	public void onActivityCreated(Bundle savedState) {
	     super.onActivityCreated(savedState);
	     setupListView();
	 }

	
	private void setupListView() {
        descList.add(new desc("file:///android_asset/index.html"));
       // for (int i = 0; i < 20; i++) {
         //  descList.add(new desc(" "));
       // }
        mPlaceHolderView = getActivity().getLayoutInflater().inflate(R.layout.view_header_placeholder, mListView, false);
        mListView.addHeaderView(mPlaceHolderView);
        ArrayAdapter<desc> adap = new DescAdapter(getActivity(),R.layout.eachrow2,descList);
        
        mListView.setAdapter(adap);
        mListView.setDivider(null);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int scrollY = getScrollY();
                //sticky actionbar
                mHeader.setTranslationY(Math.max(-scrollY, mMinHeaderTranslation));
                //header_logo --> actionbar icon
                float ratio = clamp(mHeader.getTranslationY() / mMinHeaderTranslation, 0.0f, 1.0f);
                interpolate(mHeaderLogo, getActionBarIconView(), mSmoothInterpolator.getInterpolation(ratio));
                //actionbar title alpha
                //getActionBarTitleView().setAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
                //---------------------------------
                //better way thanks to @cyrilmottier
                setTitleAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
            }
        });
    }
	private void setTitleAlpha(float alpha) {
        mAlphaForegroundColorSpan.setAlpha(alpha);
        mSpannableString.setSpan(mAlphaForegroundColorSpan, 0, mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getActivity().getActionBar().setTitle(mSpannableString);
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min,Math.min(value, max));
    }

    private void interpolate(View view1, View view2, float interpolation) {
        getOnScreenRect(mRect1, view1);
        getOnScreenRect(mRect2, view2);

        float scaleX = 1.0F + interpolation * (mRect2.width() / mRect1.width() - 1.0F);
        float scaleY = 1.0F + interpolation * (mRect2.height() / mRect1.height() - 1.0F);
        float translationX = 0.5F * (interpolation * (mRect2.left + mRect2.right - mRect1.left - mRect1.right));
        float translationY = 0.5F * (interpolation * (mRect2.top + mRect2.bottom - mRect1.top - mRect1.bottom));

        view1.setTranslationX(translationX);
        view1.setTranslationY(translationY - mHeader.getTranslationY());
        view1.setScaleX(scaleX);
        view1.setScaleY(scaleY);
    }

    private RectF getOnScreenRect(RectF rect, View view) {
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        return rect;
    }

    public int getScrollY() {
        View c = mListView.getChildAt(0);
        if (c == null) {
            return 0;
        }

        int firstVisiblePosition = mListView.getFirstVisiblePosition();
        int top = c.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mPlaceHolderView.getHeight();
        }

        return -top + firstVisiblePosition * c.getHeight() + headerHeight;
    }

    private void setupActionBar() {
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setIcon(R.drawable.ic_transparent);

        //getActionBarTitleView().setAlpha(0f);
    }

    private ImageView getActionBarIconView() {
        return (ImageView) getActivity().findViewById(android.R.id.home);
    }

    /*private TextView getActionBarTitleView() {
        int id = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        return (TextView) findViewById(id);
    }*/

    public int getActionBarHeight() {
        if (mActionBarHeight != 0) {
            return mActionBarHeight;
        }
        getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue, true);
        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, getResources().getDisplayMetrics());
        return mActionBarHeight;
    }
   
     @SuppressLint("ViewHolder") class DescAdapter extends ArrayAdapter<desc>
     {

		public DescAdapter(Context context, int resource,ArrayList<desc> al) {
			super(context,R.layout.eachrow,al);
			// TODO Auto-generated constructor stub
		}
    	 
		@SuppressWarnings("unchecked")
		public View getView(int pos, View v,ViewGroup vg)
		{
			v = getActivity().getLayoutInflater().inflate(R.layout.wbhome,vg,false);
			desc cur = (desc) descList.get(pos);
             WebView wb = (WebView) v.findViewById(R.id.wbhome);
			  wb.loadUrl(cur.getT());
             //Typeface tf = new Typeface();
			//tv.setTypeface(tf);
			return v;
		}
     }

}
