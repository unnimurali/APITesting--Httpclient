package com.avlview.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.data.groups;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class rough_postgroupxml extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiposturl;
	String apigeturl;
	String url;
	String posturl;
	String geturl;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	String jsonPrettyPrintString;
	JSONObject xmlJSONObj;
	boolean exist = false;

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();

		serviceurl = prop.getProperty("URL");

		apiposturl = prop.getProperty("postaddgroupURL");
		apigeturl = prop.getProperty("getvehiclegroups");

		posturl = serviceurl + apiposturl;
		geturl = serviceurl + apigeturl;
	}

	@Test(enabled = true)
	public void getAPITestWithHeaders()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		// headers.put("Content-Type", "application/xml");
		headers.put("apiKey", "03-Wuw6bz4AeO6nEX0Ni4le");
		// headers.put("Accept", "application/json");

		groups grps = new groups("httpclient200", "#1c1b1b");

		XmlMapper xmlMapper = new XmlMapper();

		String destfilepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\data\\groups.xml";
		xmlMapper.writeValue(new File(destfilepath), grps);

		String resstring = xmlMapper.writeValueAsString(grps);
		// System.out.println(resstring);

		httpresponse = restclient.post(posturl, resstring, headers);
		System.out.println(httpresponse);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		String responseStringpost = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseStringpost);

		Assert.assertEquals(responseStringpost, "Success");

		/**********************************************************/

		httpresponse = restclient.get(geturl, headers);
		System.out.println(httpresponse);

		String responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		String str2 = responseString.replace("<vehiclegroups>", "").replace("</vehiclegroups>", "");

		try {
			xmlJSONObj = XML.toJSONObject(str2);
			jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			// System.out.println(jsonPrettyPrintString);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}

		JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
		// System.out.println(responsejson);

		JSONArray DevicArray = responsejson.getJSONArray("vgroup");
		// System.out.println("values from devices: " + spellingsArray);
		System.out.println(DevicArray.length());

		for (int i = 0; i < DevicArray.length(); i++) {
			JSONObject item = DevicArray.getJSONObject(i); // gets the ith Json object of JSONArray
			String customerId = item.getString("groupName");
			System.out.println(customerId);
			if (customerId.equals("httpclient1")) {
				exist = true;
				break;
			}
		}

		Assert.assertTrue(exist);

		/*********************************************************/

		groups grpResObj = xmlMapper.readValue(resstring, groups.class); // actual users object

		System.out.println(grps.getGroup_name());
		System.out.println(grpResObj.getGroup_name());

		/*
		 * String str2 = responseString.replace("<groups>", "").replace("</groups>",
		 * ""); System.out.println(str2);
		 * 
		 * try { xmlJSONObj = XML.toJSONObject(str2); jsonPrettyPrintString =
		 * xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		 * System.out.println(jsonPrettyPrintString); } catch (JSONException je) {
		 * System.out.println(je.toString()); }
		 */

		/*
		 * String responseString = EntityUtils.toString(httpresponse.getEntity(),
		 * "UTF-8"); // System.out.println(responseString);
		 * 
		 * String str2 = responseString.replace("<devices>", "").replace("</devices>",
		 * ""); // System.out.println(str2);
		 * 
		 * try { xmlJSONObj = XML.toJSONObject(str2); jsonPrettyPrintString =
		 * xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR); //
		 * System.out.println(jsonPrettyPrintString); } catch (JSONException je) {
		 * System.out.println(je.toString()); }
		 * 
		 * JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
		 * System.out.println(responsejson);
		 */

	}

}
