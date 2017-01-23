package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class HourlyBean implements Parcelable{
 public HourlyBean() {
		
	}
private String date;
 public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getHum() {
	return hum;
}
public void setHum(String hum) {
	this.hum = hum;
}
public String getPop() {
	return pop;
}
public void setPop(String pop) {
	this.pop = pop;
}
public String getPres() {
	return pres;
}
public void setPres(String pres) {
	this.pres = pres;
}
public String getTmp() {
	return tmp;
}
public void setTmp(String tmp) {
	this.tmp = tmp;
}
public String getDeg() {
	return deg;
}
public void setDeg(String deg) {
	this.deg = deg;
}
public String getDir() {
	return dir;
}
public void setDir(String dir) {
	this.dir = dir;
}
public String getSc() {
	return sc;
}
public void setSc(String sc) {
	this.sc = sc;
}
public String getSpd() {
	return spd;
}
public void setSpd(String spd) {
	this.spd = spd;
}
private String hum;
 public HourlyBean(String date, String hum, String pop, String pres, String tmp,
		String deg, String dir, String sc, String spd) {
	
	this.date = date;
	this.hum = hum;
	this.pop = pop;
	this.pres = pres;
	this.tmp = tmp;
	this.deg = deg;
	this.dir = dir;
	this.sc = sc;
	this.spd = spd;
}
private String pop;
 private String pres;
 private String tmp;
 private String deg;
 private String dir;
 private String sc;
 private String spd;
@Override
public int describeContents() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void writeToParcel(Parcel parcel, int arg1) {
	parcel.writeString(date);
	parcel.writeString(hum);
	parcel.writeString(pop);
	parcel.writeString(pres);
	parcel.writeString(tmp);
	parcel.writeString(deg);
	parcel.writeString(dir);
	parcel.writeString(sc);
	parcel.writeString(spd);
	
	
}

public static final Parcelable.Creator<HourlyBean> CREATOR=new Parcelable.Creator<HourlyBean>() 
{

	@Override
	public HourlyBean createFromParcel(Parcel source) {
		HourlyBean hourlyBean=new HourlyBean();
		hourlyBean.date=source.readString();
		hourlyBean.hum=source.readString();
		hourlyBean.pop=source.readString();
		hourlyBean.pres=source.readString();
		hourlyBean.tmp=source.readString();
		hourlyBean.deg=source.readString();
	    hourlyBean.dir=source.readString();
	    hourlyBean.sc=source.readString();
	    hourlyBean.spd=source.readString();
		return hourlyBean;
	}

	@Override
	public HourlyBean[] newArray(int size) {
		// TODO Auto-generated method stub
		return new HourlyBean[size];
	}
};
 
 
}
