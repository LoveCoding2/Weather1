package com.example.seeweather;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuideActivity extends Activity implements OnPageChangeListener
{
	private ViewPager viewPager;
	 private View view1, view2, view3;
     private List<View> viewList;
     private Button splashButton;
     private ImageView[] imageViews;
     private int currentindex;
  @Override
protected void onCreate(Bundle savedInstanceState)
  {
	
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.guide);
	
	 initView();
     initpoint();
     PagerAdapter mpagerAdapter = new PagerAdapter() {  
               
     @Override  
     public boolean isViewFromObject(View arg0, Object arg1) {  

         return arg0 == arg1;  
     }  

     @Override  
     public int getCount() {  

         return viewList.size();  
     }  

     @Override  
     public void destroyItem(ViewGroup container, int position,  
             Object object) {  
         container.removeView(viewList.get(position));  

     }  

     @Override  
     public int getItemPosition(Object object) {  

         return super.getItemPosition(object);  
     }  

    
     @Override  
     public Object instantiateItem(ViewGroup container, int position) {  
         container.addView(viewList.get(position));  
        
         return viewList.get(position);  
     }  

 };  
     viewPager.setAdapter(mpagerAdapter);
  }

  
 private void initpoint()
 {
	 LinearLayout pointlLayout=(LinearLayout)findViewById(R.id.guidelayout);
	 imageViews=new ImageView[viewList.size()];
	 for (int i = 0; i < imageViews.length; i++) {
		imageViews[i]=(ImageView) pointlLayout.getChildAt(i);
	}
	 currentindex=0;
	 imageViews[currentindex].setImageResource(R.drawable.touched);
	 
 }
 
 private void setcurrentpoint(int position)
 {
	 if (currentindex<0 || currentindex==position || currentindex>imageViews.length-1) {
		return;
	}
	 imageViews[currentindex].setImageResource(R.drawable.untouched);
	 imageViews[position].setImageResource(R.drawable.touched);
	 currentindex=position;
 }
  
  private void initView()
  {
	  viewPager=(ViewPager)findViewById(R.id.viewPager);
      viewList = new ArrayList<View>();

      LayoutInflater layoutInflate = getLayoutInflater().from(GuideActivity.this);

      view1 = layoutInflate.inflate(R.layout.view1, null);
      view2 = layoutInflate.inflate(R.layout.view2, null);
      view3 = layoutInflate.inflate(R.layout.view3, null);

      viewList.add(view1);
      viewList.add(view2);
      viewList.add(view3);
      viewPager.setOnPageChangeListener(this);
      splashButton=(Button)view3.findViewById(R.id.splashbutton);
      splashButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0)
		{
			setGuided();
			Intent intent=new Intent(GuideActivity.this,MainActivity.class);
			startActivity(intent);
			finish();
		}
	});
      
  }
  
  private static final String SHAREDPREFERENCES_NAME = "my_pref";
  private static final String KEY_GUIDE_ACTIVITY = "guide_activity";
  private void setGuided()
  {
      SharedPreferences settings = getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
      SharedPreferences.Editor editor = settings.edit();
      editor.putString(KEY_GUIDE_ACTIVITY, "false");
      editor.commit();
  }


@Override
public void onPageScrollStateChanged(int arg0)
{
	// TODO Auto-generated method stub
	
}


@Override
public void onPageScrolled(int arg0, float arg1, int arg2)
{
	// TODO Auto-generated method stub
	
}


@Override
public void onPageSelected(int i)
{
	
	setcurrentpoint(i);
}


}
