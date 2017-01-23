package com.example.util;

import java.io.BufferedReader;





import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.ssl.NoSSLv3SocketFactory;

public class HttpUtil {
  public static String getjsontext(String url)
  {
	  StringBuffer stringBuffer=new StringBuffer();
	  try {
		URL myurl=new URL(url);
		SSLContext sslcontext = SSLContext.getInstance("TLSv1");
       sslcontext.init(null,null,null);
       SSLSocketFactory NoSSLv3Factory = new NoSSLv3SocketFactory(sslcontext.getSocketFactory());
       HttpsURLConnection.setDefaultSSLSocketFactory(NoSSLv3Factory);
		HttpsURLConnection httpsURLConnection=(HttpsURLConnection) myurl.openConnection();
		InputStream inputStream=httpsURLConnection.getInputStream();
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String line;
		while ((line=bufferedReader.readLine())!=null)
		{
		   stringBuffer.append(line);
		}
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (KeyManagementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return stringBuffer.toString();
	}

 public static boolean hasInternet(Activity activity)
  {
	  ConnectivityManager connectivityManager=(ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
	  NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
	  if (networkInfo==null || !networkInfo.isConnected())
	  {
		  return false;
		
	  }
	  if (networkInfo.isRoaming())
	  {
		return true;
	  }
	  return true;
	
	  
  }
  
 
}
