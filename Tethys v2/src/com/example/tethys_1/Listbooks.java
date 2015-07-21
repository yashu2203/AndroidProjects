package com.example.tethys_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

import com.sweetlime.tethys.R;


class books{
	
	   
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public int getOmrp() {
		return omrp;
	}
	public void setOmrp(int omrp) {
		this.omrp = omrp;
	}
	public int getthumbid()
	{ return R.id.bicon;
	}
	public int getNmrp() { 
		return nmrp;
	}
	public books(String department,int semester,String subject,  String author,
			  int mrp,int nmrp, int omrp) {
		
		this.department = department;
		this.author = author;
		this.subject = subject;
		this.semester = semester;
		this.mrp = mrp;
		this.omrp = omrp;
		this.nmrp=nmrp;
	}
	// String epnum;
		String department,author,subject;
		int semester,mrp,omrp,nmrp;
		

	}





@SuppressLint("NewApi") public class Listbooks extends ListFragment {
    String dept,clg;
    int sem;
    private ProgressDialog pDialog;
    String itembooks[]=new String[4];
    // Creating JSON Parser object
    Jsparser jp;
    ArrayList<books> eps;
    ArrayList<purchase> cartlist;
    ArrayList<HashMap<String, String>> productsList;
    ArrayAdapter<books> adapter;
    Button b,checkout;
    Context context;
    // url to get all products list
    private static String url_all_products = "http://mywamp.hostei.com/query.php";
    ArrayAdapter<String> adapter2;
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    View rv;
    ListView lv;
    // products JSONArray
    JSONArray products = null;
    SlidingDrawer sd;
    int color;
    int flag=1;
    public Listbooks()
    {	
    }
    Listbooks(String a,int b,String c,Context ct,int col)
    {
    	dept = a;
    	sem = b;
    	clg = c;
    	color = col;
    }
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	  
	  if(sem==0)
	  {
		rv = inflater.inflate(R.layout.defaultdrawerview, null);	
	  }
	  else
	  { 
		rv = inflater.inflate(R.layout.listbooks, null);  
	    TextView tv = (TextView) (rv).findViewById(R.id.sem);
			tv.setText(dept+" Sem "+sem);
			context = getActivity();
		//RelativeLayout v = new RelativeLayout(getApplicationContext());
		RelativeLayout v = (RelativeLayout) rv.findViewById(R.id.rl);
		//context = getActivity().getApplicationContext();
		b = (Button) rv.findViewById(R.id.manual1);
		b.setBackgroundResource(R.drawable.bg);
		b.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent(context,Manual.class);
				startActivity(i);
			}
		});
		
           jp = new Jsparser();
           eps =new ArrayList<books>();
           lv = (ListView) rv.findViewById(R.id.list);
           sd = (SlidingDrawer) rv.findViewById(R.id.sd1);
	  }
		
		return rv;
 }
 
    
    @Override
	public void onViewCreated(View v,Bundle b)
  {    if(sem!=0)
       { 
    	new LoadAllProducts().execute();
    	
    	   sd.setOnDrawerOpenListener(new OnDrawerOpenListener(){

   			@Override
   			public void onDrawerOpened() {
   				// TODO Auto-generated method stub
   				
   			}
   			
   		});
   		sd.setOnDrawerCloseListener(new OnDrawerCloseListener(){

   			@Override
   			public void onDrawerClosed() {
   				// TODO Auto-generated method stub
   			}
   			
   		});
   		
   		sd.setOnTouchListener(new View.OnTouchListener(){

   			@Override
   			public boolean onTouch(View v, MotionEvent event) {
   				// TODO Auto-generated method stub
   				
   				ListView lv = (ListView) v.findViewById(R.id.list2);
   				cartlist = (ArrayList<purchase>) new cartdb(context).getAlBooks();
   				adapter adap= new adapter(context, R.layout.bookitem, cartlist);
   				lv.setAdapter(adap);
   				lv.setOnItemClickListener(new OnItemClickListener(){

   					@Override
   					public void onItemClick(AdapterView<?> arg0, View arg1,
   							final int pos, long arg3) {
   						// TODO Auto-generated method stub
   						final Dialog dialog = new Dialog(context);
   						dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
   						dialog.setContentView(R.layout.popup);
   						dialog.show();
   						//Toast.makeText(getApplicationContext(),"item "+pos,Toast.LENGTH_SHORT).show();
   						final purchase p = cartlist.get(pos);
   						TextView tv1 = (TextView) dialog.findViewById(R.id.name);
   						tv1.setText(p.getSub());
   						tv1 = (TextView) dialog.findViewById(R.id.bauth);
   						tv1.setText("Author : "+ p.getAuth());
   						tv1 = (TextView) dialog.findViewById(R.id.cond);
   						tv1.setText("Condition : "+p.getCond());
   						tv1 = (TextView) dialog.findViewById(R.id.quantity);
   						tv1.setText("Quantity :" + p.getQu());
   						tv1 = (TextView) dialog.findViewById(R.id.textView1);
   						tv1.setText("Total : "+ p.getPrice()*p.getQu());
   						Button dialogButton = (Button) dialog.findViewById(R.id.remove);
   					
   						dialogButton.setOnClickListener(new OnClickListener() {
   							@Override
   							public void onClick(View v) {
   								new cartdb(context).delBook(p);
   								dialog.cancel();
   								sd.close();
   								
   							}
   						});
   					}
   					
   				});
   				
   				return false;
   			}
   			
   		});
   		Button chkout = (Button) v.findViewById(R.id.checkout);
   		chkout.setOnClickListener(new OnClickListener()
   		{
   			@Override
   			public void onClick(View v) {
   				
   				String  s ="";
   				int total =0;
   				for(purchase i : cartlist)
   				{
   					s=s+"Subject:"+i.getSub()+"\n";
   					s=s+"Author:"+i.getAuth()+"\n";
   					s=s+"Quantity:"+i.getQu()+"\n";
   					s=s+"Condition:"+i.getCond()+"\n";
   					s=s+"Price:"+i.getPrice()+"\n\n";
   					total+=i.getPrice()*i.getQu();
   				}
   				s=s+"Total:"+total;
   				for(purchase p : cartlist)
   				{
   					new cartdb(getActivity().getApplicationContext()).delBook(p);
   				}
   					Intent i = new Intent(context,Checkout.class);
   					i.putExtra("college", clg);
   					i.putExtra("check",s);
   					startActivity(i);
   			}
   		});
     }	
  }
	class LoadAllProducts extends AsyncTask<String, String, String> {
   	 String name;
   	  int id;
       /**
        * Before starting background thread Show Progress Dialog
        * */
   	 
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pDialog = new ProgressDialog(context);
           pDialog.setMessage("Loading products. Please wait...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(false);
           //pDialog.show();
       }

       /**
        * getting All products from url
        * */
       protected String doInBackground(String... args) {
       	List<NameValuePair> params = new ArrayList<NameValuePair>(); 
           // getting JSON string from URL
       	   params.add(new BasicNameValuePair("dept", dept));
           params.add(new BasicNameValuePair("sem", sem+""));
 
       	
           JSONObject json = jp.makeHttpRequest("http://mywamp.hostei.com/query.php", "GET", params);

           // Check your log cat for JSON reponse
           //Log.d("All Products: ", json.toString());

           try {
               // Checking for SUCCESS TAG
               int success = json.getInt(TAG_SUCCESS);
               //Toast.makeText(getApplicationContext(), success, Toast.LENGTH_SHORT).show();
               if (success == 1) {
                   // products found
                   // Getting Array of Products
               	Log.d("success ","1");
                       JSONArray booksob = json.getJSONArray("Booklist");
                       
                       for(int j=0;j<booksob.length();j++)
                       { JSONObject c = booksob.getJSONObject(j);
                         books temp = new books(c.getString("department"),Integer.parseInt(c.getString("semester")),c.getString("subject"),c.getString("author"),Integer.parseInt(c.getString("mrp")),Integer.parseInt(c.getString("nmrp")) ,Integer.parseInt(c.getString("omrp")) );
                         eps.add(temp);
                       }  
                       eps.add(new books("",0,"Did not find your book? Click this to make a custom order","",0,0,0));
                       Log.d("Length",booksob.length()+"");
                       //Log.d("eps",eps.toString());

                   }
                 else {  
                      flag=0;
               }
           } catch (JSONException e) {
               e.printStackTrace();
           }
          url_all_products="http://mywamp.hostei.com/query.php";
           return null;
           
       }

       /**
        * After completing background task Dismiss the progress dialog
        * **/
       @TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @SuppressWarnings("unchecked")
		protected void onPostExecute(String file_url) {
           // dismiss the dialog after getting all products
           //pDialog.dismiss();
           // updating UI from Background Thread
    	   if(flag==0)
    	   Toast.makeText(getActivity().getApplicationContext(),"no Books found",Toast.LENGTH_SHORT).show();
    	   adapter=new myadapter(getActivity(), eps);
    		lv.setAdapter(adapter);
    		mylistener a = new mylistener();
    		lv.setOnItemClickListener(a);

       }

   }
	class adapter extends ArrayAdapter<purchase> {
       Context mContext;
       ArrayList<purchase> pur;
		public adapter(Context context, int resource,
				ArrayList<purchase> objects) {
			super(context, resource,objects);
			mContext=context;
			pur=objects;
			// TODO Auto-generated constructor stub
		}
		public View getView(int position, View convertView, ViewGroup parent) 
	      { View vu=convertView;
		          if(vu==null)
             { 
		         LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                vu=inflater.inflate(R.layout.bookitem, parent, false);
              }
		//find the episode that needs to be filled with info
		purchase cpur= pur.get(position);
		//fill the imageview
	    ImageView iv=(ImageView) vu.findViewById(R.id.bicon);
		iv.setImageResource(R.drawable.b1);
		//fill the ep name
		TextView tv1=(TextView) vu.findViewById(R.id.bookname);
		tv1.setText(cpur.getSub());
		//fill the airdate
		TextView tv2=(TextView) vu.findViewById(R.id.price);
		tv2.setText(""+cpur.getAuth());
	 
		return vu;
	                } 
   
		
		
	}
	
    class mylistener implements ListView.OnItemClickListener  {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
				long arg3) {
			// TODO Auto-generated method stub
		if(pos==eps.size()-1)
		 {
	      Intent i = new Intent(context,Manual.class);
	      Bundle b = new Bundle();
	      b.putInt("color",color);
	      i.putExtras(b);
	      startActivity(i);
		 }
		else
		 {	
			books bcd = eps.get(pos);
			Intent i = new Intent(context,eachbook.class);
			i.putExtra("sub",bcd.getSubject());
			i.putExtra("auth",bcd.getAuthor());
			i.putExtra("mrp", bcd.getMrp() +"");
			i.putExtra("omrp", bcd.getOmrp()+"");
			i.putExtra("nmrp",bcd.getNmrp()+"");
			Bundle b = new Bundle();
		    b.putInt("color",color);
		    i.putExtras(b);
			startActivity(i);
		 }	
		}
    	
    }
   
   class myadapter extends ArrayAdapter<books> 
	   {
		   Context mContext;
	
		 public myadapter(Context context, ArrayList<books> items ) 
			{   super(context,R.layout.bookitem,items);
				//super(context,0,0,items);
				mContext=context;
			}
		@Override
		      public View getView(int position, View convertView, ViewGroup parent) 
		      { View vu=convertView;
			          if(vu==null)
	               { 
			         LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
	                  vu=inflater.inflate(R.layout.bookitem, parent, false);
	                }
			//find the episode that needs to be filled with info
			books currentb= eps.get(position);
			//fill the imageview
	    if(position!=eps.size()-1)
	    {	ImageView iv=(ImageView) vu.findViewById(R.id.bicon);
			iv.setImageResource(R.drawable.b1);
			//fill the ep name
			TextView tv1=(TextView) vu.findViewById(R.id.bookname);
			tv1.setText(currentb.getSubject());
			//fill the airdate
			TextView tv2=(TextView) vu.findViewById(R.id.price);
			tv2.setText(currentb.getAuthor());
	    }
	    else
	    {
	    	ImageView iv=(ImageView) vu.findViewById(R.id.bicon);
			iv.setImageResource(0);
			iv.setEnabled(false);
			iv.setVisibility(ImageView.INVISIBLE);
			//fill the ep name
			TextView tv1=(TextView) vu.findViewById(R.id.bookname);
			tv1.setText("Did not find your Book? Place a manual request");
			//fill the airdate
			TextView tv2=(TextView) vu.findViewById(R.id.price);
			tv2.setText("");
	    }
			
			
			
			
			return vu;
		                } 
	     
	   }
	   

}
