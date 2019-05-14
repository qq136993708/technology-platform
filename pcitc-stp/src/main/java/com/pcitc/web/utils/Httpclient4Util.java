package com.pcitc.web.utils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Httpclient4Util {
	
	public static String get(String urlWithParams) throws Exception
	{
		CloseableHttpResponse response =null;
		CloseableHttpClient httpclient =null;
		String jsonStr="";
		try {
         httpclient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(urlWithParams);   
        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()  
                .setConnectionRequestTimeout(500)
                .setConnectTimeout(500)  
                .setSocketTimeout(500).build();  
        httpget.setConfig(requestConfig); 
        response = httpclient.execute(httpget);        
        HttpEntity entity = response.getEntity();        
        int status=response.getStatusLine().getStatusCode();
		if(status==200)
		{
			jsonStr = EntityUtils.toString(entity, "utf-8");
		}
        System.out.println("----------------"+jsonStr);
        
		} catch (Exception e) 
		 {  
	            e.printStackTrace();  
	     }finally
		 {  
	            if(response != null)
	            {  
	                try {  
	                	response.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(httpclient != null)
	            {  
	                try {  
	                	httpclient.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } 
		
         
        return jsonStr;
}
	    
	
	
	public static String post(String url,List<NameValuePair> params) throws ClientProtocolException, IOException
	{
		String jsonStr="";
		CloseableHttpResponse response =null;
		CloseableHttpClient httpclient =null;
		HttpPost httppost=null;
		 try {  
			 System.out.println("------postSSLJson发送url： "+url);
	        httpclient = HttpClientBuilder.create().build();
	        httppost = new HttpPost(url);
	        httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	        response = httpclient.execute(httppost);
	        HttpEntity entity = response.getEntity();
	        int status=response.getStatusLine().getStatusCode();
			if(status==200)
			{
				jsonStr = EntityUtils.toString(entity, "utf-8");
				System.out.println("------postSSLJson返回信息： "+jsonStr);
			}else
			{
				System.out.println("------postSSLJson返回信息： "+response.toString());
			}
		 } catch (Exception e) 
		 {  
	            e.printStackTrace();  
	     }finally
		 {  
	    	    httppost.releaseConnection();
	            if(response != null)
	            {  
	                try {  
	                	response.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(httpclient != null)
	            {  
	                try {  
	                	httpclient.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } 
		 return jsonStr;
	        
	}
	
	public static String getSSL(String url) throws Exception
   {
		
		 System.out.println("------发送url： "+url);
		String jsonStr="";
		CloseableHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			client = createSSLClientDefault();
			HttpGet get = new HttpGet(url);
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			int status=response.getStatusLine().getStatusCode();
			if(status==200)
			{
				jsonStr = EntityUtils.toString(entity, "utf-8");
			}
		   System.out.println(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonStr;
		
	}
	
	
	public static String postSSLJson(String url,String json) throws ClientProtocolException, IOException
	{
		String jsonStr="";
		CloseableHttpResponse response =null;
		CloseableHttpClient httpclient =null;
		HttpPost httppost=null;
		 try {  
			 System.out.println("------postSSLJson发送url： "+url+"  内容："+json);
	        httpclient = createSSLClientDefault();
	        httppost = new HttpPost(url);
	        StringEntity s = new StringEntity(json, "utf-8");
			s.setContentEncoding("utf-8");
			s.setContentType("application/json");//发送json数据需要设置contentType
			httppost.setEntity(s);
	        response = httpclient.execute(httppost);
	        HttpEntity entity = response.getEntity();
	        int status=response.getStatusLine().getStatusCode();
			if(status==200)
			{
				jsonStr = EntityUtils.toString(entity, "utf-8");
				System.out.println("------postSSLJson返回信息： "+jsonStr);
			}else
			{
				System.out.println("------postSSLJson返回信息： "+response.toString());
			}
	
	       
		 } catch (Exception e) 
		 {  
	            e.printStackTrace();  
	     }finally
		 {  
	    	    httppost.releaseConnection();
	            if(response != null)
	            {  
	                try {  
	                	response.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(httpclient != null)
	            {  
	                try {  
	                	httpclient.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } 
		 return jsonStr;
	        
	}
	
	
	
	
	public static String postSSL(String url,List<NameValuePair> params) throws ClientProtocolException, IOException
	{
		String jsonStr="";
		CloseableHttpResponse response =null;
		CloseableHttpClient httpclient =null;
		HttpPost httppost=null;
		 try {  
	        httpclient = createSSLClientDefault();
	        httppost = new HttpPost(url);
	        if(params!=null)
	        {
	        	  httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	        }
	      
	        response = httpclient.execute(httppost);
	        System.out.println(response.toString());
	        HttpEntity entity = response.getEntity();
	        int status=response.getStatusLine().getStatusCode();
			if(status==200)
			{
				jsonStr = EntityUtils.toString(entity, "utf-8");
			}
	        System.out.println(jsonStr);
		 } catch (Exception e) 
		 {  
	            e.printStackTrace();  
	     }finally
		 {  
	    	    httppost.releaseConnection();
	            if(response != null)
	            {  
	                try {  
	                	response.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(httpclient != null)
	            {  
	                try {  
	                	httpclient.close();  
	                } catch (IOException e) 
	                {  
	                    e.printStackTrace();  
	                }  
	            }  
	        } 
		 return jsonStr;
	        
	}
	
	
	public static CloseableHttpClient createSSLClientDefault() throws Exception {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() 
			{
						public boolean isTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}
	
	
	
	public static void main(String[] args)throws Exception  {
		get("http://10.1.4.10:80/kjb/_layouts/15/ZBAppPage/oacount.aspx");
	}
	
	
  

}
