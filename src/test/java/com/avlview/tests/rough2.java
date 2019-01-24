package com.avlview.tests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.avlview.util.TestUtil;

public class rough2 {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("https://restcountries.eu/rest/v2/capital/Washington");
		HttpResponse response = client.execute(request);

		// 1. status code:
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("the status code is: " + statusCode);

		Assert.assertEquals(200, statusCode);

		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity); // with []
		System.out.println("the response is : " + responseString);

		responseString = responseString.substring(1, responseString.length());
		responseString = responseString.substring(0, responseString.length() - 1);
		System.out.println("actual json response string is: " + responseString);

		JSONObject jsonResponseObj = new JSONObject(responseString);
		System.out.println("the actual json response is: " + jsonResponseObj);

		String total = TestUtil.getValueByJPath(jsonResponseObj, "/name");
		System.out.println(total);

		// get the values from json object:
		String countryName = jsonResponseObj.getString("name");
		System.out.println("the country name is: " + countryName);

		// get the values from json array having only values:
		JSONArray spellingsArray = jsonResponseObj.getJSONArray("altSpellings");
		System.out.println("values from Altspellings: " + spellingsArray);

		// get the values from json array having keys and values:
		JSONArray currenciesArray = jsonResponseObj.getJSONArray("currencies");
		System.out.println(currenciesArray.getJSONObject(0));
		System.out.println(currenciesArray.getJSONObject(0).get("code").toString());
		System.out.println(currenciesArray.getJSONObject(0).get("symbol").toString());

		JSONArray regionalBlocsArray = jsonResponseObj.getJSONArray("regionalBlocs");
		System.out.println(regionalBlocsArray.getJSONObject(0).get("acronym").toString());

		System.out.println(regionalBlocsArray.getJSONObject(0).get("otherNames"));
		String otherNames = regionalBlocsArray.getJSONObject(0).get("otherNames").toString();
		// ["Tratado de Libre Comercio de América del Norte","Accord de Libre-échange
		// Nord-Américain"]
		String otherNamesArray[] = otherNames.split(",");
		for (int i = 0; i < otherNamesArray.length; i++) {
			System.out.println(otherNamesArray[i]);
		}

	}

}
