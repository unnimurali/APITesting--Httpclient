package apitests.com.avlview.app.GETMethods;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;
import com.avlview.util.TestUtil;

public class getplansTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	JSONObject xmlJSONObj;
	String responseString;

	@BeforeMethod
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("getplansURL");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void getplans() throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));
		headers.put("Accept", prop.getProperty("Accept"));

		httpresponse = restclient.get(url, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(responseString);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		Assert.assertEquals(status, "200");

		String id = TestUtil.getValueByJPath(responsejson, "/plan[3]/planId");
		Assert.assertEquals(id, "8");

		JSONArray DevicArray = responsejson.getJSONArray("plan");
		int cnt = DevicArray.length();
		System.out.println(cnt);
		Assert.assertEquals(cnt, 5);

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		// System.out.println(allheaders);

	}

}
