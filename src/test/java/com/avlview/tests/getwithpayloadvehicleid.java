package com.avlview.tests;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class getwithpayloadvehicleid extends TestBase {

	TestBase testbase;
	String serviceurl;
	// String apiposturl;
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

		// apiposturl = prop.getProperty("postaddgroupURL");
		apigeturl = prop.getProperty("getapnlistbyvehicleid");

		// posturl = serviceurl + apiposturl;
		geturl = serviceurl + apigeturl;
		System.out.println(geturl);
	}

	@Test(enabled = false)
	public void getAPITestWithHeaders()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/xml");
		// headers.put("apiKey", "03-Wuw6bz4AeO6nEX0Ni4le");
		headers.put("apiKey", "eFYqcQJOYW563VDxPia4");
		headers.put("Accept", "application/json");

		// apnlistbycountryid alc = new apnlistbycountryid("1");
		// Row alc = new Row("19838");

		XmlMapper xmlMapper = new XmlMapper();
		/*
		 * xmlMapper.writeValue(new File(
		 * "D:/Learning/Selenium/AVLView.com/Partner Portal/com.avlview.restapitest/src/main/java/com/avlview/data/groups.xml"
		 * ), alc);
		 */

		String destfilepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\avlview\\data\\Row.xml";

		// xmlMapper.writeValue(new File(destfilepath), alc);

		// File file = new File(
		// "D:/Learning/Selenium/AVLView.com/Partner
		// Portal/com.avlview.restapitest/src/main/java/com/avlview/data/groups.xml");

		// String resstring = xmlMapper.writeValueAsString(alc);
		// System.out.println(resstring);

		// httpresponse = restclient.post(geturl, resstring, headers);
		// System.out.println(httpresponse);

		// int statuscode = httpresponse.getStatusLine().getStatusCode();
		// System.out.println(statuscode);
		// Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		// String responseStringpost = EntityUtils.toString(httpresponse.getEntity(),
		// "UTF-8");
		// System.out.println(responseStringpost);

		// Assert.assertEquals(responseStringpost, "Success");

	}

}
