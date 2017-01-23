package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BasicBean implements Parcelable{
	  public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCnty() {
			return cnty;
		}
		public void setCnty(String cnty) {
			this.cnty = cnty;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getLat() {
			return lat;
		}
		public void setLat(String lat) {
			this.lat = lat;
		}
		public String getLon() {
			return lon;
		}
		public void setLon(String lon) {
			this.lon = lon;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}
		public String getUtc() {
			return utc;
		}
		public void setUtc(String utc) {
			this.utc = utc;
		}
	private String city;
	  private String cnty;
	  private String id;
	  private String lat;
	  private String lon;
	  private String loc;
	  private String utc;
	public BasicBean() {
		
	}
	public BasicBean(String city, String cnty, String id, String lat,
			String lon, String loc, String utc) {

		this.city = city;
		this.cnty = cnty;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.loc = loc;
		this.utc = utc;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(city);
		parcel.writeString(cnty);
		parcel.writeString(id);
		parcel.writeString(lat);
		parcel.writeString(lon);
		parcel.writeString(loc);
		parcel.writeString(utc);
	
	}
	
	 public static final Parcelable.Creator<BasicBean> CREATOR=new Parcelable.Creator<BasicBean>() 
			 {

				@Override
				public BasicBean createFromParcel(Parcel source) {
					BasicBean basicBean=new BasicBean();
					basicBean.city=source.readString();
					basicBean.cnty=source.readString();
					basicBean.id=source.readString();
					basicBean.lat=source.readString();
					basicBean.lon=source.readString();
					basicBean.loc=source.readString();
					basicBean.utc=source.readString();
					return basicBean;
				}

				@Override
				public BasicBean[] newArray(int size) {
					// TODO Auto-generated method stub
					return new BasicBean[size];
				}
	};


}
