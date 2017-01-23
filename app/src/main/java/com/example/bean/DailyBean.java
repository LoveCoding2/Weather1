package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DailyBean implements Parcelable {
  public String getSr() {
		return sr;
	}
	public void setSr(String sr) {
		this.sr = sr;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getCode_d() {
		return code_d;
	}
	public void setCode_d(String code_d) {
		this.code_d = code_d;
	}
	public String getCode_n() {
		return code_n;
	}
	public void setCode_n(String code_n) {
		this.code_n = code_n;
	}
	public String getTxt_d() {
		return txt_d;
	}
	public void setTxt_d(String txt_d) {
		this.txt_d = txt_d;
	}
	public String getTxt_n() {
		return txt_n;
	}
	public void setTxt_n(String txt_n) {
		this.txt_n = txt_n;
	}
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
	public String getPcpn() {
		return pcpn;
	}
	public void setPcpn(String pcpn) {
		this.pcpn = pcpn;
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
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getVis() {
		return vis;
	}
	public void setVis(String vis) {
		this.vis = vis;
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
private String sr;
  private String ss;
  private String code_d;
  private String code_n;
  private String txt_d;
  private String txt_n;
  private String date;
  private String hum;
  private String pcpn;
  private String pop;
  private String pres;
  private String max;
  private String min;
  private String vis;
  private String deg;
  private String dir;
  private String sc;
  private String spd;
public DailyBean() {
	
}
public DailyBean(String sr, String ss, String code_d, String code_n,
		String txt_d, String txt_n, String date, String hum, String pcpn,
		String pop, String pres, String max, String min, String vis,
		String deg, String dir, String sc, String spd) {
	
	this.sr = sr;
	this.ss = ss;
	this.code_d = code_d;
	this.code_n = code_n;
	this.txt_d = txt_d;
	this.txt_n = txt_n;
	this.date = date;
	this.hum = hum;
	this.pcpn = pcpn;
	this.pop = pop;
	this.pres = pres;
	this.max = max;
	this.min = min;
	this.vis = vis;
	this.deg = deg;
	this.dir = dir;
	this.sc = sc;
	this.spd = spd;
}
@Override
public int describeContents() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void writeToParcel(Parcel parcel, int arg1) {
	parcel.writeString(sr);
	parcel.writeString(ss);
	parcel.writeString(code_d);
	parcel.writeString(code_n);
	parcel.writeString(txt_d);
	parcel.writeString(txt_n);
	parcel.writeString(date);
	parcel.writeString(hum);
	parcel.writeString(pcpn);
	parcel.writeString(pop);
	parcel.writeString(pres);
	parcel.writeString(max);
	parcel.writeString(min);
	parcel.writeString(vis);
	parcel.writeString(deg);
	parcel.writeString(dir);
	parcel.writeString(sc);
	parcel.writeString(spd);
	
}

public static final Parcelable.Creator<DailyBean> CREATOR=new Parcelable.Creator<DailyBean>() 
{

	@Override
	public DailyBean createFromParcel(Parcel source) {
		DailyBean dailyBean=new DailyBean();
		dailyBean.sr=source.readString();
		dailyBean.ss=source.readString();
		dailyBean.code_d=source.readString();
		dailyBean.code_n=source.readString();
		dailyBean.txt_d=source.readString();
		dailyBean.txt_n=source.readString();
		dailyBean.date=source.readString();
		dailyBean.hum=source.readString();
		dailyBean.pcpn=source.readString();
		dailyBean.pop=source.readString();
		dailyBean.pres=source.readString();
		dailyBean.max=source.readString();
		dailyBean.min=source.readString();
		dailyBean.vis=source.readString();
		dailyBean.deg=source.readString();
		dailyBean.dir=source.readString();
		dailyBean.sc=source.readString();
		dailyBean.spd=source.readString();
		return dailyBean;
	}

	@Override
	public DailyBean[] newArray(int size) {
		// TODO Auto-generated method stub
		return new DailyBean[size];
	}
};


  
}
