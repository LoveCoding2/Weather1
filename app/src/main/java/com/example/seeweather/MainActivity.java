package com.example.seeweather;

import java.util.List;



import com.example.adapter.MyAdapter;
import com.example.util.HttpUtil;
import com.example.util.JsonUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	 private ListView listView1;
	 //private ProgressDialog progressDialog;
     /*private static int page=1;
     private boolean is_divpage;
     private View footer;
     private boolean isLoading;
     private int sum=17;*/
	  private MyAdapter myAdapter;
	  //private List<String> total=new ArrayList<String>();
	 private String MYURL="https://api.heweather.com/x3/citylist?search=allchina&key=0df6255ab4f94e76bdeb90a4826a063e";
	
	 
 
	
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		listView1=(ListView)findViewById(R.id.list1);
		/*LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		footer = inflater.inflate(R.layout.footer_layout, null);
		footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
		listView1.addFooterView(footer);*/
		  /*progressDialog=new ProgressDialog(MainActivity.this);
	        progressDialog.setTitle("12");
	        progressDialog.setMessage("23");*/
	    	new MyAsynctask().execute(MYURL);
		//myAdapter=new MyAdapter(MainActivity.this);
	
		
		/*listView1.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
			  if (is_divpage && scrollState==OnScrollListener.SCROLL_STATE_FLING) 
			  {
				  if (!isLoading)
				  {
						isLoading = true;
						footer.findViewById(R.id.load_layout).setVisibility(
								View.VISIBLE);
						 new MyAsynctask().execute(MYURL);
					}
				 
				
			  }
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				is_divpage=(firstVisibleItem+visibleItemCount==totalItemCount);
				
			}
		});
		*/
      
	
		
			
		
	    new Thread(new Runnable() {
			
			@Override
			public void run() {
					
			 String murl=HttpUtil.getjsontext(MYURL);
			 List<String> citsStrings=JsonUtil.getcityid(murl);
			 Message message=new Message();
			 message.what=01;
			 message.obj=citsStrings;
			 handler.sendMessage(message);
				
			}
		}).start();
			
		

	}

	
	
	private Handler handler=new Handler()
	{
		public void handleMessage(android.os.Message msg) 
		{
			switch (msg.what) {
			case 01:
			    final List<String> sList=(List<String>) msg.obj;
			    listView1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View view,
							int position, long arg3) {
						
						Intent intent=new Intent(MainActivity.this,NowActivity.class);
						String item=String.valueOf(myAdapter.getItemId(position));
						int num= Integer.parseInt(item);
						intent.putExtra("cityid", sList.get(num));
						startActivity(intent);
                          
						
					}
				});
				break;

			default:
				break;
			}
		}
	};
    
	
	
	class MyAsynctask extends AsyncTask<String, Void,List<String>>
	{

		@Override
		protected List<String> doInBackground(String... arg0)
		{
			String src=HttpUtil.getjsontext(arg0[0]);
		     List<String> myList=JsonUtil.getcityinfo(src);
		    return myList;
			
	    }
		
		/*@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			//progressDialog.show();
			isLoading=true;
		}*/
		
		
		@Override
		protected void onPostExecute(final List<String> result)
		{
		
			super.onPostExecute(result);
            if (!HttpUtil.hasInternet(MainActivity.this))
			{
				Toast.makeText(MainActivity.this, "Õ¯¬Á“Ï≥££¨«ÎºÏ≤ÈÕ¯¬Á «∑Ò¡¨Ω”", Toast.LENGTH_LONG).show();
			}
            myAdapter=new MyAdapter(MainActivity.this,result);
            listView1.setAdapter(myAdapter);
          
            myAdapter.notifyDataSetChanged();
        
            /*total.addAll(result);
            myAdapter.binddata(total);
            if (page==1)
            {
            	listView1.setAdapter(myAdapter);
				
			}
            myAdapter.count+=sum;
       		myAdapter.notifyDataSetChanged();
       		page++;
       		*/
            //progressDialog.dismiss();
       		/*isLoading = false;
    		footer.findViewById(R.id.load_layout).setVisibility(
    				View.GONE);*/
		} 
       
	}
}
			
            
         
		
	



	


	



	
	


	


