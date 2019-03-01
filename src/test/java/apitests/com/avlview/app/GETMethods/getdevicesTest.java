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

public class getdevicesTest extends TestBase {

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
		apiurl = prop.getProperty("getdevicesURL");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void getAPITestWithHeaders()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));
		// headers.put("Accept", prop.getProperty("Accept"));

		httpresponse = restclient.get(url, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		responseString = responseString.replace("<devices>", "").replace("</devices>", "");
		try {
			xmlJSONObj = XML.toJSONObject(responseString);
			jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}

		JSONObject responsejson = new JSONObject(jsonPrettyPrintString);
		// System.out.println(responsejson);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		// System.out.println(status);
		Assert.assertEquals(status, "200");

		String id = TestUtil.getValueByJPath(responsejson, "/device[24]/deviceId");
		// System.out.println(id);
		Assert.assertEquals(id, "463");

		String name = TestUtil.getValueByJPath(responsejson, "/device[24]/deviceName");
		// System.out.println(name);
		Assert.assertEquals(name, "FM 5500");

		JSONArray DevicArray = responsejson.getJSONArray("device");
		// System.out.println("values from devices: " + spellingsArray);
		int cnt = DevicArray.length();
		// System.out.println(cnt);
		Assert.assertEquals(cnt, 133);

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
