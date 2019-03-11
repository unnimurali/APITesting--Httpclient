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

public class getvehiclemakesTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;
	String runstatus;
	boolean status;

	JSONObject xmlJSONObj;
	String responseString;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("getvehiclemakesURL");

		url = serviceurl + apiurl;

		System.out.println(System.getenv("getvehiclemakesTest"));
		runstatus = System.getenv("getvehiclemakesTest");
		status = Boolean.parseBoolean(runstatus);
		System.out.println(status);

	}

	@Test(groups = { "GetRequests" })
	public void getvehiclemakes()
			throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put("apiKey", prop.getProperty("apiKey_Get"));
		headers.put("Accept", prop.getProperty("Accept"));

		System.out.println(url);
		System.out.println(serviceurl);
		System.out.println(apiurl);

		httpresponse = restclient.get(url, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();

		Assert.assertEquals(statuscode, testbase.RESPONSE_STATUS_CODE_200);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		JSONObject responsejson = new JSONObject(responseString);
		// System.out.println(responsejson);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		// System.out.println(status);
		Assert.assertEquals(status, "200");

		String id = TestUtil.getValueByJPath(responsejson, "/vehiclemake[1]/makeId");
		System.out.println("Make id is" + id);
		Assert.assertEquals(id, "17");

		String name = TestUtil.getValueByJPath(responsejson, "/vehiclemake[1]/makeName");
		System.out.println("Make name is" + name);
		Assert.assertEquals(name, "AC");

		JSONArray DevicArray = responsejson.getJSONArray("vehiclemake");
		System.out.println("Total make count is " + DevicArray.length());

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		System.out.println(allheaders);

	}

}
