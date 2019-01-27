package com.alview.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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

	public CloseableHttpResponse get(String url, HashMap<String, String> Headermap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		System.out.println(url);

		for (Map.Entry<String, String> entry : Headermap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}

		CloseableHttpResponse HttpResponse = httpClient.execute(httpget);
		// System.out.println(httpget);
		return HttpResponse;

	}

	public CloseableHttpResponse post(String url, String entity, HashMap<String, String> headermap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(new StringEntity(entity));

		for (Map.Entry<String, String> entry : headermap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}

		CloseableHttpResponse HttpResponse = httpclient.execute(httppost);
		return HttpResponse;

	}

	public CloseableHttpResponse getparameter(URI uri, HashMap<String, String> Headermap)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getMethod = new HttpGet(uri);
		//System.out.println(uri);

		for (Map.Entry<String, String> entry : Headermap.entrySet()) {
			getMethod.addHeader(entry.getKey(), entry.getValue());
		}

		CloseableHttpResponse response = null;

		try {
			response = httpclient.execute(getMethod);
		} catch (IOException e) {
			// handle this IOException properly in the future
		} catch (Exception e) {
			// handle this IOException properly in the future
		}

		return response;

	}

}
