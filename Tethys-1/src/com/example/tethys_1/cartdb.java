package com.example.tethys_1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.sweetlime.tethys.R;


class purchase {
	public String getSub() {
		return sub;
	}
	public void setQu(int qu)
	{
		this.qu=qu;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getCond() {
		return cond;
	}
	public void setCond(String cond) {
		this.cond = cond;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getThumb()
	{
		return R.drawable.b1;
	}
	public int getQu()
	{
		return qu;
	}
	String sub,auth,cond;
	int price,thumb,sn,qu;
	public purchase(String sub, String auth, String cond, int price,int qu) {
		super();
		this.sub = sub;
		this.auth = auth;
		this.cond = cond;
		this.price = price;
		this.qu=qu;
	}
	public purchase() {
		// TODO Auto-generated constructor stub
	}
	public void setSn(int parseInt) {
		// TODO Auto-generated method stub
		sn=parseInt;
	}
	public int getSn()
	{
		return sn;
	}

}

public class cartdb extends SQLiteOpenHelper{
    public cartdb(Context context) {
		super(context, "cart3", null,1);
		// TODO Auto-generated constructor stub
	}

	static int s=0;
    

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS cart3");
		String table = "CREATE TABLE cart3( sn number(3) primary key,sub varchar(30), auth varchar(30), cond varchar(30), price number(5), qu number(3) );";
		db.execSQL(table);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS cart3 ");
		 
        // Create tables again
        onCreate(db);
	}
	
	
   public void drop()
   { SQLiteDatabase db = this.getWritableDatabase();
     db.execSQL("DROP TABLE IF EXISTS cart3 ");
   }
	
	public void addBook(purchase p)
	{  s++;
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues v = new ContentValues();
		p.setSn(s);
		v.put("sn",s);
		v.put("sub",p.getSub());
		v.put("auth", p.getAuth());
		v.put("cond", p.getCond());
		v.put("price", p.getPrice()+"");
		v.put("qu", p.getQu()+"");
		
		db.insert("cart3", null, v);
		
	}
	public void delBook(purchase p)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete("cart3", "sn=?", new String[]{String.valueOf(p.getSn())}  );
	}
	public List<purchase> getAlBooks()
	{
		List<purchase> purlist = new ArrayList<purchase>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM cart3";
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            purchase p = new purchase();
	            p.setSn(Integer.parseInt(cursor.getString(0)));
	            p.setSub(cursor.getString(1));
	            p.setAuth(cursor.getString(2));
	            p.setCond(cursor.getString(3));
	            p.setPrice(Integer.parseInt(cursor.getString(4)));
	            p.setQu(Integer.parseInt(cursor.getString(5)));
	            // Adding contact to list
	            purlist.add(p);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return purlist;
	}
	
	

}
