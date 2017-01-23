package com.example.seeweather;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.LocationClientOption.LocationMode;
import com.example.bean.AqiBean;
import com.example.bean.BasicBean;
import com.example.bean.BrfBean;
import com.example.bean.DailyBean;
import com.example.bean.HourlyBean;
import com.example.bean.NowBean;
import com.example.bean.TxtBean;
import com.example.util.BeanUtil;
import com.example.util.HttpUtil;
import com.example.util.JsonUtil;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;





public class WeatherActivity extends Activity {
	private ImageButton mylocationiImageButton;
	 public LocationClient locationClient=null;
	 public BDLocationListener bdLocationListener=new MyLocationListener();
     

	 
 private TextView citytextView;
 private ImageButton backButton;
 private ImageButton forwardButton;
 private ImageButton voiceButton;
 private TextView publishtimetTextView;
 private TextView airqualtytTextView;
 private TextView nowtmpTextView;
 private TextView weatherstatetTextView;
 private TextView windnumberTextView;
 
 private ImageView todayiImageView;
 private TextView todaytemprangeTextView;
 private ImageView tomorrowImageView;
 private TextView tomorrowtemprangetTextView;
 
 private TextView temp10tTextView;
 private TextView dir10textView;
 private TextView text10tTextView;
 
 private TextView temp13tTextView;
 private TextView dir13textView;
 private TextView text13tTextView;
 
 private TextView temp16tTextView;
 private TextView dir16textView;
 private TextView text16tTextView;
 
 private TextView temp19tTextView;
 private TextView dir19textView;
 private TextView text19tTextView;
 
 private TextView temp22tTextView;
 private TextView dir22textView;
 private TextView text22tTextView;
 
 private TextView sunriseTextView;
 private TextView humtTextView; 
 private TextView presTextView;
 private TextView sunsetTextView;
 private TextView flTextView;
 private TextView visTextView;
 
 private TextView monforeTextView;
 private ImageView monImageView;
 private TextView monweathertTextView;
 private TextView monrangeTextView;
 
 private TextView tueforeTextView;
 private ImageView tueImageView;
 private TextView tueweathertTextView;
 private TextView tuerangeTextView;
 
 private TextView wedforeTextView;
 private ImageView wedImageView;
 private TextView wedweathertTextView;
 private TextView wedrangeTextView;
 
 private TextView thuforeTextView;
 private ImageView thuImageView;
 private TextView thuweathertTextView;
 private TextView thurangeTextView;
 
 private TextView friforeTextView;
 private ImageView friImageView;
 private TextView friweathertTextView;
 private TextView frirangeTextView;
 
 private TextView satforeTextView;
 private ImageView satImageView;
 private TextView satweathertTextView;
 private TextView satrangeTextView;
 
 private TextView sunforeTextView;
 private ImageView sunImageView;
 private TextView sunweathertTextView;
 private TextView sunrangeTextView;
 
 private TextView coldbrftTextView;
 private TextView coldtextTextView;
 
 private TextView comforbrftTextView;
 private TextView comfortextTextView;
 
 private TextView dressbrftTextView;
 private TextView dresstextTextView;
 
 private TextView sportbrftTextView;
 private TextView sporttextTextView;
 
 private TextView uvbrftTextView;
 private TextView uvtextTextView;
 
 private TextView washbrftTextView;
 private TextView washtextTextView;
 
 private TextView travebrftTextView;
 private TextView travetextTextView;
 
 private LinearLayout linearLayout10;
 private LinearLayout linearLayout13;
 private LinearLayout linearLayout16;
 private LinearLayout linearLayout19;
 private LinearLayout linearLayout22;
 

 

 private ImageView mycoldTextView;
 private ImageView mycomforTextView;
 private ImageView mydressTextView;
 private ImageView mysportTextView;
 private ImageView mytraveTextView;
 private ImageView myuvTextView;
 private ImageView mywashTextView;
 

 


 
 

