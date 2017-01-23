package com.example.seeweather;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class SplashActivity extends Activity
{
  @Override
protected void onCreate(Bundle savedInstanceState) 
  {
	
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.splash);
    boolean mFirst = isFirstEnter(SplashActivity.this,SplashActivity.this.getClass().getName());
    if(mFirst)
    {
    	mHandler.sendEmptyMessageDelayed(SWITCH_GUIDACTIVITY,5000);
    }
        
    else
    {
    	mHandler.sendEmptyMessageDelayed(SWITCH_MAINACTIVITY,5000);
    }
    	
  }
  
  private static final String SHAREDPREFERENCES_NAME = "my_pref";
  private static final String KEY_GUIDE_ACTIVITY = "guide_activity";
  private boolean isFirstEnter(Context context,String className)
  {
      if(context==null || className==null||"".equalsIgnoreCase(className))
      {
    	  return false;
      }
    	  
      String mResultStr = context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE)
               .getString(KEY_GUIDE_ACTIVITY, "");//取得所有类名 如 com.my.MainActivity
      if(mResultStr.equalsIgnoreCase("false"))
      {
    	  return false;
      }
         
      else
      {
    	  return true;
      }
         
  }
  
  
  private final static int SWITCH_MAINACTIVITY = 1000;
  private final static int SWITCH_GUIDACTIVITY = 1001;
  public Handler mHandler = new Handler(){
      public void handleMessage(Message msg) 
      {
          switch(msg.what)
          {
          case SWITCH_MAINACTIVITY:
              Intent intent = new Intent();
              intent.setClass(SplashActivity.this, MainActivity.class);
              SplashActivity.this.startActivity(intent);
              SplashActivity.this.finish();
              break;
          case SWITCH_GUIDACTIVITY:
             Intent intent2 = new Intent();
              intent2.setClass(SplashActivity.this, GuideActivity.class);
              SplashActivity.this.startActivity(intent2);
              SplashActivity.this.finish();
              break;
          }
          super.handleMessage(msg);
      }
  };
   
  
  
  
}
