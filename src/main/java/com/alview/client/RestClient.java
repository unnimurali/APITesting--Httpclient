package com.alview.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public void get1(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse CloseableHttpResponse = httpClient.execute(httpget);
		int statuscode = CloseableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);

		String responseString = EntityUtils.toString(CloseableHttpResponse.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(responseString);

		System.out.println(responsejson);

		Header[] headersarray = CloseableHttpResponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse HttpResponse = httpClient.execute(httpget);
		return HttpResponse;
		

	}

	public CloseableHttpResponse get(String url,HashMap<String,String> Headermap) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		System.out.println(url);
		
		
		for(Map.Entry<String, String> entry : Headermap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse HttpResponse = httpClient.execute(httpget);
		//System.out.println(httpget);
		return HttpResponse;
		

	}


}
