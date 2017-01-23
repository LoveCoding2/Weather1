package com.example.seeweather;

import java.util.ArrayList;




import com.example.bean.BasicBean;
import com.example.bean.DailyBean;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener,OnPreferenceClickListener
{
	private SwitchPreference vibratePreference;
	private SwitchPreference notificationpPreference;
	private SwitchPreference voicePreference;
	private Preference aboutPreference;
	
    


  @Override
protected void onCreate(Bundle savedInstanceState)
  {
	  final boolean iscustom=requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	super.onCreate(savedInstanceState);

	if (iscustom)
	{
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.mycategory);
	}
	TextView custonTextView=(TextView)findViewById(R.id.customsetting);
	custonTextView.setText("设置");
	custonTextView.setTextSize(20);
	ImageButton imageButton=(ImageButton)findViewById(R.id.mycategory);
	imageButton.setVisibility(View.VISIBLE);
	imageButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			finish();
			
		}
	});
	
	
	
	addPreferencesFromResource(R.xml.setting);
	
   
	
	
	
	initpreference();
  }
  
  
 
  
   @Override
	protected void onResume()
   {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences sharedPreferences=this.getPreferenceScreen().getSharedPreferences();
		sharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}
   
   @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}
   
   
   
   private void initpreference()
   {
	   vibratePreference=(SwitchPreference)findPreference("vibrate");
	   notificationpPreference=(SwitchPreference)findPreference("notification");
	   voicePreference=(SwitchPreference)findPreference("voice");
	   aboutPreference=(Preference)findPreference("about");
	   aboutPreference.setOnPreferenceClickListener(this);
	  
	   
   }
   
   
   
 



@Override
public boolean onPreferenceClick(Preference preference)
{
	if (preference.getKey().equals("about")) 
	{
		Intent aboutIntent=new Intent(SettingActivity.this,AboutActivity.class);
		startActivity(aboutIntent);
		
	}
	
			
			
			
			
	
	
	
	
	
	

	

	return false;
}





@Override
public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
		String key)
{
	Intent settingIntent=new Intent();
	if (key.equals("notification"))
	{
		//settingIntent.putExtra("notificationstate",notificationpPreference.isChecked());
        Bundle notifybundle=getIntent().getExtras();
        BasicBean notifyBasicBean=(BasicBean)notifybundle.get("forecast1");
        ArrayList<DailyBean> notifydailyBeans=(ArrayList<DailyBean>) notifybundle.get("forecast2");
        Bitmap notifyBitmap=(Bitmap) notifybundle.get("forecast3");
        
		if (notificationpPreference.isChecked())
		{
			NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		    Notification.Builder builder=new Notification.Builder(SettingActivity.this);
		   builder.setSmallIcon(R.drawable.ic_launcher);
		   builder.setWhen(System.currentTimeMillis());
		   builder.setContentTitle(notifyBasicBean.getCity()+"天气");
		   StringBuilder stringBuilder=new StringBuilder();
		   stringBuilder.append(notifyBasicBean.getCity());
		   stringBuilder.append(",");
		   if (notifydailyBeans.get(0).getTxt_d().equals(notifydailyBeans.get(0).getTxt_n()))
		   {
			   stringBuilder.append("今天"+notifydailyBeans.get(0).getTxt_d());
		   }
		   else
		   {
			   stringBuilder.append("今天"+notifydailyBeans.get(0).getTxt_d()+"转"+notifydailyBeans.get(0).getTxt_n());
		   }
		   stringBuilder.append(",");
		   stringBuilder.append(notifydailyBeans.get(0).getMin()+"~"+notifydailyBeans.get(0).getMax()+"°");
		   stringBuilder.append("。");
		   builder.setContentText(stringBuilder.toString());
		   builder.setAutoCancel(true);
		   builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
		   builder.setLargeIcon(notifyBitmap);
		   Notification notification=builder.build();
		   notificationManager.notify(0, notification);
			
		}
		else
		{
			NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			notificationManager.cancel(0);
			 
			/*PreferenceGroup preferenceGroup=(PreferenceGroup)findPreference("preferset");
			preferenceGroup.removePreference(vibratePreference);
			
			preferenceGroup.removePreference(voicePreference);*/
			
		}
		
	}
	if (key.equals("voice"))
	{
		AudioManager audioManager=(AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
		if (voicePreference.isChecked())
		{
			Log.i("s1", voicePreference.isChecked()+"");
			audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);  
		}
		else
		{
			Log.i("s2", voicePreference.isChecked()+"");
			 audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_LOWER ,AudioManager.FLAG_SHOW_UI);  
		}
		
		
		//Toast.makeText(SettingActivity.this, "点击语音", Toast.LENGTH_SHORT).show();
	}
    if (key.equals("vibrate"))
	{	
		Vibrator vibrator=(Vibrator) this.getSystemService(VIBRATOR_SERVICE);
		if (vibratePreference.isChecked())
		{

			 vibrator.vibrate(new long[] { 100, 100, 100, 1000 },-1);
		}
		else
		{
			vibrator.cancel();
		}
		
		
		//Toast.makeText(SettingActivity.this, "点击定位", Toast.LENGTH_SHORT).show();
	}
	
	
	
}
}
