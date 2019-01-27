package com.avlview.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.data.users;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostAPITest extends TestBase {

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
		serviceurl = prop.getProperty("URL1");
		apiurl = prop.getProperty("APIURL");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void posAPITestWithHeaders()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		// headers.put("apiKey", " ");

		users usr = new users("mura", "test");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		mapper.writeValue(new File(
				"D:/Learning/Selenium/AVLView.com/Partner Portal/com.avlview.restapitest/src/main/java/com/avlview/data/users.json"),
				usr);

		String resstring = mapper.writeValueAsString(usr);
		System.out.println(resstring);

		httpresponse = restclient.post(url, resstring, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_201);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		System.out.println(responseString);

		// json to java object:
		users usersResObj = mapper.readValue(responseString, users.class); // actual users object
		// System.out.println(usersResObj);

		// JSONObject responsejson = new JSONObject(responseString);
		// System.out.println(responsejson);
		/*
		 * String status = TestUtil.getValueByJPath(responsejson, "/status");
		 * System.out.println(status); Assert.assertEquals(status, "201");
		 */

		System.out.println(usr.getName());
		System.out.println(usersResObj.getName());

		Assert.assertTrue(usr.getName().equals(usersResObj.getName()));

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
