package apitests.com.avlview.app.GETMethods;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
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

public class getAllDriverDispatchTasksTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	JSONObject xmlJSONObj;
	String responseString;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("getAllDriverDispatchTasks");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true, groups = { "GetRequests" })
	public void getAllDriverDispatchTasks() throws ClientProtocolException, IOException, SAXException,
			ParserConfigurationException, URISyntaxException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("apiKey", prop.getProperty("apiKey_Odometer"));
		headers.put("Accept", prop.getProperty("Accept"));

		int firstIndex = serviceurl.indexOf(':');
		String scheme = serviceurl.substring(0, firstIndex).trim();

		int startIndex = url.indexOf("app");
		int endIndex = url.indexOf("api");

		String host = url.substring(startIndex, endIndex - 1);
		String setpath = prop.getProperty("getAllDriverDispatchTasks");

		URIBuilder builder = new URIBuilder();

		builder.setScheme(scheme).setHost(host).setPath(setpath)
				.setParameter("fromDateTime", prop.getProperty("task_fromDate"))
				.setParameter("toDateTime", prop.getProperty("task_toDate"))
				.setParameter("driverId", prop.getProperty("driverId"));

		URI uri = builder.build();
		System.out.println(uri);

		httpresponse = restclient.getparameter(uri, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		JSONObject responsejson = new JSONObject(responseString);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		int result = Integer.parseInt(status);
		Assert.assertEquals(result, testbase.RESPONSE_STATUS_CODE_200);

		JSONArray vmodelArray = responsejson.getJSONArray("tasksList");
		// System.out.println("values from devices: " + spellingsArray);
		int cnt = vmodelArray.length();
		System.out.println(cnt);

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		// System.out.println(allheaders);

	}

}
