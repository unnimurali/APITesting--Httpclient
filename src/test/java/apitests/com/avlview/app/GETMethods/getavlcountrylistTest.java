package apitests.com.avlview.app.GETMethods;

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

public class getavlcountrylistTest extends TestBase {

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
		apiurl = prop.getProperty("getavlcountrylistURL");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void getavlcountrylist()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));

		httpresponse = restclient.get(url, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		responseString = responseString.replace("<countrylist>", "").replace("</countrylist>", "");

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

		String id = TestUtil.getValueByJPath(responsejson, "/country[92]/countryId");
		System.out.println(id);
		Assert.assertEquals(id, "1");

		String name = TestUtil.getValueByJPath(responsejson, "/country[92]/countryName");
		System.out.println(name);
		Assert.assertEquals(name, "India");

		JSONArray DevicArray = responsejson.getJSONArray("country");
		System.out.println(DevicArray.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
