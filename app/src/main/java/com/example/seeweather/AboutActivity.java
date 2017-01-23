package com.example.seeweather;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutActivity extends Activity
{
	private ImageButton aboutiImageButton;
	
   @Override
  protected void onCreate(Bundle savedInstanceState)
   {   
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.about);
	aboutiImageButton=(ImageButton)findViewById(R.id.aboutimagebutton);
	aboutiImageButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			finish();
			
		}
	});
   }
   
 
}
