package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BrfBean implements Parcelable{
 public String getComfbrf() {
		return comfbrf;
	}
	public void setComfbrf(String comfbrf) {
		this.comfbrf = comfbrf;
	}
	public String getCwbrf() {
		return cwbrf;
	}
	public void setCwbrf(String cwbrf) {
		this.cwbrf = cwbrf;
	}
	public String getDrsgbrf() {
		return drsgbrf;
	}
	public void setDrsgbrf(String drsgbrf) {
		this.drsgbrf = drsgbrf;
	}
	public String getFlubrf() {
		return flubrf;
	}
	public void setFlubrf(String flubrf) {
		this.flubrf = flubrf;
	}
	public String getSportbrf() {
		return sportbrf;
	}
	public void setSportbrf(String sportbrf) {
		this.sportbrf = sportbrf;
	}
	public String getTravbrf() {
		return travbrf;
	}
	public void setTravbrf(String travbrf) {
		this.travbrf = travbrf;
	}
	public String getUvbrf() {
		return uvbrf;
	}
	public void setUvbrf(String uvbrf) {
		this.uvbrf = uvbrf;
	}
private String comfbrf;
 private String cwbrf;
 private String drsgbrf;
 private String flubrf;
 private String sportbrf;
 private String travbrf;
 private String uvbrf;
@Override
public int describeContents() {
	
	return 0;
}
@Override
public void writeToParcel(Parcel parcel, int arg1) {
	parcel.writeString(comfbrf);
	parcel.writeString(cwbrf);
    parcel.writeString(drsgbrf);
	parcel.writeString(flubrf);
	parcel.writeString(sportbrf);
	parcel.writeString(travbrf);
	parcel.writeString(uvbrf);

	}

public static final Parcelable.Creator<BrfBean> CREATOR=new Parcelable.Creator<BrfBean>() 
{

	@Override
	public BrfBean createFromParcel(Parcel source) {
		BrfBean brfBean=new BrfBean();
		brfBean.comfbrf=source.readString();
	    brfBean.cwbrf=source.readString();
		brfBean.drsgbrf=source.readString();
	    brfBean.flubrf=source.readString();
		brfBean.sportbrf=source.readString();
	    brfBean.travbrf=source.readString();
	    brfBean.uvbrf=source.readString();
	   
	    
		return brfBean;
	}

	@Override
	public BrfBean[] newArray(int size) {
		// TODO Auto-generated method stub
		return new BrfBean[size];
	}
};

}