  @Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.weather);
	SpeechUtility.createUtility(WeatherActivity.this, SpeechConstant.APPID +"=56c9633f ");   
	
	
	
	 locationClient=new LocationClient(getApplicationContext());
	 locationClient.registerLocationListener(bdLocationListener);
	 initLocation();
	 locationClient.start();
	 
	 
	
	 
	 
	   
	 
	 
	initview();
			
    final String myurl2=getIntent().getStringExtra("myurl2");
    new Thread(new Runnable() {
		
		@Override
		public void run() {
			String jsontext=HttpUtil.getjsontext(myurl2);
		  BasicBean basicBean=BeanUtil.getBasicBean(jsontext);
		  AqiBean aqiBean=BeanUtil.getAqiBean(jsontext);
		  ArrayList<DailyBean> dailyBeans=BeanUtil.getDailyBean(jsontext);
		 ArrayList<HourlyBean> hourlyBeans=BeanUtil.getHourlyBean(jsontext);
		  NowBean nowBean=BeanUtil.getNowBean(jsontext);
		  BrfBean brfBean=JsonUtil.getBrfBeans(jsontext);
		  TxtBean txtBean=JsonUtil.getTxtBeans(jsontext);

	
		  Bitmap todaybitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(0).getCode_d()+".png");
		  Bitmap tomorrowbitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(1).getCode_d()+".png");
		  Bitmap wedBitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(2).getCode_d()+".png");
		  Bitmap thuBitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(3).getCode_d()+".png");
		  Bitmap friBitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(4).getCode_d()+".png");
		  Bitmap satBitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(5).getCode_d()+".png");
		  Bitmap sunBitmap=JsonUtil.getBitmapfromUrl("http://files.heweather.com/cond_icon/"+ dailyBeans.get(6).getCode_d()+".png");
		 
		  
		  
		  
		 Bundle bundle=new Bundle();
		 bundle.putParcelable("today",todaybitmap);
		 bundle.putParcelable("tomorrow",tomorrowbitmap);
		 bundle.putParcelable("wed",wedBitmap);
		 bundle.putParcelable("thu", thuBitmap);
		 bundle.putParcelable("fri",friBitmap);
		 bundle.putParcelable("sat",satBitmap);
		 bundle.putParcelable("sun",sunBitmap);
		
		 
		 bundle.putParcelable("basic", basicBean);
		 bundle.putParcelable("aqi",aqiBean);
		 bundle.putParcelableArrayList("daily",dailyBeans);
		 bundle.putParcelableArrayList("hourly",hourlyBeans);
		 bundle.putParcelable("now",nowBean);
		 bundle.putParcelable("brf",brfBean);
		 bundle.putParcelable("txt",txtBean);
		 Message message=new Message();
		 message.what=01;
		 
		 message.setData(bundle);
		 handler.sendMessage(message);
		 
			
		}
	}).start();

   }
 

 

  
