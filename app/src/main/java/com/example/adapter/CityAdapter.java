package com.example.adapter;

import java.util.List;


import com.example.bean.CityBean;
import com.example.seeweather.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CityAdapter extends BaseAdapter
{
 private List<CityBean> lBeans;
 private LayoutInflater layoutInflater;
 
 public CityAdapter(Context context,List<CityBean> lBeans)
 {
	 layoutInflater=LayoutInflater.from(context);
	 this.lBeans=lBeans;
 }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lBeans.size();
	}
	
	


	@Override
	public Object getItem(int position) {
		
		return lBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup arg2)
	{
		ViewHolder viewHolder;
		if (convertview==null) {
			viewHolder=new ViewHolder();
			convertview=layoutInflater.inflate(R.layout.city,null);
			viewHolder.citytTextView=(TextView) convertview.findViewById(R.id.mycity);
			viewHolder.tempTextView=(TextView) convertview.findViewById(R.id.mytemp);
			convertview.setTag(viewHolder);
		}
		else {
			viewHolder=(ViewHolder) convertview.getTag();
		}
		
        CityBean cityBean =lBeans.get(position);
		viewHolder.citytTextView.setText(cityBean.getCity());
		viewHolder.tempTextView.setText(cityBean.getTemprange());
		
		return convertview;
	}
	
	class ViewHolder
	{
		private TextView citytTextView;
		private TextView tempTextView;
	}
	
	}

