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

	String dId;
	String fDate;
	String tDate;

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

		if (System.getenv("ApiKey") != null && !System.getenv("ApiKey").isEmpty()) {
			System.out.println(System.getenv("ApiKey"));
			headers.put("apiKey", System.getenv("ApiKey"));
		} else {
			headers.put("apiKey", prop.getProperty("apiKey_Odometer"));
		}

		// headers.put("apiKey", prop.getProperty("apiKey_Odometer"));
		headers.put("Accept", prop.getProperty("Accept"));

		int firstIndex = serviceurl.indexOf(':');
		String scheme = serviceurl.substring(0, firstIndex).trim();

		int startIndex = url.indexOf("app");
		int endIndex = url.indexOf("api");

		String host = url.substring(startIndex, endIndex - 1);
		String setpath = prop.getProperty("getAllDriverDispatchTasks");

		if (System.getenv("driverId") != null && !System.getenv("driverId").isEmpty()) {
			System.out.println(System.getenv("driverId"));
			dId = System.getenv("driverId");
		} else {
			dId = prop.getProperty("driverId");
		}

		if (System.getenv("fromDate") != null && !System.getenv("fromDate").isEmpty() && System.getenv("toDate") != null
				&& !System.getenv("toDate").isEmpty()) {

			System.out.println(System.getenv("fromDate"));
			System.out.println(System.getenv("toDate"));

			fDate = System.getenv("fromDate");
			tDate = System.getenv("toDate");

		} else {

			fDate = prop.getProperty("task_fromDate");
			tDate = prop.getProperty("task_toDate");

			System.out.println(fDate);
			System.out.println(tDate);
		}

		URIBuilder builder = new URIBuilder();

		/*
		 * builder.setScheme(scheme).setHost(host).setPath(setpath)
		 * .setParameter("fromDateTime", prop.getProperty("task_fromDate"))
		 * .setParameter("toDateTime", prop.getProperty("task_toDate"))
		 * .setParameter("driverId", prop.getProperty("driverId"));
		 */

		builder.setScheme(scheme).setHost(host).setPath(setpath).setParameter("fromDate", fDate)
				.setParameter("toDate", tDate).setParameter("driverId", dId);

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
