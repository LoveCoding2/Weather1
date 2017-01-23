package com.example.bean;

import android.os.Parcel;


import android.os.Parcelable;

public class NowBean implements Parcelable{
  public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
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
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
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
private String code;
  public NowBean() {
	
}
private String txt;
  public NowBean(String code, String txt, String hum, String pcpn, String tmp,
		String dir, String sc, String spd,String fl,String pres,String vis,String deg) {
	
	this.code = code;
	this.txt = txt;
	this.hum = hum;
	this.pcpn = pcpn;
	this.tmp = tmp;
	this.dir = dir;
	this.sc = sc;
	this.spd = spd;
	this.fl=fl;
	this.pres=pres;
	this.vis=vis;
	this.deg=deg;
}
private String hum;
  private String pcpn;
  private String tmp;
  private String dir;
  private String sc;
  private String spd;
private String fl;
  public String getFl() {
	return fl;
}
public void setFl(String fl) {
	this.fl = fl;
}
public String getPres() {
	return pres;
}
public void setPres(String pres) {
	this.pres = pres;
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
public static Parcelable.Creator<NowBean> getCreator() {
	return CREATOR;
}
private String pres;
  private String vis;
  private String deg;
@Override
public int describeContents() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void writeToParcel(Parcel parcel, int arg1) {
	parcel.writeString(code);
	parcel.writeString(txt);
	parcel.writeString(hum);
	parcel.writeString(pcpn);
	parcel.writeString(tmp);
	parcel.writeString(dir);
	parcel.writeString(sc);
	parcel.writeString(spd);
	parcel.writeString(fl);
	parcel.writeString(pres);
	parcel.writeString(vis);
	parcel.writeString(deg);
}

public static final Parcelable.Creator<NowBean> CREATOR=new Parcelable.Creator<NowBean>() 
{

	@Override
	public NowBean createFromParcel(Parcel source) {
	    NowBean nowBean=new NowBean();
		nowBean.code=source.readString();
		nowBean.txt=source.readString();
		nowBean.hum=source.readString();
		nowBean.pcpn=source.readString();
		nowBean.tmp=source.readString();
		nowBean.dir=source.readString();
		nowBean.sc=source.readString();
		nowBean.spd=source.readString();
		nowBean.fl=source.readString();
		nowBean.pres=source.readString();
		nowBean.vis=source.readString();
		nowBean.deg=source.readString();
		return nowBean;
	}

	@Override
	public NowBean[] newArray(int size) {
		// TODO Auto-generated method stub
		return new NowBean[size];
	}
};
  
}
