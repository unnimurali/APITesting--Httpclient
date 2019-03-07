package com.avlview.tests;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
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
import com.avlview.util.TestUtil;

public class GetAPITest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	String jsonPrettyPrintString;
	JSONObject xmlJSONObj;
	String responseString;

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("APIURL");

		url = serviceurl + apiurl;
	}

	@Test(enabled = false)
	public void getAPITest1() throws ClientProtocolException, IOException {

		restclient = new RestClient();
		restclient.get1(url);

	}

	@Test(enabled = false)
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException {

		restclient = new RestClient();
		httpresponse = restclient.get(url);

		System.out.println(httpresponse);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		String responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		JSONObject responsejson = new JSONObject(responseString);
		System.out.println(responsejson);

		String total = TestUtil.getValueByJPath(responsejson, "/total_pages");
		System.out.println(total);

		Assert.assertEquals(total, "4");

		String lastName = TestUtil.getValueByJPath(responsejson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responsejson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responsejson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responsejson, "/data[0]/first_name");

		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

	@Test(enabled = false)
	public void getAPITestWithHeaders()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/xml");
		headers.put("apiKey", "03-Wuw6bz4AeO6nEX0Ni4le");

		httpresponse = restclient.get(url, headers);
		// System.out.println(httpresponse);
		// System.out.println(headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		// System.out.println(statuscode);
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		// System.out.println(responseString);

		responseString = responseString.replace("<devices>", "").replace("</devices>", "");
		// System.out.println(str2);

		try {
			xmlJSONObj = XML.toJSONObject(responseString);
			jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			// System.out.println(jsonPrettyPrintString);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}

		JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
		System.out.println(responsejson);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		System.out.println(status);
		Assert.assertEquals(status, "200");

		String id = TestUtil.getValueByJPath(responsejson, "/device[1]/deviceId");
		System.out.println(id);

		String devicename = TestUtil.getValueByJPath(responsejson, "/device[1]/deviceName");
		System.out.println(devicename);

		JSONArray DevicArray = responsejson.getJSONArray("device");
		// System.out.println("values from devices: " + spellingsArray);
		System.out.println(DevicArray.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
