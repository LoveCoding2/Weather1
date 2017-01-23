package com.example.seeweather;

import java.util.List;




import com.example.adapter.CityAdapter;
import com.example.bean.CityBean;
import com.example.util.HttpUtil;
import com.example.util.JsonUtil;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NowActivity extends Activity
{
	private ListView listView2;

	
  @Override
protected void onCreate(Bundle savedInstanceState) 
  {

	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.now);
	listView2=(ListView)findViewById(R.id.list2);
 
   

	 
	String cityid=getIntent().getStringExtra("cityid");
	 final String MYURL2="https://api.heweather.com/x3/weather?key=0df6255ab4f94e76bdeb90a4826a063e&cityid="+cityid;
	
	new CityAsyncTask().execute(MYURL2);
	listView2.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Intent intent=new Intent(NowActivity.this,WeatherActivity.class);
			intent.putExtra("myurl2", MYURL2);
			startActivity(intent);
             
			}
	});
	
	
	   
	
	}
  
  @Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
  
  @Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.menu_back:
		
		finish();
		break;

	default:
		break;
	}
	return true;
}
  
  
 class CityAsyncTask extends AsyncTask<String,Void,List<CityBean>>
  {

	@Override
	protected List<CityBean> doInBackground(String... arg0)
	{
		String mcity=HttpUtil.getjsontext(arg0[0]);
		List<CityBean> mlist=JsonUtil.getCityBeans(mcity);
		return mlist;
	}
	
	
	
	@Override
	protected void onPostExecute(List<CityBean> result)
	{
	
		    super.onPostExecute(result);
		
			 CityAdapter cityAdapter=new CityAdapter(NowActivity.this,result);
			 listView2.setAdapter(cityAdapter);
			 cityAdapter.notifyDataSetChanged();
		

			
		

    }
	  
  }
  
  
  
}
