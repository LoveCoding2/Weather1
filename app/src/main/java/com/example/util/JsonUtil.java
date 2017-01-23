package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.bean.BrfBean;
import com.example.bean.CityBean;
import com.example.bean.DailyBean;
import com.example.bean.TxtBean;

public class JsonUtil {
  public static List<String> getcityinfo(String cityurl)
  {
	  List<String> citylist=new ArrayList<String>();
	  
	  try {
		JSONObject jsonObject=new JSONObject(cityurl);
		if (jsonObject.getString("status").equals("ok")) 
		{
			JSONArray jsonArray=jsonObject.getJSONArray("city_info");
			for (int i = 1; i <jsonArray.length(); i++)
			{
				JSONObject jsonObject2=jsonArray.getJSONObject(i);
				String city=jsonObject2.getString("city");
			   
			   	citylist.add(city);
			  		
				
			}
			
			
		}
			
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return citylist;
	  
  }
  
  public static List<String> getcityid(String citynameurl)
  {
	  List<String> mcitylist=new ArrayList<String>();
	  try {
		JSONObject jsonObject=new JSONObject(citynameurl);
		if (jsonObject.getString("status").equals("ok"))
		{
			JSONArray jsonArray=jsonObject.getJSONArray("city_info");
			for (int i = 1; i <jsonArray.length(); i++)
			{
				JSONObject jsonObject2=jsonArray.getJSONObject(i);
				String cityid=jsonObject2.getString("id");
				mcitylist.add(cityid);
			}
		}
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return mcitylist;
	  
  }
  
  
  
 public static List<CityBean> getCityBeans(String msrc)
 {
	 List<CityBean> lCityBeans=new ArrayList<CityBean>();
	 CityBean cityBean=new CityBean();
	 try {
		JSONObject jsonObject=new JSONObject(msrc);
		
			JSONArray jsonArray =jsonObject.getJSONArray("HeWeather data service 3.0");
			for (int i =0; i <jsonArray.length(); i++)
			{
				JSONObject jsonObject2=jsonArray.getJSONObject(i);
				
				
					String city=jsonObject2.getJSONObject("basic").getString("city");
					cityBean.setCity(city);
					JSONArray jsonArray2=jsonObject2.getJSONArray("daily_forecast");
					for (int j =jsonArray2.length()-1; j>=0; j--)
					{
						JSONObject tempJsonObject=jsonArray2.getJSONObject(j);
						String max=tempJsonObject.getJSONObject("tmp").getString("max");
						String min=tempJsonObject.getJSONObject("tmp").getString("min");
						String temprange=min+"бл"+max+"бу";
						cityBean.setTemprange(temprange);
						
					}
					lCityBeans.add(cityBean);
				
			
				
			}
		
		
	
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lCityBeans;
	 
 }
 
 public static BrfBean getBrfBeans(String brf)
 {
	 
	 BrfBean brfBean=new BrfBean();
	 try {
		JSONObject jsonObject=new JSONObject(brf);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			if (jsonObject2.getJSONObject("suggestion")!=null)
			{
				String comfbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("comf").getString("brf");
				brfBean.setComfbrf(comfbrf);
				String cwbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("cw").getString("brf");
				brfBean.setCwbrf(cwbrf);
				String drsgbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("drsg").getString("brf");
				brfBean.setDrsgbrf(drsgbrf);
				String flubrf=jsonObject2.getJSONObject("suggestion").getJSONObject("flu").getString("brf");
			    brfBean.setFlubrf(flubrf);
				String sportbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("sport").getString("brf");
			    brfBean.setSportbrf(sportbrf);
				String travbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("trav").getString("brf");
				brfBean.setTravbrf(travbrf);
				String uvbrf=jsonObject2.getJSONObject("suggestion").getJSONObject("uv").getString("brf");
				brfBean.setUvbrf(uvbrf);
			}
			
		}
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return brfBean;
	 
 }
 
 public static TxtBean getTxtBeans(String txt)
 {
	 
	 TxtBean txtBean=new TxtBean();
	 try {
		JSONObject jsonObject=new JSONObject(txt);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			if (jsonObject2.getJSONObject("suggestion")!=null)
			{
				String comftxt=jsonObject2.getJSONObject("suggestion").getJSONObject("comf").getString("txt");
				txtBean.setComftxt(comftxt);
				String cwtxt=jsonObject2.getJSONObject("suggestion").getJSONObject("cw").getString("txt");
				txtBean.setCwtxt(cwtxt);
				String drsgtxt=jsonObject2.getJSONObject("suggestion").getJSONObject("drsg").getString("txt");
				txtBean.setDrsgtxt(drsgtxt);
				String flutxt=jsonObject2.getJSONObject("suggestion").getJSONObject("flu").getString("txt");
			   txtBean.setFlutxt(flutxt);
				String sporttxt=jsonObject2.getJSONObject("suggestion").getJSONObject("sport").getString("txt");
			    txtBean.setSporttxt(sporttxt);
				String travtxt=jsonObject2.getJSONObject("suggestion").getJSONObject("trav").getString("txt");
				txtBean.setTravtxt(travtxt);
				String uvtxt=jsonObject2.getJSONObject("suggestion").getJSONObject("uv").getString("txt");
				txtBean.setUvtxt(uvtxt);
			}
			
			
		}
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return txtBean;
	 
 }
		
 public static Bitmap getBitmapfromUrl(String biturl)
 { 
	 Bitmap bitmap=null;
	 try {
		URL myUrl=new URL(biturl);
		HttpURLConnection httpURLConnection=(HttpURLConnection) myUrl.openConnection();
		InputStream inputStream=httpURLConnection.getInputStream();
		bitmap=BitmapFactory.decodeStream(inputStream);
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return bitmap;
	 
 }
 
 

  
  
}
