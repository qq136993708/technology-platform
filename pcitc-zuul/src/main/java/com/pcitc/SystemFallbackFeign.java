/**   
* @author zhf  
* @date 2018年3月2日 上午9:43:49 
* @version V1.0   
*/
package com.pcitc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @author zhf
 * zuul在代理访问pcitc-system-provider等微服务时，如果访问不到，调用此回调
 */
@Component
public class SystemFallbackFeign implements ZuulFallbackProvider {
	
	@Override  
    public String getRoute() {  
        //return "pcitc-system-provider";
		//所有的微服务provider都适用于此规则
        return "*";
    }
	
	@Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
            	System.out.println("getStatusCode调用的provider方法在执行==="+HttpStatus.OK);
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
            	System.out.println("getRawStatusCode调用的provider方法在执行==="+this.getStatusCode().value());
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
            	System.out.println("getStatusText调用的provider方法在执行==="+this.getStatusCode().getReasonPhrase());
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {
            	System.out.println("close调用的provider方法在执行===");
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("Service不可用".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }

}
