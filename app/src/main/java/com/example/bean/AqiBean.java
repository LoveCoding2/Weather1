package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AqiBean implements Parcelable{
  private String aqi;
  private String co;
  private String no2;
  private String o3;
  private String pm10;
  private String pm25;
  private String qlty;
  private String so2;
public String getAqi() {
	return aqi;
}
public void setAqi(String aqi) {
	this.aqi = aqi;
}
public String getCo() {
	return co;
}
public void setCo(String co) {
	this.co = co;
}
public String getNo2() {
	return no2;
}
public void setNo2(String no2) {
	this.no2 = no2;
}
public String getO3() {
	return o3;
}
public void setO3(String o3) {
	this.o3 = o3;
}
public String getPm10() {
	return pm10;
}
public void setPm10(String pm10) {
	this.pm10 = pm10;
}
public String getPm25() {
	return pm25;
}
public void setPm25(String pm25) {
	this.pm25 = pm25;
}
public String getQlty() {
	return qlty;
}
public void setQlty(String qlty) {
	this.qlty = qlty;
}
public String getSo2() {
	return so2;
}
public void setSo2(String so2) {
	this.so2 = so2;
}
public AqiBean() {
	
}
public AqiBean(String aqi, String co, String no2, String o3, String pm10,
		String pm25, String qlty, String so2) {
	
	this.aqi = aqi;
	this.co = co;
	this.no2 = no2;
	this.o3 = o3;
	this.pm10 = pm10;
	this.pm25 = pm25;
	this.qlty = qlty;
	this.so2 = so2;
}
@Override
public int describeContents() {
	
	return 0;
}
@Override
public void writeToParcel(Parcel parcel, int arg1) {
  parcel.writeString(aqi);
  parcel.writeString(co);
  parcel.writeString(no2);
  parcel.writeString(o3);
  parcel.writeString(pm10);
  parcel.writeString(pm25);
  parcel.writeString(qlty);
  parcel.writeString(so2);
	
}

 public static final Parcelable.Creator<AqiBean> CREATOR=new Parcelable.Creator<AqiBean>() 
		 {

			@Override
			public AqiBean createFromParcel(Parcel source) {
				AqiBean aqiBean=new AqiBean();
				aqiBean.co=source.readString();
				aqiBean.no2=source.readString();
				aqiBean.o3=source.readString();
				aqiBean.pm10=source.readString();
				aqiBean.pm25=source.readString();
				aqiBean.qlty=source.readString();
				aqiBean.so2=source.readString();
				return aqiBean;
			}

			@Override
			public AqiBean[] newArray(int size) {
				// TODO Auto-generated method stub
				return new AqiBean[size];
			}
};


  
 
}
