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

public class getTransportationAlertsTest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse httpresponse;

	JSONObject xmlJSONObj;
	String responseString;
	String vId;
	String fDate;
	String tDate;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("getTransportationAlerts");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true, groups = { "GetRequests" })
	public void getTransportationAlerts() throws ClientProtocolException, IOException, SAXException,
			ParserConfigurationException, URISyntaxException {

		restclient = new RestClient();

		HashMap<String, String> headers = new HashMap<String, String>();

		if (System.getenv("ApiKey") != null && !System.getenv("ApiKey").isEmpty()) {
			System.out.println(System.getenv("ApiKey"));
			headers.put("apiKey", System.getenv("ApiKey"));
		} else {
			headers.put("apiKey", prop.getProperty("apiKey_Schoolbus"));
		}

		// headers.put("apiKey", prop.getProperty("apiKey_Schoolbus"));
		headers.put("Accept", prop.getProperty("Accept"));

		int firstIndex = serviceurl.indexOf(':');
		String scheme = serviceurl.substring(0, firstIndex).trim();

		int startIndex = url.indexOf("app");
		int endIndex = url.indexOf("api");

		String host = url.substring(startIndex, endIndex - 1);
		String setpath = prop.getProperty("getTransportationAlerts");

		if (System.getenv("vehicleId") != null && !System.getenv("vehicleId").isEmpty()) {
			System.out.println(System.getenv("vehicleId"));
			vId = System.getenv("vehicleId");
		} else {
			vId = prop.getProperty("Vehicleid");
		}

		if (System.getenv("fromDate") != null && !System.getenv("fromDate").isEmpty() && System.getenv("toDate") != null
				&& !System.getenv("toDate").isEmpty()) {

			System.out.println(System.getenv("fromDate"));
			System.out.println(System.getenv("toDate"));

			fDate = System.getenv("fromDate");
			tDate = System.getenv("toDate");

		} else {

			fDate = prop.getProperty("fromDate");
			tDate = prop.getProperty("toDate");

			System.out.println(fDate);
			System.out.println(tDate);
		}

		URIBuilder builder = new URIBuilder();

		/*
		 * builder.setScheme(scheme).setHost(host).setPath(setpath)
		 * .setParameter("vehicleId", prop.getProperty("Vehicleid_Schoolbus"))
		 * .setParameter("fromDate", prop.getProperty("fromDate"))
		 * .setParameter("toDate", prop.getProperty("toDate"));
		 */

		builder.setScheme(scheme).setHost(host).setPath(setpath).setParameter("vehicleId", vId)
				.setParameter("fromDate", fDate).setParameter("toDate", tDate);

		URI uri = builder.build();

		httpresponse = restclient.getparameter(uri, headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		JSONObject responsejson = new JSONObject(responseString);

		String status = TestUtil.getValueByJPath(responsejson, "/status");
		int result = Integer.parseInt(status);
		Assert.assertEquals(result, testbase.RESPONSE_STATUS_CODE_200);

		JSONArray vmodelArray = responsejson.getJSONArray("schoolAlertlist");
		// System.out.println("values from devices: " + spellingsArray);
		int cnt = vmodelArray.length();
		System.out.println(cnt);

		if (cnt >= 1) {
			String id = TestUtil.getValueByJPath(responsejson, "/schoolAlertlist[0]/alertDescription");
			System.out.println(id);

			String name = TestUtil.getValueByJPath(responsejson, "/schoolAlertlist[0]/alertMessage");
			System.out.println(name);
		}

		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headersarray) {
			allheaders.put(header.getName(), header.getValue());

		}

		// System.out.println(allheaders);

	}

}
