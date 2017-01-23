package com.example.adapter;

import java.util.List;

import com.example.seeweather.R;



import android.R.integer;
import android.content.Context;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
 private List<String> mList;
 private LayoutInflater inflater;
 //public int count=17;
	public MyAdapter(Context context,List<String> slist){
		inflater=LayoutInflater.from(context);
		this.mList=slist;
		 
	}
	
  /* public MyAdapter(Context context)
   {
	   inflater=LayoutInflater.from(context);
   }*/
 
	/*public void binddata(List<String> list)
	{
		this.mList=list;
	}*/
	
	  
	

	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		
		
	 	ViewHolder holder;
		if (convertView == null)
		{
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.all,null);
			holder.citytextView= (TextView)convertView.findViewById(R.id.allcity);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		
		holder.citytextView.setText(mList.get(position));
		
		
	 
		return convertView;
	}

   class ViewHolder
	{
		private TextView citytextView;
		
	}

   


}
