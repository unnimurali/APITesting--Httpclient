package apitests.com.avlview.app.POSTMethods;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.alview.client.RestClient;
import com.avlview.base.TestBase;

public class saveFenceZoneTest extends TestBase {

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
		apiurl = prop.getProperty("saveFenceZone");

		url = serviceurl + apiurl;
	}

	@Test(enabled = true)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException, SAXException,
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
		String setpath = prop.getProperty("saveFenceZone");

		URIBuilder builder = new URIBuilder();

		builder.setScheme(scheme).setHost(host).setPath(setpath)
				.setParameter("wayPointName", prop.getProperty("wayPointName"))
				.setParameter("longitude", prop.getProperty("longitude"))
				.setParameter("latitude", prop.getProperty("latitude"))
				.setParameter("wayPointBuffer", prop.getProperty("wayPointBuffer"));

		URI uri = builder.build();

		httpresponse = restclient.postparameter(uri, "", headers);

		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);

		responseString = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		System.out.println(responseString);
		Assert.assertEquals(responseString, "Success");

	}

}
