/*package com.pcitc.service.transaction;

import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.springframework.stereotype.Service;

@Service
public class TxManagerHttpRequestServiceImpl implements TxManagerHttpRequestService {

	@Override
	public String httpGet(String url) {
		// GET请求前
		String res = HttpUtils.get(url);
		// GET请求后
		return res;
	}

	@Override
	public String httpPost(String url, String params) {
		// POST请求前
		String res = HttpUtils.post(url, params);
		// POST请求后
		return res;
	}
}
*/