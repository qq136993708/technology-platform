package com.pcitc.web.utils;

public class HttpClientUtils 
{
	/*public static void test() throws ClientProtocolException, IOException
	{
		String url = "";
		//CloseableHttpClient  client = HttpClients.createDefault();
		CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		String id = IdUtil.createUUID();
		String cm = (System.currentTimeMillis()/1000)+"";
		
		BasicClientCookie cookie = new BasicClientCookie("PHPSESSID", id); 
        cookie.setVersion(0);  
        cookie.setPath("/"); 
        cookieStore.addCookie(cookie);
        
        BasicClientCookie cookie2 = new BasicClientCookie("Hm_lvt_"+id, cm); 
        cookie2.setVersion(0);  
        cookie2.setPath("/"); 
        cookieStore.addCookie(cookie2);
        
        BasicClientCookie cookie3 = new BasicClientCookie("Hm_lpvt_"+id, cm); 
        cookie3.setVersion(0);  
        cookie3.setDomain("/pms/");   //设置范围
        cookie3.setPath("/"); 
        cookieStore.addCookie(cookie3);
		
		
	    // Post请求
	    HttpPost httppost = new HttpPost(url);
	    httppost.setHeader("User-Agent","Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255");
	    httppost.setHeader("Referer", "https://mp.weixin.qq.com");
	    //httppost.setHeader("Accept","application/json, text/javascript; q=0.01");
	    httppost.setHeader("Accept-Encoding","gzip, deflate");
	    
	   
	    
	    //发送Post请求
	    CloseableHttpResponse  response = client.execute(httppost);
	    String result = EntityUtils.toString(response.getEntity(), "utf-8"); 
        System.out.println(result);
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		for(int i = 0;i<10;i++) 
		{
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						test();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}*/
 
}