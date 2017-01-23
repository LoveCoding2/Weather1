package com.example.util;

import java.util.ArrayList;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.bean.AqiBean;
import com.example.bean.BasicBean;
import com.example.bean.DailyBean;
import com.example.bean.HourlyBean;
import com.example.bean.NowBean;

public class BeanUtil {
  public static AqiBean getAqiBean(String aqiurl)
  {
	  AqiBean aqiBean =null;
	  
	  try {
		JSONObject jsonObject=new JSONObject(aqiurl);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			String aqi=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("aqi");
			String co=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("co");
			String no2=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("no2");
			String o3=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("o3");
			String pm10=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("pm10");
			String pm25=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("pm25");
			String qlty=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("qlty");
			String so2=jsonObject2.getJSONObject("aqi").getJSONObject("city").getString("so2");
		    aqiBean=new AqiBean(aqi, co, no2, o3, pm10, pm25, qlty, so2);
		    
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return aqiBean;
	  
  }
  
  public static BasicBean getBasicBean(String basic)
  {
	BasicBean basicBean = null;
	  try {
		JSONObject jsonObject=new JSONObject(basic);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			String city=jsonObject2.getJSONObject("basic").getString("city");
			String cnty=jsonObject2.getJSONObject("basic").getString("cnty");
			String id=jsonObject2.getJSONObject("basic").getString("id");
			String lat=jsonObject2.getJSONObject("basic").getString("lat");
			String lon=jsonObject2.getJSONObject("basic").getString("lon");
			String loc=jsonObject2.getJSONObject("basic").getJSONObject("update").getString("loc");
			String utc=jsonObject2.getJSONObject("basic").getJSONObject("update").getString("utc");
     
		    basicBean=new BasicBean(city, cnty, id, lat, lon, loc, utc);
		}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return basicBean;
	  
  }
  
  public static ArrayList<DailyBean> getDailyBean(String daily)
  {
	 ArrayList<DailyBean> dailyBeans=new ArrayList<DailyBean>();
	  try {
		JSONObject jsonObject=new JSONObject(daily);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			JSONArray jsonArray2=jsonObject2.getJSONArray("daily_forecast");
			for (int j = 0; j<jsonArray2.length(); j++)
			{
				JSONObject jsonObject3=jsonArray2.getJSONObject(j);
				String sr=jsonObject3.getJSONObject("astro").getString("sr");
				String ss=jsonObject3.getJSONObject("astro").getString("ss");
				String code_d=jsonObject3.getJSONObject("cond").getString("code_d");
				String code_n=jsonObject3.getJSONObject("cond").getString("code_n");
				String txt_d=jsonObject3.getJSONObject("cond").getString("txt_d");
				String txt_n=jsonObject3.getJSONObject("cond").getString("txt_n");
				String date=jsonObject3.getString("date");
				String hum=jsonObject3.getString("hum");
				String pcpn=jsonObject3.getString("pcpn");
				String pop=jsonObject3.getString("pop");
				String pres=jsonObject3.getString("pres");
				String max=jsonObject3.getJSONObject("tmp").getString("max");
				String min=jsonObject3.getJSONObject("tmp").getString("min");
				String vis=jsonObject3.getString("vis");
				String deg=jsonObject3.getJSONObject("wind").getString("deg");
				String dir=jsonObject3.getJSONObject("wind").getString("dir");
				String sc=jsonObject3.getJSONObject("wind").getString("sc");
				String spd=jsonObject3.getJSONObject("wind").getString("spd");
				DailyBean dailyBean=new DailyBean(sr, ss, code_d, code_n, txt_d, txt_n, date, hum, pcpn, pop, pres, max, min, vis, deg, dir, sc, spd);
				dailyBeans.add(dailyBean);
			}
		}
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dailyBeans;
	  
  }
  
  public static ArrayList<HourlyBean> getHourlyBean(String hourly)
  {
	  ArrayList<HourlyBean> hourlyBeans=new ArrayList<HourlyBean>();
	  
	  try {
		JSONObject jsonObject=new JSONObject(hourly);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			JSONArray jsonArray2=jsonObject2.getJSONArray("hourly_forecast");
			for (int j = 0; j<jsonArray2.length();j++) 
			{
				JSONObject jsonObject3=jsonArray2.getJSONObject(j);
				String date=jsonObject3.getString("date");
				String hum=jsonObject3.getString("hum");
				String pop=jsonObject3.getString("pop");
				String pres=jsonObject3.getString("pres");
				String tmp=jsonObject3.getString("tmp");
				String deg2=jsonObject3.getJSONObject("wind").getString("deg");
				String dir2=jsonObject3.getJSONObject("wind").getString("dir");
				String sc2=jsonObject3.getJSONObject("wind").getString("sc");
				String spd2=jsonObject3.getJSONObject("wind").getString("spd");
			   HourlyBean hourlyBean=new HourlyBean(date, hum, pop, pres, tmp, deg2, dir2, sc2, spd2);
			   hourlyBeans.add(hourlyBean);
				
			}
		}
	
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hourlyBeans;
	  
  }
  
  public static NowBean getNowBean(String now)
  {
	 NowBean nowBean=null;
	  try {
		JSONObject jsonObject=new JSONObject(now);
		JSONArray jsonArray=jsonObject.getJSONArray("HeWeather data service 3.0");
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject2=jsonArray.getJSONObject(i);
			String code=jsonObject2.getJSONObject("now").getJSONObject("cond").getString("code");
			String txt=jsonObject2.getJSONObject("now").getJSONObject("cond").getString("txt");
			String fl=jsonObject2.getJSONObject("now").getString("fl");
			String hum=jsonObject2.getJSONObject("now").getString("hum");
			String pcpn=jsonObject2.getJSONObject("now").getString("pcpn");
			String pres=jsonObject2.getJSONObject("now").getString("pres");
			String tmp=jsonObject2.getJSONObject("now").getString("tmp");
			String vis=jsonObject2.getJSONObject("now").getString("vis");
			String deg=jsonObject2.getJSONObject("now").getJSONObject("wind").getString("deg");
			String dir=jsonObject2.getJSONObject("now").getJSONObject("wind").getString("dir");
			String sc=jsonObject2.getJSONObject("now").getJSONObject("wind").getString("sc");
			String spd=jsonObject2.getJSONObject("now").getJSONObject("wind").getString("spd");
			nowBean=new NowBean(code, txt, hum, pcpn, tmp, dir, sc, spd,fl,pres,vis,deg);
		}
	
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nowBean;
	  
  }
  


}