private  Handler handler=new Handler()
{
	public void handleMessage(android.os.Message msg)
	{
		switch (msg.what) {
		case 01:
		final BasicBean mBasicBean=msg.getData().getParcelable("basic");
		AqiBean mAqiBean=msg.getData().getParcelable("aqi");
		final ArrayList<DailyBean> mDailyBeans=msg.getData().getParcelableArrayList("daily");
		ArrayList<HourlyBean> mHourlyBeans=msg.getData().getParcelableArrayList("hourly");
		NowBean mNowBean=msg.getData().getParcelable("now");
		BrfBean mBrfBean=msg.getData().getParcelable("brf");
		TxtBean mTxtBean=msg.getData().getParcelable("txt");
		
		final Bitmap bitmap1=msg.getData().getParcelable("today");
		todayiImageView.setImageBitmap(bitmap1);
		monImageView.setImageBitmap(bitmap1);
		
		Bitmap bitmap2=msg.getData().getParcelable("tomorrow");
		tomorrowImageView.setImageBitmap(bitmap2);
		tueImageView.setImageBitmap(bitmap2);
		
		Bitmap bitmap3=msg.getData().getParcelable("wed");
		wedImageView.setImageBitmap(bitmap3);
		
		Bitmap bitmap4=msg.getData().getParcelable("thu");
		thuImageView.setImageBitmap(bitmap4);
		
		Bitmap bitmap5=msg.getData().getParcelable("fri");
		friImageView.setImageBitmap(bitmap5);
		
		Bitmap bitmap6=msg.getData().getParcelable("sat");
		satImageView.setImageBitmap(bitmap6);
		
		Bitmap bitmap7=msg.getData().getParcelable("sun");
		sunImageView.setImageBitmap(bitmap7);
		
		
		
		
		citytextView.setText(mBasicBean.getCity());
		
		
		
		publishtimetTextView.setText(mBasicBean.getLoc().substring(mBasicBean.getLoc().indexOf(' ')).replaceAll(" ","")+ "����");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date=new Date(System.currentTimeMillis());
		String nowdate= simpleDateFormat.format(date);
			/*try
			{
				long diff=(simpleDateFormat.parse(nowdate).getTime()-simpleDateFormat.parse(mBasicBean.getLoc()).getTime())/1000/60;
				
				publishtimetTextView.setText(diff + "����ǰ����");
			} 
			catch (ParseException e)
			{
				
				e.printStackTrace();
			}*/
		if (mAqiBean!=null) {
			airqualtytTextView.setText(mAqiBean.getQlty());
		}
		else {
			airqualtytTextView.setVisibility(View.GONE);
		}
		
	    nowtmpTextView.setText(mNowBean.getTmp()+"��");
	    weatherstatetTextView.setText(mNowBean.getTxt());
	    windnumberTextView.setText(mNowBean.getSpd()+"��");
	    
	   sunriseTextView.setText(mDailyBeans.get(0).getSr());
	   humtTextView.setText(mNowBean.getHum());
	   presTextView.setText(mNowBean.getPres());
	   sunsetTextView.setText(mDailyBeans.get(0).getSs());
	   flTextView.setText(mNowBean.getFl());
	   visTextView.setText(mNowBean.getVis());
	   
	  
		if (mBrfBean!=null && mTxtBean!=null)
		{
			comforbrftTextView.setText(mBrfBean.getComfbrf());
			   comfortextTextView.setText(mTxtBean.getComftxt());
			   dressbrftTextView.setText(mBrfBean.getDrsgbrf());
			   dresstextTextView.setText(mTxtBean.getDrsgtxt());
			   uvbrftTextView.setText(mBrfBean.getUvbrf());
			   uvtextTextView.setText(mTxtBean.getUvtxt());
			   sportbrftTextView.setText(mBrfBean.getSportbrf());
			   sporttextTextView.setText(mTxtBean.getSporttxt());
			   travebrftTextView.setText(mBrfBean.getTravbrf());
			   travetextTextView.setText(mTxtBean.getTravtxt());
			   washbrftTextView.setText(mBrfBean.getCwbrf());
			   washtextTextView.setText(mTxtBean.getCwtxt());
			   coldbrftTextView.setText(mBrfBean.getFlubrf());
			   coldtextTextView.setText(mTxtBean.getFlutxt());
			 }
		
		   
		   

	   
	    
   	
	String todayrange=mDailyBeans.get(0).getMin()+"~"+mDailyBeans.get(0).getMax()+"��";
	String tomorrowrange=mDailyBeans.get(1).getMin()+"~"+mDailyBeans.get(1).getMax()+"��";
	todaytemprangeTextView.setText(todayrange);
	tomorrowtemprangetTextView.setText(tomorrowrange);
	
	String []monstr=mDailyBeans.get(0).getDate().split("-");
	if (monstr[1].startsWith("0")) {
		 int m=monstr[1].indexOf("0");
		 monforeTextView.setText(monstr[1].substring(m+1)+"/"+monstr[2]);
	}else {
		monforeTextView.setText(monstr[1]+"/"+monstr[2]);
	}
	
	
	if (mDailyBeans.get(0).getTxt_d().equals(mDailyBeans.get(0).getTxt_n())) {
		monweathertTextView.setText(mDailyBeans.get(0).getTxt_d());
	}
	else {
		monweathertTextView.setText(mDailyBeans.get(0).getTxt_d()+"ת"+mDailyBeans.get(0).getTxt_n());
	}
	monrangeTextView.setText(todayrange);
	
	String []tuestr=mDailyBeans.get(1).getDate().split("-");
	if (tuestr[1].startsWith("0")) {
		 int m1=tuestr[1].indexOf("0");
		 tueforeTextView.setText(tuestr[1].substring(m1+1)+"/"+tuestr[2]);
	}else {
		tueforeTextView.setText(tuestr[1]+"/"+tuestr[2]);
	}
	if (mDailyBeans.get(1).getTxt_d().equals(mDailyBeans.get(1).getTxt_n())) {
		tueweathertTextView.setText(mDailyBeans.get(1).getTxt_d());
	}
	else {
		tueweathertTextView.setText(mDailyBeans.get(1).getTxt_d()+"ת"+mDailyBeans.get(1).getTxt_n());
	}
	tuerangeTextView.setText(tomorrowrange);
	
	String []wedstr=mDailyBeans.get(2).getDate().split("-");
	if (wedstr[1].startsWith("0")) {
		 int m2=wedstr[1].indexOf("0");
		 wedforeTextView.setText(wedstr[1].substring(m2+1)+"/"+wedstr[2]);
	}else {
		wedforeTextView.setText(wedstr[1]+"/"+wedstr[2]);
	}
	if (mDailyBeans.get(2).getTxt_d().equals(mDailyBeans.get(2).getTxt_n())) {
		wedweathertTextView.setText(mDailyBeans.get(2).getTxt_d());
	}
	else {
		wedweathertTextView.setText(mDailyBeans.get(2).getTxt_d()+"ת"+mDailyBeans.get(2).getTxt_n());
	}
	wedrangeTextView.setText(mDailyBeans.get(2).getMin()+"~"+mDailyBeans.get(2).getMax()+"��");
	
	String []thustr=mDailyBeans.get(3).getDate().split("-");
	if (thustr[1].startsWith("0")) {
		 int m3=thustr[1].indexOf("0");
		 thuforeTextView.setText(thustr[1].substring(m3+1)+"/"+thustr[2]);
	}else {
		thuforeTextView.setText(thustr[1]+"/"+thustr[2]);
	}
	if (mDailyBeans.get(3).getTxt_d().equals(mDailyBeans.get(3).getTxt_n())) {
		thuweathertTextView.setText(mDailyBeans.get(3).getTxt_d());
	}
	else {
		thuweathertTextView.setText(mDailyBeans.get(3).getTxt_d()+"ת"+mDailyBeans.get(3).getTxt_n());
	}
	thurangeTextView.setText(mDailyBeans.get(3).getMin()+"~"+mDailyBeans.get(3).getMax()+"��");
	
	String []fristr=mDailyBeans.get(4).getDate().split("-");
	if (fristr[1].startsWith("0")) {
		 int m4=fristr[1].indexOf("0");
		 friforeTextView.setText(fristr[1].substring(m4+1)+"/"+fristr[2]);
	}else {
		friforeTextView.setText(fristr[1]+"/"+fristr[2]);
	}
	if (mDailyBeans.get(4).getTxt_d().equals(mDailyBeans.get(4).getTxt_n())) {
		friweathertTextView.setText(mDailyBeans.get(4).getTxt_d());
	}
	else {
		friweathertTextView.setText(mDailyBeans.get(4).getTxt_d()+"ת"+mDailyBeans.get(4).getTxt_n());
	}
	frirangeTextView.setText(mDailyBeans.get(4).getMin()+"~"+mDailyBeans.get(4).getMax()+"��");
    
	String []satstr=mDailyBeans.get(5).getDate().split("-");
	if (satstr[1].startsWith("0")) {
		 int m5=satstr[1].indexOf("0");
		 satforeTextView.setText(satstr[1].substring(m5+1)+"/"+satstr[2]);
	}else {
		satforeTextView.setText(satstr[1]+"/"+satstr[2]);
	}
	if (mDailyBeans.get(5).getTxt_d().equals(mDailyBeans.get(5).getTxt_n())) {
		satweathertTextView.setText(mDailyBeans.get(5).getTxt_d());
	}
	else {
		satweathertTextView.setText(mDailyBeans.get(5).getTxt_d()+"ת"+mDailyBeans.get(5).getTxt_n());
	}
	satrangeTextView.setText(mDailyBeans.get(5).getMin()+"~"+mDailyBeans.get(5).getMax()+"��");
	
	String []sunstr=mDailyBeans.get(6).getDate().split("-");
	if (sunstr[1].startsWith("0")) {
		 int m6=sunstr[1].indexOf("0");
		 sunforeTextView.setText(sunstr[1].substring(m6+1)+"/"+sunstr[2]);
	}else {
		sunforeTextView.setText(sunstr[1]+"/"+sunstr[2]);
	}
	if (mDailyBeans.get(6).getTxt_d().equals(mDailyBeans.get(6).getTxt_n())) {
		sunweathertTextView.setText(mDailyBeans.get(6).getTxt_d());
	}
	else {
		sunweathertTextView.setText(mDailyBeans.get(6).getTxt_d()+"ת"+mDailyBeans.get(6).getTxt_n());
	}
	sunrangeTextView.setText(mDailyBeans.get(6).getMin()+"~"+mDailyBeans.get(6).getMax()+"��");
    

	
	
	if (mHourlyBeans.size()==5) {
		temp10tTextView.setText(mHourlyBeans.get(0).getDate().substring(mHourlyBeans.get(0).getDate().indexOf(' ')));
		text10tTextView.setText(mHourlyBeans.get(0).getTmp()+"��");
		dir10textView.setText(mHourlyBeans.get(0).getDir());
		
		temp13tTextView.setText(mHourlyBeans.get(1).getDate().substring(mHourlyBeans.get(1).getDate().indexOf(' ')));
		text13tTextView.setText(mHourlyBeans.get(1).getTmp()+"��");
		dir13textView.setText(mHourlyBeans.get(1).getDir());
		
		temp16tTextView.setText(mHourlyBeans.get(2).getDate().substring(mHourlyBeans.get(2).getDate().indexOf(' ')));
		text16tTextView.setText(mHourlyBeans.get(2).getTmp()+"��");
		dir16textView.setText(mHourlyBeans.get(2).getDir());
		
		temp19tTextView.setText(mHourlyBeans.get(3).getDate().substring(mHourlyBeans.get(3).getDate().indexOf(' ')));
		text19tTextView.setText(mHourlyBeans.get(3).getTmp()+"��");
		dir19textView.setText(mHourlyBeans.get(3).getDir());
		
		temp22tTextView.setText(mHourlyBeans.get(4).getDate().substring(mHourlyBeans.get(4).getDate().indexOf(' ')));
		text22tTextView.setText(mHourlyBeans.get(4).getTmp()+"��");
		dir22textView.setText(mHourlyBeans.get(4).getDir());
	}
	else if (mHourlyBeans.size()==4) {
		linearLayout10.setVisibility(View.GONE);
		temp13tTextView.setText(mHourlyBeans.get(0).getDate().substring(mHourlyBeans.get(0).getDate().indexOf(' ')));
		text13tTextView.setText(mHourlyBeans.get(0).getTmp()+"��");
		dir13textView.setText(mHourlyBeans.get(0).getDir());
		
	
		
		temp16tTextView.setText(mHourlyBeans.get(1).getDate().substring(mHourlyBeans.get(1).getDate().indexOf(' ')));
		text16tTextView.setText(mHourlyBeans.get(1).getTmp()+"��");
		dir16textView.setText(mHourlyBeans.get(1).getDir());
		
		temp19tTextView.setText(mHourlyBeans.get(2).getDate().substring(mHourlyBeans.get(2).getDate().indexOf(' ')));
		text19tTextView.setText(mHourlyBeans.get(2).getTmp()+"��");
		dir19textView.setText(mHourlyBeans.get(2).getDir());
		
		temp22tTextView.setText(mHourlyBeans.get(3).getDate().substring(mHourlyBeans.get(3).getDate().indexOf(' ')));
		text22tTextView.setText(mHourlyBeans.get(3).getTmp()+"��");
		dir22textView.setText(mHourlyBeans.get(3).getDir());
	}
	else if (mHourlyBeans.size()==3) {
		linearLayout10.setVisibility(View.GONE);
		linearLayout13.setVisibility(View.GONE);
		temp16tTextView.setText(mHourlyBeans.get(0).getDate().substring(mHourlyBeans.get(0).getDate().indexOf(' ')));
		text16tTextView.setText(mHourlyBeans.get(0).getTmp()+"��");
		dir16textView.setText(mHourlyBeans.get(0).getDir());
		
		temp19tTextView.setText(mHourlyBeans.get(1).getDate().substring(mHourlyBeans.get(1).getDate().indexOf(' ')));
		text19tTextView.setText(mHourlyBeans.get(1).getTmp()+"��");
		dir19textView.setText(mHourlyBeans.get(1).getDir());
		
		temp22tTextView.setText(mHourlyBeans.get(2).getDate().substring(mHourlyBeans.get(2).getDate().indexOf(' ')));
		text22tTextView.setText(mHourlyBeans.get(2).getTmp()+"��");
		dir22textView.setText(mHourlyBeans.get(2).getDir());
	}
	else if (mHourlyBeans.size()==2) {
		linearLayout10.setVisibility(View.GONE);
		linearLayout13.setVisibility(View.GONE);
		linearLayout16.setVisibility(View.GONE);
		temp19tTextView.setText(mHourlyBeans.get(0).getDate().substring(mHourlyBeans.get(0).getDate().indexOf(' ')));
		text19tTextView.setText(mHourlyBeans.get(0).getTmp()+"��");
		dir19textView.setText(mHourlyBeans.get(0).getDir());
		
		temp22tTextView.setText(mHourlyBeans.get(1).getDate().substring(mHourlyBeans.get(1).getDate().indexOf(' ')));
		text22tTextView.setText(mHourlyBeans.get(1).getTmp()+"��");
		dir22textView.setText(mHourlyBeans.get(1).getDir());
	}
	else if (mHourlyBeans.size()==1) {
		linearLayout10.setVisibility(View.GONE);
		linearLayout13.setVisibility(View.GONE);
		linearLayout16.setVisibility(View.GONE);
		linearLayout19.setVisibility(View.GONE);
		temp22tTextView.setText(mHourlyBeans.get(0).getDate().substring(mHourlyBeans.get(0).getDate().indexOf(' ')));
		text22tTextView.setText(mHourlyBeans.get(0).getTmp()+"��");
		dir22textView.setText(mHourlyBeans.get(0).getDir());
	}
	else if(mHourlyBeans.size()==0){
		linearLayout10.setVisibility(View.GONE);
		linearLayout13.setVisibility(View.GONE);
		linearLayout16.setVisibility(View.GONE);
		linearLayout19.setVisibility(View.GONE);
		linearLayout22.setVisibility(View.GONE);
	}
	
	/*NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    Notification.Builder builder=new Notification.Builder(WeatherActivity.this);
   builder.setSmallIcon(R.drawable.ic_launcher);
   builder.setWhen(System.currentTimeMillis());
   builder.setContentTitle(mBasicBean.getCity()+"����");
   StringBuilder stringBuilder=new StringBuilder();
   stringBuilder.append(mBasicBean.getCity());
   stringBuilder.append(",");
   if (mDailyBeans.get(0).getTxt_d().equals(mDailyBeans.get(0).getTxt_n()))
   {
	   stringBuilder.append("����"+mDailyBeans.get(0).getTxt_d());
   }
   else
   {
	   stringBuilder.append("����"+mDailyBeans.get(0).getTxt_d()+"ת"+mDailyBeans.get(0).getTxt_n());
   }
   stringBuilder.append(",");
   stringBuilder.append(mDailyBeans.get(0).getMin()+"~"+mDailyBeans.get(0).getMax()+"��");
   stringBuilder.append("��");
   builder.setContentText(stringBuilder.toString());
   builder.setAutoCancel(true);
   builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
   builder.setLargeIcon(bitmap1);
   Notification notification=builder.build();
   notificationManager.notify(0, notification);*/
	
  backButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
   
		finish();
		
		

		
	}
});
  
  
  

  forwardButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent forwardintent=new Intent(WeatherActivity.this,SettingActivity.class);
			Bundle bundle3=new Bundle();
	         bundle3.putParcelable("forecast1", mBasicBean);
	         bundle3.putParcelableArrayList("forecast2",mDailyBeans);
	         bundle3.putParcelable("forecast3",bitmap1);
	         

	         forwardintent.putExtras(bundle3);
           
	         
	      
	         
			startActivity(forwardintent);
			
		}
	});
  
  
  
	 

  
  
  
 
	  
	
   
	  
	  
	 
	  
    
   final StringBuilder voiceStringBuilder=new StringBuilder();
   if (date.getHours()==0) {
	  voiceStringBuilder.append("��ҹ��");
    }
   else if(date.getHours()>0 && date.getHours()<=5) {
	   voiceStringBuilder.append("�賿��");
   }
   else  if(date.getHours()>5 && date.getHours()<=11) {
	   voiceStringBuilder.append("�����");
   }
   else  if(date.getHours()==12) {
	   voiceStringBuilder.append("�����");
   }
   else  if(date.getHours()>12 && date.getHours()<=18) {
	   voiceStringBuilder.append("�����");
   }
   else  if(date.getHours()>18 && date.getHours()<=21) {
	   voiceStringBuilder.append("���Ϻ�");
   }
   else  if(date.getHours()>21 && date.getHours()<=23) {
	   voiceStringBuilder.append("��ҹ��");
   }
   else if (date.getHours()==24) {
	   voiceStringBuilder.append("��ҹ��");
}
   
   
   voiceStringBuilder.append("����ʱ����:");
   voiceStringBuilder.append(nowdate.substring(nowdate.indexOf(' ')));
   
   
   
	 
	  
   voiceStringBuilder.append("�������:");
   voiceStringBuilder.append(mDailyBeans.get(0).getTxt_d());
   voiceStringBuilder.append("����¶�:");
 voiceStringBuilder.append(mDailyBeans.get(0).getMax()+"���϶�");
 voiceStringBuilder.append("����ҹ��:");
 voiceStringBuilder.append(mDailyBeans.get(0).getTxt_n());
 voiceStringBuilder.append("����¶�:");
 voiceStringBuilder.append(mDailyBeans.get(0).getMin()+"���϶�");
 
   voiceButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		 SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer(WeatherActivity.this, null);  
		  mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//���÷�����  
		  mTts.setParameter(SpeechConstant.SPEED, "20");//��������  
		  mTts.setParameter(SpeechConstant.VOLUME, "80");//������������Χ0~100  
		  mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //�����ƶ� 
		  mTts.startSpeaking(voiceStringBuilder.toString(), mSynListener);  
		
	}
});
   
   

       
       
   
   
   
  
	 	         
	 	      
			break;

		default:
			break;
		}
	}
};

  public void initview()
  {
	  citytextView=(TextView)findViewById(R.id.city);
	  backButton=(ImageButton)findViewById(R.id.back);
	  forwardButton=(ImageButton)findViewById(R.id.forward);
	  publishtimetTextView=(TextView)findViewById(R.id.publishtime);
	  airqualtytTextView=(TextView)findViewById(R.id.airquality);
	  nowtmpTextView=(TextView)findViewById(R.id.nowtmp);
	  weatherstatetTextView=(TextView)findViewById(R.id.weatherstate);
	  windnumberTextView=(TextView)findViewById(R.id.windnumber);
	  
	  todayiImageView=(ImageView)findViewById(R.id.today);
	  todaytemprangeTextView=(TextView)findViewById(R.id.todaytemprange);
      tomorrowImageView=(ImageView)findViewById(R.id.tomorrow);
      tomorrowtemprangetTextView=(TextView)findViewById(R.id.tomorrowtemprange);
	  
	  temp10tTextView=(TextView)findViewById(R.id.temp10);
	  dir10textView=(TextView)findViewById(R.id.dir10);
	  text10tTextView=(TextView)findViewById(R.id.text10);
	  
	  temp13tTextView=(TextView)findViewById(R.id.temp13);
	  dir13textView=(TextView)findViewById(R.id.dir13);
	  text13tTextView=(TextView)findViewById(R.id.text13);
	  
	  temp16tTextView=(TextView)findViewById(R.id.temp16);
	  dir16textView=(TextView)findViewById(R.id.dir16);
	  text16tTextView=(TextView)findViewById(R.id.text16);
	  
	  temp19tTextView=(TextView)findViewById(R.id.temp19);
	  dir19textView =(TextView)findViewById(R.id.dir19);
	  text19tTextView=(TextView)findViewById(R.id.text19);
	  
	  temp22tTextView=(TextView)findViewById(R.id.temp22);
	  dir22textView=(TextView)findViewById(R.id.dir22);
	  text22tTextView=(TextView)findViewById(R.id.text22);
	  
	  sunriseTextView=(TextView)findViewById(R.id.sunrise);
	  humtTextView=(TextView)findViewById(R.id.hum);
	  presTextView=(TextView)findViewById(R.id.pres);
	  sunsetTextView=(TextView)findViewById(R.id.sunset);
	  flTextView=(TextView)findViewById(R.id.fl);
	  visTextView=(TextView)findViewById(R.id.vis);
	  
	  monforeTextView=(TextView)findViewById(R.id.monfore);
	  monImageView=(ImageView)findViewById(R.id.monimage);
	  monweathertTextView=(TextView)findViewById(R.id.monweather);
	  monrangeTextView=(TextView)findViewById(R.id.monrange);
	  
	  
	  tueforeTextView=(TextView)findViewById(R.id.tuefore);
	  tueImageView=(ImageView)findViewById(R.id.tueimage);
	  tueweathertTextView=(TextView)findViewById(R.id.tueweather);
	  tuerangeTextView=(TextView)findViewById(R.id.tuerange);
	  
	  
	  wedforeTextView=(TextView)findViewById(R.id.wedfore);
	  wedImageView=(ImageView)findViewById(R.id.wedimage);
	  wedweathertTextView=(TextView)findViewById(R.id.wedweather);
	  wedrangeTextView=(TextView)findViewById(R.id.wedrange);
	  
	  
	  thuforeTextView=(TextView)findViewById(R.id.thufore);
	  thuImageView=(ImageView)findViewById(R.id.thuimage);
	  thuweathertTextView=(TextView)findViewById(R.id.thuweather);
	  thurangeTextView=(TextView)findViewById(R.id.thurange);
	  
	  
	  friforeTextView=(TextView)findViewById(R.id.frifore);
	  friImageView=(ImageView)findViewById(R.id.friimage);
	  friweathertTextView=(TextView)findViewById(R.id.friweather);
	  frirangeTextView=(TextView)findViewById(R.id.frirange);
	  
	  
	  satforeTextView=(TextView)findViewById(R.id.satfore);
	  satImageView=(ImageView)findViewById(R.id.satimage);
	  satweathertTextView=(TextView)findViewById(R.id.satweather);
	  satrangeTextView=(TextView)findViewById(R.id.satrange);
	  
	  
	  sunforeTextView=(TextView)findViewById(R.id.sunfore);
	  sunImageView=(ImageView)findViewById(R.id.sunimage);
	  sunweathertTextView=(TextView)findViewById(R.id.sunweather);
	  sunrangeTextView=(TextView)findViewById(R.id.sunrange);
	  
	  coldbrftTextView=(TextView)findViewById(R.id.coldbrf);
	  coldtextTextView=(TextView)findViewById(R.id.coldtext);
	  
	  comforbrftTextView=(TextView)findViewById(R.id.comforbrf);
	  comfortextTextView=(TextView)findViewById(R.id.comfortext);
	  
	  dressbrftTextView=(TextView)findViewById(R.id.dressbrf);
	  dresstextTextView=(TextView)findViewById(R.id.dresstext);
	  
	  sportbrftTextView=(TextView)findViewById(R.id.sportbrf);
	  sporttextTextView=(TextView)findViewById(R.id.sporttext);
	  
	  travebrftTextView=(TextView)findViewById(R.id.travebrf);
	  travetextTextView=(TextView)findViewById(R.id.travetext);
	  
	  uvbrftTextView=(TextView)findViewById(R.id.uvbrf);
	  uvtextTextView=(TextView)findViewById(R.id.uvtext);
	  
	  washbrftTextView=(TextView)findViewById(R.id.washbrf);
	  washtextTextView=(TextView)findViewById(R.id.washtext);
	  
	  linearLayout10=(LinearLayout)findViewById(R.id.linear10);
	  linearLayout13=(LinearLayout)findViewById(R.id.linear13);
	  linearLayout16=(LinearLayout)findViewById(R.id.linear16);
	  linearLayout19=(LinearLayout)findViewById(R.id.linear19);
	  linearLayout22=(LinearLayout)findViewById(R.id.linear22);
	  
	  
	  mylocationiImageButton=(ImageButton)findViewById(R.id.mylocation);
	  voiceButton=(ImageButton)findViewById(R.id.myvoice);
	  
	  mycoldTextView=(ImageView)findViewById(R.id.coldimage);
	  mycomforTextView=(ImageView)findViewById(R.id.comforimage);
	  mydressTextView=(ImageView)findViewById(R.id.dressimage);
	  mywashTextView=(ImageView)findViewById(R.id.washimage);
	  mysportTextView=(ImageView)findViewById(R.id.sportimage);
	  mytraveTextView=(ImageView)findViewById(R.id.traveimage);
	  myuvTextView=(ImageView)findViewById(R.id.uvimage);
	  
	 
	 
	
  }
  
  
  
  @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		locationClient.stop();
		
		
	}


   
	
  
  
  
  
 
  
  
  
  
  
  
  
 
  
  
  private SynthesizerListener mSynListener = new SynthesizerListener()
  {

	@Override
	public void onBufferProgress(int arg0, int arg1, int arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCompleted(SpeechError arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpeakBegin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpeakPaused() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpeakProgress(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpeakResumed() {
		// TODO Auto-generated method stub
		
	}
	  
  };
  
  
  
  
  
  
  

  
 
  
 

  
  private void initLocation(){
      LocationClientOption option = new LocationClientOption();
      option.setLocationMode(LocationMode.Hight_Accuracy);
      option.setCoorType("bd09ll");//��ѡ��Ĭ��gcj02�����÷��صĶ�λ������ϵ
      int span=1000;
      option.setScanSpan(span);//��ѡ��Ĭ��0��������λһ�Σ����÷���λ����ļ����Ҫ���ڵ���1000ms������Ч��
      option.setIsNeedAddress(true);//��ѡ�������Ƿ���Ҫ��ַ��Ϣ��Ĭ�ϲ���Ҫ
      option.setOpenGps(true);//��ѡ��Ĭ��false,�����Ƿ�ʹ��gps
      option.setLocationNotify(true);//��ѡ��Ĭ��false�������Ƿ�gps��Чʱ����1S1��Ƶ�����GPS���
      option.setIsNeedLocationDescribe(true);//��ѡ��Ĭ��false�������Ƿ���Ҫλ�����廯��������BDLocation.getLocationDescribe��õ�����������ڡ��ڱ����찲�Ÿ���
      option.setIsNeedLocationPoiList(true);//��ѡ��Ĭ��false�������Ƿ���ҪPOI��������BDLocation.getPoiList��õ�
option.setIgnoreKillProcess(false);//��ѡ��Ĭ��false����λSDK�ڲ���һ��SERVICE�����ŵ��˶�����̣������Ƿ���stop��ʱ��ɱ�������̣�Ĭ��ɱ��
      option.SetIgnoreCacheException(false);//��ѡ��Ĭ��false�������Ƿ��ռ�CRASH��Ϣ��Ĭ���ռ�
option.setEnableSimulateGps(false);//��ѡ��Ĭ��false�������Ƿ���Ҫ����gps������Ĭ����Ҫ
      locationClient.setLocOption(option);
  }
  


class MyLocationListener implements BDLocationListener 
	{
		
		  @Override
	      public void onReceiveLocation(final BDLocation location)
		  {
	          //Receive Location
	          StringBuffer sb = new StringBuffer(256);
	          sb.append("time : ");
	          sb.append(location.getTime());
	          sb.append("\nerror code : ");
	          sb.append(location.getLocType());
	          sb.append("\nlatitude : ");
	          sb.append(location.getLatitude());
	          sb.append("\nlontitude : ");
	          sb.append(location.getLongitude());
	          sb.append("\nradius : ");
	          sb.append(location.getRadius());
	          if (location.getLocType() == BDLocation.TypeGpsLocation)
	          {
	              sb.append("\nspeed : ");
	              sb.append(location.getSpeed());// ��λ������ÿСʱ
	              sb.append("\nsatellite : ");
	              sb.append(location.getSatelliteNumber());
	              sb.append("\nheight : ");
	              sb.append(location.getAltitude());// ��λ����
	              sb.append("\ndirection : ");
	              sb.append(location.getDirection());// ��λ��
	              sb.append("\naddr : ");
	              sb.append(location.getAddrStr());
	              sb.append("\ndescribe : ");
	              sb.append("gps��λ�ɹ�");

	          } 
	          else if (location.getLocType() == BDLocation.TypeNetWorkLocation)
	          {// ���綨λ���
	              sb.append("\naddr : ");
	              sb.append(location.getAddrStr());
	              //��Ӫ����Ϣ
	              sb.append("\noperationers : ");
	              sb.append(location.getOperators());
	              sb.append("\ndescribe : ");
	              sb.append("���綨λ�ɹ�");
	          }
	          else if (location.getLocType() == BDLocation.TypeOffLineLocation)
	          {// ���߶�λ���
	              sb.append("\ndescribe : ");
	              sb.append("���߶�λ�ɹ������߶�λ���Ҳ����Ч��");
	          }
	          else if (location.getLocType() == BDLocation.TypeServerError)
	          {
	              sb.append("\ndescribe : ");
	              sb.append("��������綨λʧ�ܣ����Է���IMEI�źʹ��嶨λʱ�䵽loc-bugs@baidu.com��������׷��ԭ��");
	          }
	          else if (location.getLocType() == BDLocation.TypeNetWorkException)
	          {
	              sb.append("\ndescribe : ");
	              sb.append("���粻ͬ���¶�λʧ�ܣ����������Ƿ�ͨ��");
	          }
	          else if (location.getLocType() == BDLocation.TypeCriteriaException)
	          {
	              sb.append("\ndescribe : ");
	              sb.append("�޷���ȡ��Ч��λ���ݵ��¶�λʧ�ܣ�һ���������ֻ��ԭ�򣬴��ڷ���ģʽ��һ���������ֽ��������������ֻ�");
	          }
	         sb.append("\nlocationdescribe : ");
	              sb.append(location.getLocationDescribe());// λ�����廯��Ϣ
	              List<Poi> list = location.getPoiList();// POI���
	              if (list != null)
	              {
	                  sb.append("\npoilist size = : ");
	                     sb.append(list.size());
	                  for (Poi p : list)
	                  {
	                      sb.append("\npoi= : ");
	                      sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
	                  }
	              }
	              
	              mylocationiImageButton.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View view)
						{
	        Toast toast=Toast.makeText(WeatherActivity.this, location.getCity()+location.getDistrict(),Toast.LENGTH_LONG);
	         toast.setGravity(Gravity.CENTER, 0, 0);
	 		 toast.show();
	 		 
	  
							
						}
					});

	          
	      }
		  
	}  




	   
	   

  

	
	
	

}
