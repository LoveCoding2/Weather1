package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class TxtBean implements Parcelable{
	private String comftxt;
	 public String getComftxt() {
		return comftxt;
	}
	public void setComftxt(String comftxt) {
		this.comftxt = comftxt;
	}
	public String getCwtxt() {
		return cwtxt;
	}
	public void setCwtxt(String cwtxt) {
		this.cwtxt = cwtxt;
	}
	public String getDrsgtxt() {
		return drsgtxt;
	}
	public void setDrsgtxt(String drsgtxt) {
		this.drsgtxt = drsgtxt;
	}
	public String getFlutxt() {
		return flutxt;
	}
	public void setFlutxt(String flutxt) {
		this.flutxt = flutxt;
	}
	public String getSporttxt() {
		return sporttxt;
	}
	public void setSporttxt(String sporttxt) {
		this.sporttxt = sporttxt;
	}
	public String getTravtxt() {
		return travtxt;
	}
	public void setTravtxt(String travtxt) {
		this.travtxt = travtxt;
	}
	public String getUvtxt() {
		return uvtxt;
	}
	public void setUvtxt(String uvtxt) {
		this.uvtxt = uvtxt;
	}
	private String cwtxt;
	 private String drsgtxt;
	 private String flutxt;
	 private String sporttxt;
	 private String travtxt;
	 private String uvtxt;
	@Override
	public int describeContents() {
		
		return 0;
	}
	@Override
	public void writeToParcel(Parcel parcel, int arg1)
	{
		parcel.writeString(comftxt);
		parcel.writeString(cwtxt);
	    parcel.writeString(drsgtxt);
		parcel.writeString(flutxt);
		parcel.writeString(sporttxt);
		parcel.writeString(travtxt);
		parcel.writeString(uvtxt);
		
	}
	
	public static final Parcelable.Creator<TxtBean> CREATOR=new Parcelable.Creator<TxtBean>() 
			{

				@Override
				public TxtBean createFromParcel(Parcel source) {
					TxtBean txtBean=new TxtBean();
					txtBean.comftxt=source.readString();
				    txtBean.cwtxt=source.readString();
					txtBean.drsgtxt=source.readString();
				    txtBean.flutxt=source.readString();
					txtBean.sporttxt=source.readString();
				    txtBean.travtxt=source.readString();
				    txtBean.uvtxt=source.readString();
				   
				    
					return txtBean;
				}

				@Override
				public TxtBean[] newArray(int size) {
					// TODO Auto-generated method stub
					return new TxtBean[size];
				}
			};
}
